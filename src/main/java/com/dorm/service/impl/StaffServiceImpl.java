package com.dorm.service.impl;

import com.dorm.entity.Staff;
import com.dorm.mapper.StaffHostelMapper;
import com.dorm.mapper.StaffMapper;
import com.dorm.service.StaffService;
import com.dorm.until.Result;
import com.dorm.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private StaffHostelMapper staffHostelMapper;
    /**
     * 查询所有的职工信息
     * @return 职工集合
     */
    @Override
    public List<Staff> list() {
        return staffMapper.selectAll();
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
    public Staff findByStaffId(int id) {
        return staffMapper.selectByPrimaryKey(id);
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

    /**
     * 添加职工信息
     *
     * @param staff 职工信息
     * @return
     */
    @Override
    public Boolean addStaff(Staff staff) {
        staff.setIsSuper(false);
        staff.setPassword(staff.getTelephone());
        return this.staffMapper.insertSelective(staff)>0;
    }

    /**
     * 修改职工信息
     *
     * @param staff 职工信息
     * @return
     */
    @Override
    public Boolean updateStaff(Staff staff) {
        return this.staffMapper.updateByPrimaryKeySelective(staff)>0;
    }

    /**
     * 根据职工号删除职工信息
     *
     * @param staffId 职工id
     * @return
     */
    @Override
    public Boolean removeByStaffId(Integer staffId) {
        return this.staffMapper.deleteByPrimaryKey(staffId)>0;
    }

}
