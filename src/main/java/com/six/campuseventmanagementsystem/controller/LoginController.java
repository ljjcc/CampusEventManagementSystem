package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.History;
import com.six.campuseventmanagementsystem.service.LoginService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@CrossOrigin
@RequestMapping("/CEMS/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录验证
    @PostMapping("/verify")
    public String verify(@RequestParam String Account, @RequestParam String Password, String how, String ip){
        return loginService.verify(Account, Password, how, ip);
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
    public String getClaimsByToken(String token){
        return loginService.getClaimsByToken(token);
    }

    /**
     * 根据 用户账号 查找登陆记录
     * @return 返回IPage类型消息记录
     */
    @PostMapping("/SeleteByAccount")

    public IPage<History> SeleteByAccount(String Account, Integer page, Integer size, String token){
        return loginService.SeleteByAccount(Account, page, size, token);
    }
    @RequestMapping("/test")
    public String test(){
        return "成功运行";
    }

}
