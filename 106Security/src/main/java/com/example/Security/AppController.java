package com.example.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/mylogin")
    public String mylogin(){
        return "login.html";
    }


    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard.html";
    }

    @RequestMapping("/accesserror")
    public String accesserror(){
        return "accessDenied.html";
    }




}
