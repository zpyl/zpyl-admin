package com.dorm.service;

import java.util.List;

public interface CollegeService {
    /**
     * 查询学院信息
     * @return
     */
    List college();

    /**
     * 查询学院下的专业信息
     * @param collegeId
     */
    List subject(Integer collegeId);
}
