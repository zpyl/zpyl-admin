package com.dorm.mapper;

import com.dorm.entity.StuBed;
import org.apache.ibatis.annotations.Param;

public interface StuBedMapper {

    /**
     * 增加入职信息
     * @param stuId
     * @param hostelId
     * @param bedroomId
     */
    void add(@Param("stuId") String stuId, @Param("hostelId") Integer hostelId, @Param("bedroomId") Integer bedroomId);

    /**
     * 根据学号查找学生所在的学生楼层和宿舍
     * @return
     * @param stuId
     */
    StuBed findByStuId(@Param("stuId") String stuId);

    /**
     * 根据学号进行删除
     * @param stuId
     */
    void deleteByStuId(@Param("stuId") String stuId);
}
