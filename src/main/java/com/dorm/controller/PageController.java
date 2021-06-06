package com.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    @RequestMapping("{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @RequestMapping("staff/{staff}")
    public String staff(@PathVariable String staff) {
        return "staff/" + staff;
    }
    @RequestMapping("hostel/{hostel}")
    public String hostel(@PathVariable String hostel) {
        return "hostel/" + hostel;
    }
    @RequestMapping("bedroom/{bedroom}")
    public String bedroom(@PathVariable String bedroom) {
        return "bedroom/" + bedroom;
    }
    @RequestMapping("student/{student}")
    public String student(@PathVariable String student) {
        return "student/" + student;
    }
    @RequestMapping("repair/{repair}")
    public String repair(@PathVariable String repair) {
        return "repair/" + repair;
    }
    @RequestMapping("info/{info}")
    public String info(@PathVariable String info) {
        return "info/" + info;
    }
}
