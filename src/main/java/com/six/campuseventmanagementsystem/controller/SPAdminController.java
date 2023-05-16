package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SPAdmin")
public class SPAdminController {
    @Autowired
    private SPAdminService spAdminService;

    //新建普通管理员
    @PostMapping("/add")
    public Boolean InsertAdmin(String AdminName,String Account,String Password,String OldType,String NewType){
        return spAdminService.InsertAdmin(AdminName, Account, Password, OldType, NewType);
    }

    //修改普通管理员
    @PutMapping("/UpdateAdmin")
    public Boolean UpdateAdmin(Integer ID,String AdminName,String Account,String Password,String OldType,String NewType){
        return spAdminService.UpdateAdmin(ID, AdminName, Account, Password, OldType, NewType);
    }

    //删除普通管理员
    @DeleteMapping("/DeleteAdmin")
    public Boolean DeleteAdmin(String ID){
        return spAdminService.DeleteAdmin(ID);
    }

    //查询普通管理员
    @GetMapping("/SelectAll")
    public IPage SelectAll(Integer size){
        return spAdminService.SelectAll(size);
    }

    //修改超级管理员
    @PutMapping("UpdateSPAdmin")
    public Boolean UpdateSPAdmin(Integer ID,String SPAdminName,String Account,String Password,String OldType,String NewType){
        return spAdminService.UpdateSPAdmin(ID, SPAdminName, Account, Password, OldType, NewType);
    }

}
