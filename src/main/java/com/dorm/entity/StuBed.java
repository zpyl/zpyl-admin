package com.dorm.entity;

import java.io.Serializable;

/**
 * (StuBed)实体类
 *
 * @author makejava
 * @since 2020-11-14 14:00:53
 */
public class StuBed implements Serializable {
    private static final long serialVersionUID = -23042071993635298L;

    private String stuId;
    /**
     * 公寓id
     */
    private Integer hostelId;
    /**
     * 寝室id
     */
    private Integer bedroomId;


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

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

}