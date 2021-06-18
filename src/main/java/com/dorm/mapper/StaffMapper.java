package com.dorm.mapper;

import com.dorm.entity.Staff;
import com.dorm.vo.StaffVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StaffMapper extends Mapper<Staff> {
    /**
     * 查询总数
     */
    int count();

    /**
     * 表格
     */
    List<StaffVo> list();

    /**
     * 增加员工信息
     */
    void add(@Param("staff") Staff staff);

    /**
     * 删除数据
     */
    void remove(@Param("ids") String[] ids);

    /**
     * 根据指定的staffId查找职工
     */
    StaffVo findByStaffId(@Param("staffId") int staffId);

    /**
     * 根据staff修改数据
     */
    void edit(@Param("staff") Staff staff);
    /**
     * 获取自动增长的主键
     */
    int getKey();

    Staff login(@Param("id") String id, @Param("password") String password);

    /**
     * 根据staffId修改密码
     * @param id
     * @param pass
     */
    void infoModify(@Param("id") String id, @Param("pass") String pass);
}
