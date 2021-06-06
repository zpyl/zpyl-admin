package com.dorm.controller;

import com.dorm.entity.Staff;
import com.dorm.entity.Student;
import com.dorm.service.StudentService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StaffVo;
import com.dorm.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("student/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/stuBed_add")
    public String stuBed_add(String id, Model model){
        model.addAttribute("student",studentService.findByStuId(id));
        return "student/stuBed_add";
    }

    /**
     * 加载数据
     */
    @RequestMapping("list")
    @ResponseBody
    public TableUtil list(Integer offset,Integer pageNumber,StudentVo studentVo){
        return studentService.list(offset,pageNumber,studentVo);
    }
    /**
     * 学生入住
     */
    @RequestMapping("addBed")
    @ResponseBody
    public Result addBed(StudentVo studentVo){
        return studentService.addBed(studentVo);
    }
    /**
     * 学生退宿
     */
    @RequestMapping("stuBedRemove")
    @ResponseBody
    public Result stuBedRemove(String stuIds){
        return studentService.stuBedRemove(stuIds.split(","));
    }
    /**
     * 根据stuId查找学生信息
     */
    @RequestMapping("findByStuId")
    @ResponseBody
    public StudentVo findByStuId(String stuId){
        return studentService.findByStuId(stuId);
    }

    /**
     * 增加学生时判断学号是否重复
     * @param id
     * @return
     */
    @RequestMapping("modify")
    @ResponseBody
    public boolean modify(String id){
        StudentVo byStuId = studentService.findByStuId(id);
        if(byStuId!=null){
            return false;
        }
        return true;
    }
    /**
     * 新增学生信息
     * @param student
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Result add(Student student){
        studentService.add(student);
        return Result.ok();
    }

    /**
     * 跳转到学生换专业界面
     */
    @RequestMapping("student_edit")
    public String student_edit(String id, Model model){
        model.addAttribute("student",studentService.findByStuId(id));
        return "student/student_edit";
    }
    /**
     * 学生换专业
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(Student student){
        return studentService.edit(student);
    }
    /**
     * 学生退学
     */
    @RequestMapping("remove")
    @ResponseBody
    public Result remove(String stuIds){
        return studentService.remove(stuIds.split(","));
    }


}
