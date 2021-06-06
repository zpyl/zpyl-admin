package com.dorm.entity;

import java.io.Serializable;

/**
 * (College)实体类
 *
 * @author makejava
 * @since 2020-11-14 14:00:50
 */
public class College implements Serializable {
    private static final long serialVersionUID = -65255978094839811L;
    /**
     * 编号
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 学院id
     */
    private Integer collegeId;
    /**
     * 1：是学院 0不是学院
     */
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