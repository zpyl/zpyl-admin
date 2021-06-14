package com.dorm.service;

import com.dorm.entity.College;

import java.util.List;

public interface CollegeService {
    /**
     * 查询学院信息
     * @return
     */
    List<College> college();

    /**
     * 查询学院下的专业信息
     * @param collegeId
     */
    List<College> subject(Integer collegeId);

    /**
     * 新增学院
     * @param college 学院
     * @return 是否成功
     */
    boolean addCollege(College college);
    /**
     * 修改学院
     * @param college 学院
     * @return 是否成功
     */
    boolean updateCollege(College college);
    /**
     * 新增专业
     * @param college 学院
     * @return 是否成功
     */
    boolean addSubject(College college);

    /**
     * 删除学院或专业
     * @param id 学院或专业 id
     * @return 是否成功
     */
    boolean remove(Integer id);
}
