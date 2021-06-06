package com.dorm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Repair)实体类
 *
 * @author makejava
 * @since 2020-11-14 14:00:52
 */
public class Repair implements Serializable {
    private static final long serialVersionUID = -14223100635485910L;

    private String id;

    private String stuId;

    private Integer bedroomId;

    private Integer hostelId;

    private String name;

    private String telephone;

    private String reason;
    /**
     * 0：没有完结，1：完结
     */
    private Boolean status;
    /**
     * 申请时间
     */
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Repair() {
    }

    public Repair(String stuId, Integer bedroomId, Integer hostelId, String name, String telephone, String reason, Boolean status, Date time) {
        this.stuId = stuId;
        this.bedroomId = bedroomId;
        this.hostelId = hostelId;
        this.name = name;
        this.telephone = telephone;
        this.reason = reason;
        this.status = status;
        this.time = time;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getBedroomId() {
        return bedroomId;
    }

    public void setBedroomId(Integer bedroomId) {
        this.bedroomId = bedroomId;
    }

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}