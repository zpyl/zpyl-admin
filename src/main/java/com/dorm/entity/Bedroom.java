package com.dorm.entity;

import java.io.Serializable;

/**
 * (Bedroom)实体类
 *
 * @author makejava
 * @since 2020-11-14 14:00:45
 */
public class Bedroom implements Serializable {
    private static final long serialVersionUID = -57223118837781388L;
    /**
     * 楼号
     */
    private Integer hostelId;
    /**
     * 寝室号
     */
    private Integer bedroomId;
    /**
     * 学院
     */
    private Integer collegeId;
    /**
     * 专业
     */
    private Integer subjectId;
    /**
     * 最大可住人数
     */
    private Integer maxNumber;
    /**
     * 已住人数
     */
    private Integer number;
    /**
     * 0：没满 1：满了
     */
    private Boolean isFull;


    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

    public Integer getBedroomId() {
        return bedroomId;
    }

    public void setBedroomId(Integer bedroomId) {
        this.bedroomId = bedroomId;
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

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(Boolean isFull) {
        this.isFull = isFull;
    }

}