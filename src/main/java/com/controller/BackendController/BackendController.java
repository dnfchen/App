package com.controller.BackendController;

import com.pojo.BackendUser;
import com.pojo.DevUser;
import com.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class BackendController {

    @Autowired
    private BackendUserService backendUserService;

    /**
     * 登录页面
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "backendlogin";
    }

    /**
     * 登录实现
     */
    @RequestMapping("/dologin")
    public String login(Model model, BackendUser user, HttpSession session) {

        BackendUser backendUser = backendUserService.findBackendUserByUser(user);
        if (backendUser == null) {
            model.addAttribute("error", "查询失败");
            return "backendlogin";
        }
        System.out.println("查询成功" + " " + backendUser.getUserCode() + " " + backendUser.getUserPassword());
        session.setAttribute("userSession", backendUser);
        model.addAttribute("userSession", backendUser);
        return "backend/main";
    }

    /**
     * 用户注销
     */
    @RequestMapping("/logout")
    public String exit(HttpSession session) {
        session.removeAttribute("userSession");
        session.invalidate();
        return "index";
    }
}
