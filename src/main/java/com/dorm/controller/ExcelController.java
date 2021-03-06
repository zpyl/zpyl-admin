package com.dorm.controller;

import com.dorm.service.ExcelService;
import com.dorm.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 导入excel文件进行数据库的导入
 * @author zp
 */
@Controller
@RequestMapping("excel/excel")
public class ExcelController {
    @Autowired
   private ExcelService excelService;
    @RequestMapping(value="/put",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestParam(value="file",required = false) MultipartFile file,
                         HttpServletRequest request, HttpServletResponse response) {
        return excelService.readExcelFile(file);
    }
}
