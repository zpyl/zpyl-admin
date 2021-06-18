package com.dorm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jboss.logging.Field;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生实体类
 */
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = -70546311454501663L;
    /**
     * 学号
     */
    @Id
    @Column(name = "stu_id")
    private String id;


    @Column(name="stu_name")
    private String name;
    /**
     * 0：男 1：女
     */
    private String sex;
    /**
     * 学院
     */
    @Column(name = "college_id")
    private Integer collegeId;
    /**
     * 专业号
     */
    @Column(name = "subject_id")
    private Integer subjectId;
    /**
     * 密码：默认为学号
     */
    @JsonIgnore
    private String password;

    private Integer age;

    private String telephone;
    /**
     * 入住时间
     */
    private Date time;


    public Student(String id, String name, String sex, Integer collegeId, Integer subjectId, String password, Integer age, String telephone, Date time) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.collegeId = collegeId;
        this.subjectId = subjectId;
        this.password = password;
        this.age = age;
        this.telephone = telephone;
        this.time = time;
    }

    public Student() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", collegeId=" + collegeId +
                ", subjectId=" + subjectId +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", time=" + time +
                '}';
    }
}
