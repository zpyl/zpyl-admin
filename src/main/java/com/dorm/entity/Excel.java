package com.dorm.entity;

public class Excel {
    /**
     * 学号
     */
    private String stuId;

    private String stuName;
    /**
     * 0：男 1：女
     */
    private Integer sex;
    /**
     * 学院
     */
    private String collegeName;
    /**
     * 专业号
     */
    private String subjectName;

    /**
     * 手机号
     */
    private String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Excel{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex=" + sex +
                ", collegeName=" + collegeName +
                ", subjectName=" + subjectName +
                ", age=" + age +
                '}';
    }
}
