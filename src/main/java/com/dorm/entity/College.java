package com.dorm.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 学院/专业 实体类
 */
@Table(name = "college")
public class College implements Serializable {
    private static final long serialVersionUID = -65255978094839811L;
    /**
     * 编号
     */
    @Id
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 学院id
     */
    @Column(name = "college_id")
    private Integer collegeId;
    /**
     * 1：是学院 0不是学院
     */
    @Column(name = "is_college")
    private Boolean isCollege;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Boolean getIsCollege() {
        return isCollege;
    }

    public void setIsCollege(Boolean isCollege) {
        this.isCollege = isCollege;
    }

    public College(Integer id, String name, Integer collegeId, Boolean isCollege) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
        this.isCollege = isCollege;
    }

    public College() {
    }
}
