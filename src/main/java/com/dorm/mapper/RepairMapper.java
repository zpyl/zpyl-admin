package com.dorm.mapper;

import com.dorm.entity.Repair;
import com.dorm.vo.RepairVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairMapper {
    /**
     * 计算总数
     * @return
     * @param hostelId
     * @param bedroomId
     */
    int count(@Param("hostelId") Integer hostelId, @Param("bedroomId") Integer bedroomId);

    /**
     * 查看
     * @return
     * @param hostelId
     * @param bedroomId
     */
    List<RepairVo> list(@Param("hostelId") Integer hostelId, @Param("bedroomId") Integer bedroomId);

    /**
     * 删除
     * @param split
     */
    void remove(@Param("split") String[] split);

    /**
     * 完结
     * @param split
     */
    void edit(@Param("split") String[] split);

    /**
     * 添加记录
     * @param repair
     */
    void add(@Param("repair") Repair repair);
}
