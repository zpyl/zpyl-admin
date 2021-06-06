package com.dorm.entity;

import java.io.Serializable;

/**
 * (Hostel)实体类
 *
 * @author makejava
 * @since 2020-11-14 14:18:39
 */
public class Hostel implements Serializable {
    private static final long serialVersionUID = 521507679525630991L;
    /**
     * 公寓号
     */
    private Integer hostelId;
    /**
     * 公寓名称
     */
    private String name;
    /**
     * 公寓性别
     */
    private String sex;
    /**
     * 楼层
     */
    private Integer floor;
    /**
     * 每层宿舍数量
     */
    private Integer number;
    /**
     * 每间宿舍可住人数
     */
    private Integer people;
    /**
     * 地址
     */
    private String address;
    /**
     * 座机
     */
    private String telephone;

    public Hostel() {
    }

    public Hostel(Integer hostelId, String name, String sex, Integer floor, Integer number, Integer people, String address, String telephone) {
        this.hostelId = hostelId;
        this.name = name;
        this.sex = sex;
        this.floor = floor;
        this.number = number;
        this.people = people;
        this.address = address;
        this.telephone = telephone;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}