package com.dorm.mapper;

import com.dorm.entity.College;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CollegeMapper extends Mapper<College> {

    @Select("select name where id=#{id}")
    String name(Integer id);
    /**
     * 查询学院信息
     */
    List<College> college();

    /**
     * 查询学院下专业的信息
     * @param collegeId
     */
    List<College> subject(@Param("collegeId") Integer collegeId);

    /**
     * 根据学院名称进行查询
     * @param collegeName 学院名称
     * @return
     */
    int collegeFindName(@Param("collegeName") String collegeName);

    /**
     * 根据学院id和专业名称进行查询
     * @param collegeId 学院id
     * @param subjectName 专业名称
     * @return
     */
    int subjectFindName(@Param("collegeId") int collegeId, @Param("subjectName") String subjectName);

    @Delete("delete from college where college_id=#{id}")
    void deleteSubjuctByCollegeId(Integer id);
}
