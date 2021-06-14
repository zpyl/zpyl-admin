package com.dorm.controller;

import com.dorm.entity.College;
import com.dorm.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zp
 */
@RestController
@RequestMapping("college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @PostMapping("college")
    public List<College> college(){
        return collegeService.college();
    }
    @GetMapping("subject")
    public List<College> subject(Integer collegeId){
        return collegeService.subject(collegeId);
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
     * 新增学院信息
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
     * 修改学院信息
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
     * 修改学院信息
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
