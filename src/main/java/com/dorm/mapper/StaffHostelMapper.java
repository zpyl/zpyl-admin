package com.dorm.mapper;

import com.dorm.entity.Hostel;
import org.apache.ibatis.annotations.Param;

public interface StaffHostelMapper {

    /**
     * 为公寓添加管理员
     */
    void add(@Param("staffId") Integer staffId, @Param("hostelId") Integer hostelId);

    /**
     * 根基staffId删除数据
     * @param staffId
     */
    void removeByStaffId(@Param("staffId") Integer staffId);

    void removeByHostel(@Param("ids") String[] ids);

    /**
     * 根据管理员id进行查询管理的楼层
     * @param staffId
     * @return
     */
    Hostel findHostelByStaffId(@Param("staffId") Integer staffId);
}
