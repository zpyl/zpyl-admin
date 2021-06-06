package com.dorm.service.impl;

import com.dorm.entity.Staff;
import com.dorm.mapper.StaffHostelMapper;
import com.dorm.mapper.StaffMapper;
import com.dorm.service.StaffService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private StaffHostelMapper staffHostelMapper;
    /**
     * 职工信息
     */
    @Override
    public TableUtil list() {
        return new TableUtil(staffMapper.count(),staffMapper.list());
    }

    /**
     * 增加员工信息
     */
    @Override
    public Result add(Staff staff, Integer hostelId) {

        //默认不是超级管理员
        staff.setIsSuper(false);
        //密码默认是123456
        staff.setPassword("123456");
        staffMapper.add(staff);
        if(hostelId!=null){
            staffHostelMapper.add(staffMapper.getKey(),hostelId);
        }
        return Result.ok();
    }

    /**
     * 删除数据
     */
    @Override
    public Result remove(String[] ids) {
        staffMapper.remove(ids);
        return Result.ok();
    }

    /**
     * 根据员编号查找指定的数据
     */
    @Override
    public StaffVo findByStaffId(int id) {
        return staffMapper.findByStaffId(id);
    }

    /**
     * 修改信息
     */
    @Override
    public Result edit(Staff staff, Integer hostelId) {
        staff.setPassword("123456");
        staff.setIsSuper(false);
        staffMapper.edit(staff);
        staffHostelMapper.removeByStaffId(staff.getId());
        staffHostelMapper.add(staff.getId(),hostelId);
        return Result.ok();
    }

    /**
     * 查询
     *
     * @param id
     * @param password
     * @return
     */
    @Override
    public Staff login(String id, String password) {
        return staffMapper.login(id,password);
    }

    /**
     * 修改密码
     *
     * @param staffId
     * @param pass
     */
    @Override
    public void infoModify(String staffId, String pass) {
        staffMapper.infoModify(staffId,pass);
    }
}
