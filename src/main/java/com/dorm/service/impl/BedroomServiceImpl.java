package com.dorm.service.impl;

import com.dorm.entity.Bedroom;
import com.dorm.entity.Hostel;
import com.dorm.entity.Student;
import com.dorm.mapper.BedroomMapper;
import com.dorm.mapper.HostelMapper;
import com.dorm.mapper.StaffHostelMapper;
import com.dorm.mapper.StudentMapper;
import com.dorm.service.BedroomService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedroomServiceImpl implements BedroomService {

    @Autowired
    private BedroomMapper bedroomMapper;
    @Autowired
    private HostelMapper hostelMapper;
    @Autowired
    private StaffHostelMapper staffHostelMapper;
    @Autowired
    private StudentMapper studentMapper;
    /**
     * 查找信息
     * @param offset
     * @param pageNumber
     */
    @Override
    public TableUtil list(Integer offset, Integer pageNumber) {
        return new TableUtil(bedroomMapper.count(null,null,null),bedroomMapper.list(offset,pageNumber, null, null, null));
    }

    /**
     * 条件查询
     */
    @Override
    public TableUtil list(Integer offset, Integer pageNumber, String hostelId, String collegeId, String subjectId) {
        return new TableUtil(bedroomMapper.count(hostelId,collegeId,subjectId),bedroomMapper.list(offset,pageNumber,hostelId,collegeId,subjectId));
    }

    /**
     * @param hostelId  楼层号
     * @param collegeId 学院号
     * @param subjectId 专业号
     * @param number1   寝室号开始位置
     * @param number2   寝室结束位置
     * @return
     */
    @Override
    public Result set(Integer hostelId, Integer collegeId, Integer subjectId, Integer number1, Integer number2) {
        Hostel byHostelId = hostelMapper.findByHostelId(hostelId);
        Integer number = byHostelId.getNumber();
        //当设置的宿舍不跨层时
        if ((number2 / 100) - (number1 / 100) == 0){
            for (int i = number1; i <= number2; i++) {
                bedroomMapper.set(hostelId, collegeId, subjectId, i);
            }
        }else{
            //宿舍跨层时
            //先将底层填满
            for (int i = number1; i <= (number1/100)*100+number; i++) {
                bedroomMapper.set(hostelId, collegeId, subjectId, i);
            }
            //将最高层填满
            for (int i = number2; i <= (number2/100)*100+number; i++) {
                bedroomMapper.set(hostelId, collegeId, subjectId, i);
            }
            //中间层填满
            for (int i = 1; i <= number2/100-number1/100; i++) {
                for (int j = 1; j <=number; j++) {
                    bedroomMapper.set(hostelId, collegeId, subjectId, (number1/100+i)*100+j);
                }
            }
        }
        return Result.ok();
    }

    /**
     * 查询学院、专业、楼号所对应的宿舍信息
     *
     * @param hostelId  楼层号
     * @param collegeId 学院号
     * @param subjectId 专业号
     * @return
     */
    @Override
    public List<Bedroom> infoLook(Integer hostelId, Integer collegeId, Integer subjectId) {
        return bedroomMapper.infoLook(hostelId,collegeId,subjectId);
    }

    /**
     * 根据管理员id查找所管理的宿舍
     *
     * @param staffId
     * @return
     */
    @Override
    public Hostel findHostelByStaffId(Integer staffId) {
        return staffHostelMapper.findHostelByStaffId(staffId);
    }

    /**
     * 根据楼和宿舍号查看宿舍住的情况
     *
     * @param hostelId  楼层
     * @param bedroomId 寝室号
     * @return
     */
    @Override
    public List<Student> findBedroomStudent(Integer hostelId, Integer bedroomId) {
        return studentMapper.findBedroomStudent(hostelId,bedroomId);
    }
}
