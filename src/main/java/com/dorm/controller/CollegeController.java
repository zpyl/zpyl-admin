package com.dorm.controller;

import com.dorm.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zp
 */
@RestController
@RequestMapping("college/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @RequestMapping("college")
    public List college(){
        return collegeService.college();
    }
    @RequestMapping("subject")
    public List subject(Integer collegeId){
        return collegeService.subject(collegeId);
    }

}
