package com.dorm.service;

import com.dorm.until.Result;
import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {
    /**
     * 读取excel中的数据,生成list
     * @return
     */
    Result readExcelFile(MultipartFile file);
}
