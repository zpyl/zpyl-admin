package com.dorm.controller;


import com.dorm.entity.Staff;
import com.dorm.service.StaffService;
import com.dorm.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    /**
     * 查询所有的职工信息
     * @return 状态码 200 职工集合
     *                 204 没有查询到
     */
    @GetMapping("list")
    public ResponseEntity<List<Staff>> list(){
        List<Staff> list = staffService.list();
        if(list==null||list.size()==0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 新增职工信息
     * @param staff 职工信息
     * @return 状态码 200 成功
     *                 202 失败
     */
    @PostMapping("addStaff")
    public ResponseEntity<Void> addStaff(@RequestBody Staff staff){
        Boolean bool=this.staffService.addStaff(staff);
        if(bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    /**
     * 修改职工信息
     * @param staff 职工信息
     * @return 状态码 200 成功
     *                 202 失败
     */
    @PostMapping("updateStaff")
    public ResponseEntity<Void> updateStaff(@RequestBody Staff staff){
        Boolean bool=this.staffService.updateStaff(staff);
        if(bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * 根据职工号获取职工信息
     * @param staffId 职工号
     * @return 状态码 200 职工信息
     *                 204 没有数据
     */
    @GetMapping("findByStaffId")
    public ResponseEntity<Staff> findByStaffId(Integer staffId){
        Staff staff=this.staffService.findByStaffId(staffId);
        if(staff!=null){
            return ResponseEntity.ok(staff);
        }
        return ResponseEntity.noContent().build();
    }
//    @ResponseBody
//    public Result add(Staff staff, Integer hostelId){
//        return staffService.add(staff,hostelId);
//    }
    /**
     * 根据职工删除职工信息
     * @param staffId 职工号
     * @return 状态码 200 成功
     *                 202 没有找到
     */
    @GetMapping("removeByStaffId")
    public ResponseEntity<Void> removeByStaffId(Integer staffId){
        Boolean bool=this.staffService.removeByStaffId(staffId);
        if(bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
    /**
     * 删除数据
     */
    @RequestMapping("remove")
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
