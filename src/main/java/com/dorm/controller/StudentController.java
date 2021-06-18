package com.dorm.controller;

import com.dorm.entity.Staff;
import com.dorm.entity.Student;
import com.dorm.service.StudentService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StaffVo;
import com.dorm.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 加载数据
     */
    @GetMapping("list")
    public TableUtil list(Integer offset,Integer pageNumber,Student student){
        return studentService.list(offset,pageNumber,student);
    }

    /**
     * 根据stuId查找学生信息
     * @param stuId 学号
     * @return 状态码 200 学生信息
     *         状态码 204 无数据
     */
    @GetMapping("findByStuId")
    public ResponseEntity<Student> findStudentById(String stuId){
        Student student = studentService.findStudentById(stuId);
        if(student==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(student);
    }

    /**
     * 新增学生信息
     * @param student 添加的学生信息
     * @return 状态码 200 成功
     *         状态码 202 失败
     */
    @PostMapping("addStudent")
    public ResponseEntity<Void> addStudent(@RequestBody  Student student){
        Boolean bool=studentService.add(student);
        if (!bool){
            //失败
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.ok().build();
    }

    /**
     * 修改学生信息
     * @param student 修改的学生信息
     * @return 状态码 200 成功
     *         状态码 202 失败
     */
    @PostMapping("updateStudent")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student){
        Boolean bool=studentService.updateStudent(student);
        if (!bool){
            //失败
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.ok().build();
    }

    /**
     * 删除学生
     *@return 状态码 200 成功
     *        状态码 202 失败
     */
    @GetMapping("remove")
    @ResponseBody
    public ResponseEntity<Void> remove(String stuId){
        Boolean bool = studentService.remove(stuId);
        if(bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
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



}
