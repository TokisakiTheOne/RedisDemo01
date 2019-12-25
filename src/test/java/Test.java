import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyh.dao.StudentDao;
import com.yyh.dao.StudentDaoImpl;
import com.yyh.po.Student;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author YanYuHang
 * @create 2019-12-21-10:13
 */
public class Test {


    @org.junit.Test
    public void test() {
        //1.创建java可以操作redis的客户端
        //  new Jedis(Host主机地址,Port端口号)
        Jedis jedis = new Jedis("192.168.102.166", 6379);
        //2.可以使用客户端 进行操作
        //  get(key)    根据key值 获取value
        //  set(key,value)  添加数据
        /***********************************************************/
        //  del(key)    根据key值  删除value
        jedis.del("test");
        //  exists(key) 判断key值是否存在  1 存在 true   0 不存在 false
        Boolean test = jedis.exists("test01");
        System.out.println("test = " + test);
        //  keys(key的特征)        可以获得多个key值
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println("key = " + key + "  value=" + jedis.get(key));
        }
        //  flushall    删除所有的key
        jedis.flushAll();

    }

    @org.junit.Test
    public void testJavaToJson() {
        List<Student> list = new ArrayList<Student>();
        Student student = new Student();
        student.setStuId(1);
        student.setStuName("张三");
        student.setStuPwd("123456");
        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);

        //1.创建对象映射
        ObjectMapper om = new ObjectMapper();
        //2.调用方法进行转换操作
        String s = "";
        try {
            s = om.writeValueAsString(list);
            System.out.println("s = " + s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Jedis jedis = new Jedis("192.168.102.166", 6379);

        jedis.set("student", s);

    }

    @org.junit.Test
    public void testJsonToJava() {
        Jedis jedis = new Jedis("192.168.102.166", 6379);
        String student_1 = jedis.get("student");
        //1.创建对象映射
        ObjectMapper om = new ObjectMapper();
        //2.把json字符串转换为java对象
        try {
            JavaType javaType =om.getTypeFactory().constructParametricType(List.class,Student.class);
            List<Student> student = om.readValue(student_1, javaType);
            for (Student student1 : student) {
                System.out.println("student1 = " + student1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    StudentDao  sd = new StudentDaoImpl();
    @org.junit.Test
    public void test1() {
        Student student = new Student();
        student.setStuId(1);
        student.setStuName("张三");
        student.setStuPwd("123456");
        sd.insert(student);
    }
    @org.junit.Test
    public void test2() {
        Student student = sd.selectById(2);
        System.out.println("student = " + student);
    }
}
