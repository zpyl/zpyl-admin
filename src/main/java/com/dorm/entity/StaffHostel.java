package com.dorm.entity;

import java.io.Serializable;

/**
 * (StaffHostel)实体类
 *
 * @author makejava
 * @since 2020-11-14 14:00:53
 */
public class StaffHostel implements Serializable {
    private static final long serialVersionUID = -21800972300383748L;

    private Integer staffId;

    private Integer hostelId;


    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

}