package com.dorm.controller;

import com.dorm.entity.College;
import com.dorm.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author zp
 */
@RestController
@RequestMapping("college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    /**
     * 查询所有的学院信息
     * @return 状态码 200 学院集合
     *                 204 没有查询到
     */
    @GetMapping("college")
    public ResponseEntity<List<College>> college(){
        List<College> college = collegeService.college();
        if (college==null||college.size()==0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(college);
    }

    /**
     * 查询学院下的专业信息
     * @param collegeId 学院编号
     * @return 状态码 200 专业集合
     *                 204 没有查询到
     */
    @GetMapping("subject")
    public ResponseEntity<List<College>> subject(Integer collegeId){
        List<College> subject = collegeService.subject(collegeId);
        if (subject==null||subject.size()==0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subject);
    }

    /**
     * 新增学院信息
     * @param college 学院
     * @return 状态码 200 成功
     *                 202 失败
     */
    @PostMapping("addCollege")
    public ResponseEntity<Void> addCollege(@RequestBody College college){
        boolean bool=collegeService.addCollege(college);
        if (bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    /**
     * 新增专业信息
     * @param college 专业
     * @return 状态码 200 成功
     *                 202 失败
     */
    @PostMapping("addSubject")
    public ResponseEntity<Void> addSubject(@RequestBody College college){
        boolean bool=collegeService.addSubject(college);
        if (bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * 修改学院或专业信息
     * @param college 学院
     * @return 状态码 200 成功
     *                 202 失败
     */
    @PostMapping("updateCollege")
    public ResponseEntity<Void> updateCollege(@RequestBody College college){
        boolean bool=collegeService.updateCollege(college);
        if (bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    /**
     * 删除学院信息
     * @param id 学院/专业 id
     * @return 状态码 200 成功
     *                 202 失败
     */
    @GetMapping("remove")
    public ResponseEntity<Void> remove(Integer id){
        boolean bool=collegeService.remove(id);
        if (bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
