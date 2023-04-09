package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/verify")
    public Boolean verify(String Account, String Password){
        return loginService.verify(Account,Password);
    }

    @PostMapping("/sign")
    public Boolean Sign(String Name, String Account, String Password,String Number,String UserType){
        return loginService.sign(Name,Account,Password,Number,UserType);
    }
    
    @RequestMapping("/test")
    public String test(){
        return "成功运行";
    }
}
