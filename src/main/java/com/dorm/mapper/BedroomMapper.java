package com.dorm.mapper;

import com.dorm.entity.Bedroom;
import com.dorm.vo.BedroomVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BedroomMapper {

    /**
     * @param hostel 楼号
     * @param bedroom 寝室号
     * @param people 每间宿舍可住人数
     */
    void add(@Param("hostel") int hostel, @Param("bedroom") int bedroom, @Param("people") Integer people);

    /**
     * 根据楼号进行删除
     */
    void removeByhostelId(@Param("hostelId") Integer hostelId);

    void removeByhostelIds(@Param("ids") String[] ids);

    /**
     * 数据
     * @return
     * @param offset
     * @param pageNumber
     * @param hostelId
     * @param collegeId
     * @param subjectId
     */
    List<BedroomVo> list(@Param("offset") Integer offset, @Param("pageNumber") Integer pageNumber, @Param("hostelId") String hostelId, @Param("collegeId") String collegeId, @Param("subjectId") String subjectId);

    /**
     * 条件总数
     */
    int count(@Param("hostelId") String hostelId, @Param("collegeId") String collegeId, @Param("subjectId") String subjectId);

    /**
     * 更新宿舍
     * @param hostelId 楼号
     * @param collegeId 学院
     * @param subjectId 专业
     * @param bedroomId 寝室号
     */
    void set(@Param("hostelId") Integer hostelId, @Param("collegeId") Integer collegeId, @Param("subjectId") Integer subjectId, @Param("bedroomId") int bedroomId);

    /**
     *查询学院、专业、楼号所对应的宿舍信息
     * @param hostelId 楼层号
     * @param collegeId 学院号
     * @param subjectId 专业号
     * @return
     */
    List<Bedroom> infoLook(@Param("hostelId") Integer hostelId, @Param("collegeId") Integer collegeId, @Param("subjectId") Integer subjectId);

    /**
     * 根据楼号和宿舍号查找
     * @param hostelId
     * @param bedroomId
     * @return
     */
    Bedroom findByid(@Param("hostelId") Integer hostelId, @Param("bedroomId") Integer bedroomId);

    /**
     * 根据楼号和宿舍号信息进行修改
     * @param bedroom
     */
    void update(@Param("bedroom") Bedroom bedroom);

}
