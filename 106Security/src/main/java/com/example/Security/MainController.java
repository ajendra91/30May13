package com.example.Security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @PreAuthorize("hasRole('ROLE_SUPER')")
    @RequestMapping("/super")
    public String hello(){
        return "this is super admin api...";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/admin")
    public String admin(){
        return "this is admin api...";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/user")
    public String user(){
        return "this is user api...";
    }
}
