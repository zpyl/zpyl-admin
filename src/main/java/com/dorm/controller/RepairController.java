package com.dorm.controller;

import com.dorm.entity.Repair;
import com.dorm.entity.Staff;
import com.dorm.service.RepairService;
import com.dorm.service.StaffService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StaffVo;
import com.dorm.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("repair/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    /**
     * 保存记录
     */
    @RequestMapping("add")
    public Result add(String reason, HttpSession session){
        StudentVo admin = (StudentVo) session.getAttribute("admin");
        return repairService.add(new Repair(admin.getId(),admin.getBedroomId(),admin.getHostelId(),admin.getName(),admin.getTelephone(),reason,false,new Date()));
    }
    /**
     * 每个管理员查看的界面是不一样的，体现在宿舍报修上面
     */
    @RequestMapping("list")
    public TableUtil list(HttpSession session){
        return repairService.list(session);
    }
    /**
     * 删除数据
     */
    @RequestMapping("remove")
    public Result remove(String ids){
        return repairService.remove(ids.split(","));
    }
    /**
     * 根据报修编号修改信息
     */
    @RequestMapping("edit")
    public Result edit(String ids){
        return repairService.edit(ids.split(","));
    }
}
