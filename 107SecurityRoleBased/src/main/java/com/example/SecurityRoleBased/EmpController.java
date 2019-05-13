package com.example.SecurityRoleBased;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {


    public List<Emp> lst=new ArrayList<Emp>();

    @PostConstruct
    public void add(){
        Emp emp1=new Emp(1,"super","","super","SUPER");
        lst.add(emp1);
        Emp emp2=new Emp(2,"admin","","admin","ADMIN");
        lst.add(emp2);
        Emp emp3=new Emp(3,"user","","user","USER");
        lst.add(emp3);
    }

    //@Secured("ROLE_SUPER")
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

    public Emp findByName(String name){
        Emp newEmp=null;
        for (int i=0;i<lst.size();i++){
            Emp e=lst.get(i);
            if(e.name.equals(name)){
                newEmp=e;
            }
        }
        return newEmp;
    }

}
