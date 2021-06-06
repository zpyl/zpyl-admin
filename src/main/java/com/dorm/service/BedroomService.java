package com.dorm.service;

import com.dorm.entity.Bedroom;
import com.dorm.entity.Hostel;
import com.dorm.entity.Student;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;

import java.util.List;

public interface BedroomService {
    /**
     * 查找信息
     * @param offset
     * @param pageNumber
     */
    TableUtil list(Integer offset, Integer pageNumber);

    /**
     * 条件查询
     * @return
     */
    TableUtil list(Integer offset, Integer pageNumber, String hostelId, String collegeId, String subjectId);

    /**
     *
     * @param hostelId 楼层号
     * @param collegeId 学院号
     * @param subjectId 专业号
     * @param number1 寝室号开始位置
     * @param number2 寝室结束位置
     * @return
     */
    Result set(Integer hostelId, Integer collegeId, Integer subjectId, Integer number1, Integer number2);

    /**
     *查询学院、专业、楼号所对应的宿舍信息
     * @param hostelId 楼层号
     * @param collegeId 学院号
     * @param subjectId 专业号
     * @return
     */
    List<Bedroom> infoLook(Integer hostelId, Integer collegeId, Integer subjectId);

    /**
     * 根据管理员id查找所管理的宿舍
     * @param staffId
     * @return
     */
    Hostel findHostelByStaffId(Integer staffId);

    /**
     *根据楼和宿舍号查看宿舍住的情况
     * @param hostelId 楼层
     * @param bedroomId 寝室号
     * @return
     */
    List<Student> findBedroomStudent(Integer hostelId, Integer bedroomId);
}
