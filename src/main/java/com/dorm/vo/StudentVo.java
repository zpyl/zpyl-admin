package com.dorm.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 学生信息的前端展示
 */
public class StudentVo {
    /**
     * 学号
     */
    private String id;

    private String name;
    /**
     * 0：男 1：女
     */
    private Integer sex;
    /**
     * 学院编号
     */
    private Integer collegeId;
    /**
     * 学院名称
     */
    private String collegeName;
    /**
     * 专业号
     */
    private Integer subjectId;
    /**
     * 专业名称
     */
    private String subjectName;

    private Integer age;

    private String telephone;

    /**
     * 楼编号
     */
    private Integer hostelId;
    /**
     * 楼名称
     */
    private String hostelName;
    /**
     * 寝室号
     */
    private Integer bedroomId;
    /**
     * 入住时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    /**
     * 公寓手机号
     */
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public Integer getBedroomId() {
        return bedroomId;
    }

    public void setBedroomId(Integer bedroomId) {
        this.bedroomId = bedroomId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
