package com.dorm.service;

import com.dorm.entity.Repair;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;

import javax.servlet.http.HttpSession;

public interface RepairService {
    /**
     * 展示数据
     * @return
     * @param session
     */
    TableUtil list(HttpSession session);

    /**
     * 根据编号进行删除
     * @param split
     * @return
     */
    Result remove(String[] split);

    /**
     * 根据学号进行修改
     * @param split
     * @return
     */
    Result edit(String[] split);

    /**
     * 添加报修信息
     * @param repair
     */
    Result add(Repair repair);
}
