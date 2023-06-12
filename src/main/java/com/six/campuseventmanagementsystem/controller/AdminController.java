package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.service.AdminService;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "普通管理员接口",tags = "普通管理员基本功能")
@RequestMapping("/CEMS/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private SPAdminService spAdminService;

    //查询管理员个人信息
    @PostMapping("/SeleteByAccount")
    public IPage SeleteByAccount(String Account, String token){
        return adminService.SelectByAccount(Account, token);
    }

    //注销普通用户
    @PutMapping("/LogoutUser")
    Boolean LogoutUser(Integer ID, String UserType){
        return spAdminService.LogoutUser(ID, UserType);
    }

    //启用普通用户
    @PutMapping("/EnableUser")
    Boolean EnableUser(Integer ID, String UserType){
        return spAdminService.EnableUser(ID, UserType);
    }




}
