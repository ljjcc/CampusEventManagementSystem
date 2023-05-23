package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.Admin;

import java.util.List;

public interface SPAdminService {
    //添加管理员
    Boolean InsertAdmin(String AdminName,String Account,String Password,String OldType,String NewType);
    //修改管理员
    Boolean UpdateAdmin(Integer ID,String AdminName,String Account,String Password,String OldType,String NewType);
    //删除管理员
    Boolean DeleteAdmin(Integer ID);
    //注销管理员
    Boolean LogoutAdmin(Integer ID);
    //注销普通用户
    Boolean LogoutUser(Integer ID);
    //启用管理员
    public Boolean EnableAdmin(Integer ID);
    //启用普通用户
    public Boolean EnableUser(Integer ID);
    //注销
    Boolean Logout(Integer ID, String UserType);
    //启用
    Boolean Enable(Integer ID, String UserType);
    //查询管理员
    IPage SelectAdmin(Integer page, Integer size, String token);
    //查询普通用户
    IPage SelectUser(Integer page, Integer size, String token);
    //查询赛事选手
    public IPage SelectPlayer(Integer page, Integer size, String token);
    //修改超级管理员
    Boolean UpdateSPAdmin(Integer ID,String SPAdminName,String Account,String Password,String OldType,String NewType);
}
