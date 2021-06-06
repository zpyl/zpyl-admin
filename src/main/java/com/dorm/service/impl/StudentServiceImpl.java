package com.dorm.service.impl;

import com.dorm.entity.Bedroom;
import com.dorm.entity.StuBed;
import com.dorm.entity.Student;
import com.dorm.mapper.BedroomMapper;
import com.dorm.mapper.StuBedMapper;
import com.dorm.mapper.StudentMapper;
import com.dorm.service.StudentService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StuBedMapper stuBedMapper;
    @Autowired
    private BedroomMapper bedroomMapper;
    /**
     * 展示学生信息
     * @param offset
     * @param pageNumber
     * @param studentVo
     */
    @Override
    public TableUtil list(Integer offset, Integer pageNumber, StudentVo studentVo) {
        return new TableUtil(studentMapper.count(studentVo),studentMapper.list(offset,pageNumber,studentVo));
    }

    /**
     * 根据学号进行查找
     *
     * @param stuId
     * @return
     */
    @Override
    public StudentVo findByStuId(String stuId) {
        return studentMapper.findByStuId(stuId);
    }

    /**
     * 办理学生入住
     * @param studentVo
     * @return
     */
    @Override
    public Result addBed(StudentVo studentVo) {
       //办理入住时间
        studentMapper.setByStuId(studentVo.getId(),studentVo.getTelephone(),studentVo.getTime());
        //办理入住
        stuBedMapper.add(studentVo.getId(),studentVo.getHostelId(),studentVo.getBedroomId());
        //修改对应宿舍的已住人数
        Bedroom bedroom = bedroomMapper.findByid(studentVo.getHostelId(),studentVo.getBedroomId());
        bedroom.setNumber(bedroom.getNumber()+1);
        if(bedroom.getNumber()==bedroom.getMaxNumber()){
            bedroom.setIsFull(true);
        }
        //更新
        bedroomMapper.update(bedroom);
        return Result.ok();
    }

    /**
     * 学生退宿
     *
     * @param split
     * @return
     */
    @Override
    public Result stuBedRemove(String[] split) {
        for (String stuId : split) {
            //根据stuId查找学生所在楼层和宿舍
              StuBed stuBed=stuBedMapper.findByStuId(stuId);
              //如果没有该学生信息则不需要进行修改
              if(stuBed!=null) {
                  //根据宿舍楼、宿舍号和学号修改信息
                  //修改对应宿舍的已住人数
                  Bedroom bedroom = bedroomMapper.findByid(stuBed.getHostelId(), stuBed.getBedroomId());
                  bedroom.setNumber(bedroom.getNumber() - 1);
                  bedroom.setIsFull(false);
                  //更新
                  bedroomMapper.update(bedroom);
                  //删除学生与宿舍的关联表
                  stuBedMapper.deleteByStuId(stuId);
              }
        }

        return Result.ok();
    }

    @Override
    public Student login(String id, String password) {
        return studentMapper.login(id,password);
    }

    /**
     * 修改密码
     *
     * @param id
     * @param password
     */
    @Override
    public void infoModify(String id, String password) {
        studentMapper.infoModify(id,password);
    }

    /**
     * 增加学生信息
     *
     * @param student
     */
    @Override
    public void add(Student student) {
        student.setPassword(student.getId());
        student.setTime(new Date());
        studentMapper.add(student);
    }

    /**
     * 学生换专业
     *
     * @param student
     * @return
     */
    @Override
    public Result edit(Student student) {
        //先进行退宿操作
        stuBedRemove(student.getId().split(","));
        //修改学生信息
        studentMapper.edit(student);
        return Result.ok();
    }

    /**
     * 学生退学
     * @param split
     * @return
     */
    @Override
    public Result remove(String[] split) {
        //先退宿
        stuBedRemove(split);
        //退学
        studentMapper.remove(split);
        return Result.ok();
    }

}
