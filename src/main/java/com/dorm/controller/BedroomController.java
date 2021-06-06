package com.dorm.controller;


import com.dorm.entity.Bedroom;
import com.dorm.entity.Hostel;
import com.dorm.entity.Student;
import com.dorm.service.BedroomService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zp
 */
@Controller
@RequestMapping("bedroom/bedroom")
public class BedroomController {
    @Autowired
    private BedroomService bedroomService;

    /**
     *用于管理员登录时查看当前宿舍的信息
     * @param session 当前登录的账号
     * @param model
     * @return
     */
    @RequestMapping("/bedroomStaff")
    public String bedroom_staff(HttpSession session,Model model){
        //查看当前是哪个管理员登录
        StaffVo admin = (StaffVo)session.getAttribute("admin");
        System.out.println(admin.getId());
        //查询管理的楼层
        Hostel hostel=bedroomService.findHostelByStaffId(admin.getId());
        model.addAttribute("hostel",hostel);
        return "bedroom/bedroom_staff";
    }

    /**
     * 查看当前寝室学生情况
     * @param bedroomId 寝室号
     * @param hostelId 楼
     * @return
     */
    @RequestMapping("/studentInfo")
    public String studentInfo(Integer bedroomId ,Integer hostelId,Model model){
        List<Student> students=bedroomService.findBedroomStudent(hostelId,bedroomId);
        model.addAttribute("list",students);
        return "bedroom/bedroom_info";
    }


    /**
     * 加载数据
     */
    @RequestMapping("list")
    @ResponseBody
    public TableUtil list(Integer offset,Integer pageNumber,
                          String hostelId,
                          String collegeId,
                          String subjectId){
        return bedroomService.list(offset,pageNumber,hostelId,collegeId,subjectId);
    }

    /**
     * 设置宿舍信息
     * @param hostelId 楼层号
     * @param collegeId 学院号
     * @param subjectId 专业号
     * @param number1 寝室号开始位置
     * @param number2 寝室结束位置
     */
    @RequestMapping("set")
    @ResponseBody
    public Result set(Integer hostelId,Integer collegeId,Integer subjectId,Integer number1,Integer number2){
        return bedroomService.set(hostelId,collegeId,subjectId,number1,number2);
    }
    @RequestMapping("infoLook")
    @ResponseBody
    public List<Bedroom> infoLook(Integer hostelId, Integer collegeId, Integer subjectId){
        return bedroomService.infoLook(hostelId,collegeId,subjectId);
    }

//    /**
//     * 添加数据
//     */
//    @RequestMapping("add")
//    @ResponseBody
//    public Result add(Staff staff, Integer hostelId){
//        return staffService.add(staff,hostelId);
//    }
//    /**
//     * 删除数据
//     */
//    @RequestMapping("remove")
//    @ResponseBody
//    public Result remove(String ids){
//        return staffService.remove(ids.split(","));
//    }
//    /**
//     * 根据staffId查找职工信息
//     */
//    @RequestMapping("findByStaffId")
//    @ResponseBody
//    public StaffVo findByStaffId(int staffId){
//        return staffService.findByStaffId(staffId);
//    }
//    /**
//     * 根据staffId修改信息
//     */
//    @RequestMapping("edit")
//    @ResponseBody
//    public Result edit(Staff staff,Integer hostelId){
//        return staffService.edit(staff,hostelId);
//    }
}
