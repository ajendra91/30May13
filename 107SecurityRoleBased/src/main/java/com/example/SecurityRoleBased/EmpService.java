package com.example.SecurityRoleBased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmpService implements UserDetailsService {

    @Autowired
    public EmpController empController;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Emp emp =empController.findByName(username);
        EmpCustom empCustom=null;
        if(emp!=null){
            empCustom=new EmpCustom();
            empCustom.emp=emp;
        }else{
            throw new UsernameNotFoundException("emp not found");
        }
        return empCustom;

    }
}
