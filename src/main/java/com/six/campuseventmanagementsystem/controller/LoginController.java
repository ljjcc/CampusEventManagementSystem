package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录验证
    @PostMapping("/verify")
    public Boolean verify(@RequestParam String Account, @RequestParam String Password){
        return loginService.verify(Account,Password);
    }

    //注册
    @PostMapping("/sign")
    public Boolean Sign(String Name, String Account, String Password,String Number,String UserType){
        return loginService.sign(Name,Account,Password,Number,UserType);
    }
    
    @RequestMapping("/test")
    public String test(){
        return "成功运行";
    }
}
