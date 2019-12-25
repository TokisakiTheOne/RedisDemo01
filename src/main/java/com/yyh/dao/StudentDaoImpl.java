package com.yyh.dao;

import com.yyh.po.Student;
import com.yyh.utils.JsonJavaUtils;
import redis.clients.jedis.Jedis;

/**
 * @author YanYuHang
 * @create 2019-12-25-14:56
 */
public class StudentDaoImpl implements StudentDao {
    public Student selectById(int stuId) {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        String json = jedis.get("student_" + stuId);
        if(json!=null){
            return (Student) JsonJavaUtils.jsonToJava(json,Student.class);
        }
        return null;
    }

    public int insert(Student student) {
        String json = JsonJavaUtils.javaToJson(student);
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.set("student_"+student.getStuId(),json);
        return 0;
    }
}
