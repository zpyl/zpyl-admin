package com.dorm.service.impl;

import com.dorm.entity.Repair;
import com.dorm.mapper.RepairMapper;
import com.dorm.service.RepairService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.until.UUIDUtils;
import com.dorm.vo.StaffVo;
import com.dorm.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;
    /**
     * 展示数据
     *
     * @return
     * @param session
     */
    @Override
    public TableUtil list(HttpSession session) {
        //判断当前是谁登录
        Integer user = (Integer) session.getAttribute("user");
        Object admin = session.getAttribute("admin");
        if(user==0){
           //超管登录
            return new TableUtil(repairMapper.count(null,null),repairMapper.list(null,null)) ;
        }else if(user==1){
            //宿管登录
            StaffVo staffVo = (StaffVo)admin;
            return new TableUtil(repairMapper.count(staffVo.getHostelId(),null),repairMapper.list(staffVo.getHostelId(),null)) ;
        }else if(user==2){
            //学生登录
            StudentVo studentVo = (StudentVo)admin;
            return new TableUtil(repairMapper.count(studentVo.getHostelId(),studentVo.getBedroomId()),repairMapper.list(studentVo.getHostelId(),studentVo.getBedroomId())) ;
        }
        return new TableUtil(repairMapper.count(null,null),repairMapper.list(null,null)) ;
    }

    /**
     * 根据学号进行删除
     *
     * @param split
     * @return
     */
    @Override
    public Result remove(String[] split) {
        repairMapper.remove(split);
        return Result.ok();
    }

    /**
     * 根据学号进行修改
     *
     * @param split
     * @return
     */
    @Override
    public Result edit(String[] split) {
        repairMapper.edit(split);
        return Result.ok();
    }

    /**
     * 添加报修信息
     *
     * @param repair
     */
    @Override
    public Result add(Repair repair) {
        repair.setId(UUIDUtils.getIds());
        repairMapper.add(repair);
        return Result.ok();
    }
}
