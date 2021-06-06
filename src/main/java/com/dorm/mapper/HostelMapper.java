package com.dorm.mapper;

import com.dorm.entity.Hostel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HostelMapper {

    /**
     * 总数
     */
    int count();

    /**
     * 表格展示
     */
    List<Hostel> list();

    /**
     * 增加
     */
    void add(@Param("hostel") Hostel hostel);

    /**
     * 删除
     */
    void remove(@Param("ids") String[] ids);

    /**
     * 根据id进行查找
     */
    Hostel findByHostelId(@Param("hostelId") int hostelId);

    /**
     * 编辑
     */
    void edit(@Param("hostel") Hostel hostel);

    /**
     * 查询所含有的宿舍信息
     *
     */
    List<Hostel> info();

    /**
     * 获取自动增长的主键
     */
    int getKey();

    List<Hostel> infoHostel(@Param("collegeId") Integer collegeId, @Param("sex") Integer sex,
                            @Param("subjectId") Integer subjectId);
}
