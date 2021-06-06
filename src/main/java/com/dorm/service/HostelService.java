package com.dorm.service;

import com.dorm.entity.Hostel;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;

import java.util.List;

public interface HostelService {
    /**
     * 展示数据
     */
    TableUtil list();

    /**
     * 增加
     */
    Result add(Hostel hostel);
    /**
     * 删除数据
     */
    Result remove(String[] ids);

    /**
     * 根据hostelId查找指定的数据
     */
    Hostel findByHostelId(int hostelId);

    /**
     * 修改信息
     */
    Result edit(Hostel hostel);

    /**
     * 查询所含有的宿舍信息
     *
     */
    List<Hostel> info();

    /**
     * 根据学院和性别查询宿舍信息
     * @param collegeId 学院id
     * @param sex 性别
     * @param subjectId
     * @return
     */
    List<Hostel> infoHostel(Integer collegeId, Integer sex, Integer subjectId);
}
