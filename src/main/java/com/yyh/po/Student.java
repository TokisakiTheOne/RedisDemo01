package com.yyh.po;

/**
 * @author YanYuHang
 * @create 2019-12-21-11:11
 */
public class Student {
    private int stuId;
    private String stuName;
    private String stuPwd;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }
}
