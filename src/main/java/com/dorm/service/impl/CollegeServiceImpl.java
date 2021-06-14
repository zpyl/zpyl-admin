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
        return subject;
    }

    /**
     * 新增学院
     *
     * @param college 学院
     * @return 是否成功
     */
    @Override
    public boolean addCollege(College college) {
        college.setIsCollege(true);
        college.setCollegeId(0);
        return this.collegeMapper.insertSelective(college)>0;
    }
    /**
     * 新增专业
     *
     * @param college 学院
     * @return 是否成功
     */
    @Override
    public boolean addSubject(College college) {
        college.setIsCollege(false);
        return this.collegeMapper.insertSelective(college)>0;
    }
    /**
     * 修改学院
     *
     * @param college 学院
     * @return 是否成功
     */
    @Override
    public boolean updateCollege(College college) {
        return this.collegeMapper.updateByPrimaryKeySelective(college)>0;
    }
    /**
     * 删除学院或专业
     *
     * @param id 学院或专业id
     * @return 是否成功
     */
    @Override
    public boolean remove(Integer id) {
        //先查询所在的id是否是学院
        if (this.collegeMapper.selectByPrimaryKey(id).getIsCollege()) {
            //是学院
            //删除学院下所有的专业
            this.collegeMapper.deleteSubjuctByCollegeId(id);
        }
        //删除id
        return this.collegeMapper.deleteByPrimaryKey(id)>0;
    }
}
