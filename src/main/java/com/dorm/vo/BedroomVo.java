package com.dorm.vo;

/**
 * 宿舍管理的前端展示
 */
public class BedroomVo {
    //楼号
    private Integer hostelId;
    //楼名称
    private String hostelName;
    //寝室号
    private Integer bedroomId;
    //学院
    private String collegeName;
    //专业
    private String subjectName;
    //当前宿舍可住人数
    private Integer maxNumber;
    //当前宿舍已住人数
    private Integer number;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    //是否住满
    private boolean full;

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

}
