package com.yyh.dao;

import com.yyh.po.Student;

/**
 * @author YanYuHang
 * @create 2019-12-25-14:52
 */
public interface StudentDao {

    /**
     * 根据查询
     * @param stuId
     * @return
     */
    Student  selectById(int stuId);

    /**
     * 增加
     * @param student
     * @return
     */
    int insert(Student student);
}
