package com.dorm.controller;

import com.dorm.entity.Hostel;
import com.dorm.service.HostelService;
import com.dorm.until.Result;
import com.dorm.until.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("hostel/hostel")
public class HostelController {
    @Autowired
    private HostelService hostelService;

    /**
     * 展示数据
     */
    @RequestMapping("list")
    @ResponseBody
    public TableUtil list(){
        return hostelService.list();
    }

    /**
     * 跳转到公寓楼管理修改
     * @param hostelId 公寓楼id
     * @param model 绑定的数据
     */
    @RequestMapping("/hostel_edit")
    public String staff_edit(Integer hostelId, Model model){
        //根据hostelId查找宿舍楼信息
        model.addAttribute("hostel",hostelService.findByHostelId(hostelId));
        return "hostel/hostel_edit";
    }

    /**
     * 添加数据
     */
    @RequestMapping("add")
    @ResponseBody
    public Result add(Hostel hostel){
        return hostelService.add(hostel);
    }
    /**
     * 删除数据
     */
    @RequestMapping("remove")
    @ResponseBody
    public Result remove(String ids){
        return hostelService.remove(ids.split(","));
    }

    /**
     * 根据hostelId查找宿舍楼信息
     */
    @RequestMapping("findByHostelId")
    @ResponseBody
    public Hostel findByHostelId(int hostelId){
        return hostelService.findByHostelId(hostelId);
    }

    /**
     * 根据Hostel修改信息
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(Hostel hostel){
        return hostelService.edit(hostel);
    }
    /**
     * 查询所含有的宿舍信息
     */
    @RequestMapping("info")
    @ResponseBody
    public List<Hostel> info(){
        return hostelService.info();
    }
    /**
     * 根据性别和学院查询宿舍楼信息
     */
    @RequestMapping("infoHostel")
    @ResponseBody
    public List<Hostel>infoHostel(Integer collegeId,Integer sex,Integer subjectId){
        return hostelService.infoHostel(collegeId,sex,subjectId);
    }
}
