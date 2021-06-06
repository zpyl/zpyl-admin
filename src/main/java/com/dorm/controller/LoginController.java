package com.dorm.controller;

import com.dorm.entity.Staff;
import com.dorm.entity.Student;
import com.dorm.service.StaffService;
import com.dorm.service.StudentService;
import com.dorm.until.Result;
import com.dorm.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录
@Controller
@RequestMapping("login")
public class LoginController implements HandlerInterceptor {
    @Autowired
    private StaffService staffService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("login")
    public String login(String id, String password, HttpSession session,Model model){
        Staff staff= staffService.login(id,password);
        if(staff!=null){
            //判断是不是超管
            if(staff.getIsSuper()) {
                session.setAttribute("user",0);
            } else {
                session.setAttribute("user",1);
            }
             //网页显示姓名
             model.addAttribute("name",staff.getName());
            session.setAttribute("admin",staffService.findByStaffId(staff.getId()));
            return "index";
        }else{
            Student student=studentService.login(id,password);
            if(student!=null){//学生登录
                session.setAttribute("user",2);
                StudentVo studentVo = studentService.findByStuId(student.getId());
                session.setAttribute("admin",studentVo);
                //网页显示姓名
                model.addAttribute("name",student.getName());

                //绑定学生的住宿信息
                StudentVo byStuId = studentService.findByStuId(id);
                model.addAttribute("student",byStuId);
                return "index";
            }
        }
        model.addAttribute("msg","账号或密码错误");
        return "login";
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    /**    
     * 预处理    
     * preHandler是在Handler(Controller)中的方法执行之前执行  
     * 常用来身份认证，授权等...    
     * 假设配置当前拦截器的路径为
     * 所有路径都会经过拦截器  
     * 在执行所有controller之前，都会先执行此拦截器的preHandler方法  
     * 返回值    
     * true：放行请求，交个下一个组件处理  
     * false：不放行，进行拦截     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
//        //获取请求路径
//        String uri = httpServletRequest.getRequestURI();
//        HttpSession session = httpServletRequest.getSession();
//        //要么已经登录，要么正则执行登录--则放行  
//        if(session.getAttribute("admin")!=null||uri.indexOf("/login")!=-1)
//        { //已经登录获取正在执行登录退出--放行            
//            return true;
//        }
//        //如果没登录--跳转到登录界面
//        //重定向到jsp的话是有问题的，重定向实际上是浏览器发送的第二次请求        
//        // 是不能访问WBE-INF下的文件的，现在login.jsp在 /WEB-INF下        
//        // 在LoginController中处理一下 写一个处理转发到login.jsp
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
//        return false;
    }
    /**    
     * 执行完Controller方法之后，但是返回ModelAndView之前，对ModelAndView做些 处理  
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    /**    
     * 返回ModelAndView之后  
     * 如果说返回Handler执行过程中产生异常，可以在这处理  
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
