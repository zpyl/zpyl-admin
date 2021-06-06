package com.dorm.service;

import com.dorm.entity.Staff;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StaffVo;

public interface StaffService {
    /**
     * 职工信息
     */
    TableUtil list();

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
    StaffVo findByStaffId(int staffId);

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
}
