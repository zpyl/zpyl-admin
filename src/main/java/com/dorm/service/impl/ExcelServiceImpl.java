package com.dorm.service.impl;

import com.dorm.entity.Excel;
import com.dorm.entity.Student;
import com.dorm.mapper.CollegeMapper;
import com.dorm.mapper.StudentMapper;
import com.dorm.service.ExcelService;
import com.dorm.until.ReadExcel;
import com.dorm.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class ExcelServiceImpl implements ExcelService {

    //操作数据库
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;
    /**
     * 读取excel中的数据,生成list
     *
     * @param file
     * @return
     */
    @Override
    public Result readExcelFile(MultipartFile file) {
            //创建处理EXCEL的类
            ReadExcel readExcel = new ReadExcel();
            //解析excel，获取上传的事件单
            List<Excel> useList = readExcel.getExcelInfo(file);
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            //和你具体业务有关,这里不做具体的示范
            if (useList != null && !useList.isEmpty()) {
                //将数据添加到数据库
                for (Excel excel : useList) {
                    if(excel.getStuId()!=null) {
                        //根据学院查询学院id
                        int collegeId = collegeMapper.collegeFindName(excel.getCollegeName());
                        //根据学院和专业查询课程id
                        int subjectId = collegeMapper.subjectFindName(collegeId, excel.getSubjectName());
                        studentMapper.add(new Student(excel.getStuId(), excel.getStuName(), excel.getSex(), collegeId, subjectId, excel.getStuId(), excel.getAge(), excel.getTelephone(), null));
                    }
                }
                return Result.ok();
            } else {
                return Result.build(400,null,null);
            }
        }
}
