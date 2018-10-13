package cn.appsys.controller.backend;

import cn.appsys.pojo.BackendUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BackendUserController {
    private static Logger logger=Logger.getLogger(BackendUserController.class);
    @RequestMapping(value = "/backend/login.html")
    public String login(){
        System.out.println("11111!!@@@@");
        return "backend/login";
    }

}
