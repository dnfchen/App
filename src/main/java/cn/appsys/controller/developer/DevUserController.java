package cn.appsys.controller.developer;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DevUserController {
    @Resource
    private DevUserService service;
    private Logger logger=Logger.getLogger(DevUserController.class);

    @RequestMapping(value = "/dev/login.html")
    public String login(){
        logger.debug("LoginController Welcome AppinfoSystem developer");
        return "developer/login";
    }
    @RequestMapping(value = "/dev/dologin.html")
    public String dologin(@RequestParam String devCode, @RequestParam String devPassword, HttpSession session, HttpServletRequest request){
        logger.debug("DoLogin!!!!");
        DevUser user=null;
        user=service.login(devCode,devPassword);
        if(null!=user){
            session.setAttribute(Constants.DEV_USER_SESSION,user);
            return "developer/main";
        }else{
            request.setAttribute("error","用户名或密码不正确！");
            return "developer/login";
        }
        //调用service方法进行用户登录
    }
    @RequestMapping("/flatfrom/main")
    public String main(HttpSession session){
        if(session.getAttribute(Constants.DEV_USER_SESSION)==null){
            return "developer/login";
        }
        return "redirect:developer/main";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "developer/login";
    }
    @RequestMapping("/dev/appinfolist.html")
    public String appList(){
        return "/dev/flatform/app/list";
    }
}
