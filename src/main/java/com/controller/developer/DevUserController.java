package com.controller.developer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pojo.DevUser;
import com.service.DevUserService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Autowired
    private DevUserService devUserService;

    /**
     * 登录页面
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "devlogin";
    }

    /**
     * 用户登录
     */
    @RequestMapping("/dologin")
    public String login(Model model, DevUser user, HttpSession session) {


        DevUser devUser = devUserService.findDevUserByUser(user);
        if (devUser == null) {
            model.addAttribute("error", "用户名或密码有错");
            return "devlogin";
        }
        System.out.println("查询成功" + " " + devUser.getDevCode() + " " + devUser.getDevPassword());
        session.setAttribute("devUserSession", devUser);
        model.addAttribute("devUserSession", devUser);
        return "developer/main";
    }


    /**
     * 用户注销
     */
    @RequestMapping("/logout")
    public String exit(HttpSession session) {
        session.removeAttribute("devUserSession");
        session.invalidate();
        return "devlogin";
    }


}
