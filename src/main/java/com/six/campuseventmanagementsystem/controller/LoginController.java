package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.service.LoginService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录验证
    @PostMapping("/verify")
    public String verify(@RequestParam String Account, @RequestParam String Password){
        return loginService.verify(Account,Password);
    }

    //注册
    @PostMapping("/sign")
    public Boolean Sign(@RequestParam String Name,@RequestParam String Account,@RequestParam String Password){
        return loginService.sign(Name, Account, Password);
    }

    //生成token
    @PostMapping("/token")
    public String generateToken(@RequestParam String UserType){
        return loginService.generateToken(UserType);
    }
    @PostMapping("/parse")
    public Claims getClaimsByToken(String token){
        return loginService.getClaimsByToken(token);
    }
    @RequestMapping("/test")
    public String test(){
        return "成功运行";
    }
}
