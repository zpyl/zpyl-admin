package com.dorm.service;

import com.dorm.entity.Staff;
import com.dorm.until.Result;
import com.dorm.vo.StaffVo;

import java.util.List;

public interface StaffService {
    /**
     * 查询所有的职工
     * @return 职工集合
     */
    List<Staff> list();

    /**
     * 增加员工信息
     */
    Result add(Staff staff, Integer hostelId);

    /**
     * 删除数据
     */
    Result remove(String[] ids);

    /**
     * 根据staffId查找指定的数据
     */
    Staff findByStaffId(int staffId);

    /**
     * 修改信息
     */
    Result edit(Staff staff, Integer hostelId);

    /**
     * 查询
     * @param id
     * @param password
     * @return
     */
    Staff login(String id, String password);

    /**
     * 修改密码
     * @param staffId
     * @param pass
     */
    void infoModify(String staffId, String pass);

    /**
     * 添加职工信息
     * @param staff 职工信息
     * @return
     */
    Boolean addStaff(Staff staff);

    /**
     * 修改职工信息
     * @param staff 职工信息
     * @return
     */
    Boolean updateStaff(Staff staff);

    /**
     * 根据职工号删除职工信息
     * @param staffId 职工id
     * @return
     */
    Boolean removeByStaffId(Integer staffId);
}
