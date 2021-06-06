package com.dorm.service.impl;

import com.dorm.entity.College;
import com.dorm.mapper.CollegeMapper;
import com.dorm.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    /**
     * 查询学院信息
     */
    @Override
    public List<College> college() {
        List<College> college = collegeMapper.college();
        college.add(new College(0,"全部",0,true));
        return college;
    }

    /**
     * 查询学院下的专业信息
     *
     * @param collegeId
     */
    @Override
    public List<College> subject(Integer collegeId) {
        List<College> subject = collegeMapper.subject(collegeId);
        subject.add(new College(0,"全部",0,false));
        return subject;
    }
}
