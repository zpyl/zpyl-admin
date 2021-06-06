package com.dorm.controller;


import com.dorm.entity.Staff;
import com.dorm.service.StaffService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("staff/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    /**
     * 跳转到修改界面
     * @param id 员工编号
     * @param model 绑定的数据
     * @return 界面的位置
     */
    @RequestMapping("/staff_edit")
    public String staff_edit(Integer id, Model model){
        model.addAttribute("staff", staffService.findByStaffId(id));
        return "staff/staff_edit";
    }


    /**
     * 加载数据
     */
    @RequestMapping("list")
    @ResponseBody
    public TableUtil list(){
        return staffService.list();
    }
    /**
     * 添加数据
     */
    @RequestMapping("add")
    @ResponseBody
    public Result add(Staff staff, Integer hostelId){
        return staffService.add(staff,hostelId);
    }
    /**
     * 删除数据
     */
    @RequestMapping("remove")
    @ResponseBody
    public Result remove(String ids){
        return staffService.remove(ids.split(","));
    }
    /**
     * 根据staffId修改信息
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(Staff staff,Integer hostelId){
        return staffService.edit(staff,hostelId);
    }
}
