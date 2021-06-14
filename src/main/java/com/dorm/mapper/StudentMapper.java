package com.dorm.mapper;

import com.dorm.entity.Student;
import com.dorm.vo.StudentVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface StudentMapper extends Mapper<Student> {


    /**
     * 添加学生信息
     * @param student
     */
    void add(@Param("student") Student student);

    /**
     * 查询学生总数
     * @return
     */
    int countStudent(@Param("student") Student student);

    List<StudentVo> list(@Param("offset") Integer offset, @Param("pageNumber") Integer pageNumber, @Param("studentVo") StudentVo studentVo);

    /**
     * 根据学号进行查找
     * @param id
     * @return
     */
    StudentVo findByStuId(@Param("id") String id);

    void setByStuId(@Param("id") String id, @Param("telephone") String telephone, @Param("time") Date time);

    List<Student> findBedroomStudent(@Param("hostelId") Integer hostelId, @Param("bedroomId") Integer bedroomId);

    /**
     * 登录
     * @param id 学号
     * @param password 密码
     * @return
     */
    Student login(@Param("id") String id, @Param("password") String password);

    void infoModify(@Param("id") String id, @Param("password") String password);

    /**
     * 修改学生信息
     * @param student
     */
    void edit(@Param("student") Student student);

    /**
     * 退学
     * @param split
     */
    void remove(@Param("split") String[] split);


    List<StudentVo> listStudent(@Param("student") Student student);
}
