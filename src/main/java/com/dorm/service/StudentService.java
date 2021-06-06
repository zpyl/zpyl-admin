package com.dorm.service;

import com.dorm.entity.Student;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import com.dorm.vo.StudentVo;

public interface StudentService {
    /**
     * 展示学生信息
     * @param offset
     * @param pageNumber
     * @param studentVo
     */
    TableUtil list(Integer offset, Integer pageNumber, StudentVo studentVo);

    /**
     * 根据学号进行查找
     * @param stuId
     * @return
     */
    StudentVo findByStuId(String stuId);

    /**
     * 办理学生入住
     * @param studentVo
     * @return
     */
    Result addBed(StudentVo studentVo);

    /**
     * 学生退宿
     * @param split
     * @return
     */
    Result stuBedRemove(String[] split);

    Student login(String id, String password);

    /**
     * 修改密码
     * @param id
     * @param password
     */
    void infoModify(String id, String password);

    /**
     * 增加学生信息
     * @param student
     */
    void add(Student student);

    /**
     * 学生换专业
     * @param student
     * @return
     */
    Result edit(Student student);

    /**
     * 学生退学
     * @param split
     * @return
     */
    Result remove(String[] split);
}
