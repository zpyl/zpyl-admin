package com.dorm.controller;


import com.dorm.entity.Staff;
import com.dorm.service.StaffService;
import com.dorm.service.StudentService;
import com.dorm.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("info/info")
public class InfoController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private StudentService studentService;
    /**
     * 修改密码时进行验证
     */
    @RequestMapping("modify")
    public boolean modify(@org.jetbrains.annotations.NotNull HttpSession session, String id, String pass){
      Integer user = (Integer)session.getAttribute("user");
      if(user==0){//超级管理员
          if(staffService.login(id,pass)!=null)
              return true;
      }else if(user==1){//宿舍管理员
          if(staffService.login(id,pass)!=null)
              return true;
      }else if(user==2){//学生登录
          if(studentService.login(id,pass)!=null)
          return true;
      }
      return false;
    }

    /**
     * 修改密码
     */
    @RequestMapping("infoModify")
    public Result infoModify(@org.jetbrains.annotations.NotNull HttpSession session, String id, String password) {
        Integer user = (Integer) session.getAttribute("user");
        if (user == 0) {//超级管理员
            staffService.infoModify(id,password);
        } else if (user == 1) {//宿舍管理员
            staffService.infoModify(id,password);
        } else if (user == 2) {//学生登录
            studentService.infoModify(id,password);
        }
        return Result.ok();
    }
}
