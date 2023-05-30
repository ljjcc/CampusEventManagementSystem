package com.six.campuseventmanagementsystem.controller;


import com.six.campuseventmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    //修改用户权限
    @PutMapping("/UpUserType")
    public Boolean UpUserType(Integer ID,String UserType){
        return userService.UpdateUserType(ID,UserType);
    }
}
