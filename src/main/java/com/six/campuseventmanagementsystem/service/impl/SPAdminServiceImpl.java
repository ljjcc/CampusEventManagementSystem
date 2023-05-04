package com.six.campuseventmanagementsystem.service.impl;

import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.entity.SPAdmin;
import com.six.campuseventmanagementsystem.mapper.AdminMapper;
import com.six.campuseventmanagementsystem.mapper.SPAdminMapper;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SPAdminServiceImpl implements SPAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private SPAdminMapper spAdminMapper;

    //添加管理员
    @Override
    public Boolean InsertAdmin(String AdminName, String Account, String Password, String OldType, String NewType) {
        Admin admin = new Admin();
        admin.setAdminName(AdminName);
        admin.setAccount(Account);
        admin.setPassword(Password);
        admin.setOldType(OldType);
        admin.setNewType(NewType);
        adminMapper.insert(admin);
        return true;
    }

    //更新管理员、更改用户权限
    @Override
    public Boolean UpdateAdmin(Integer ID,String AdminName, String Account, String Password, String OldType, String NewType) {
        Admin admin = new Admin();
        admin.setID(ID);
        admin.setAdminName(AdminName);
        admin.setAccount(Account);
        admin.setPassword(Password);
        admin.setOldType(OldType);
        admin.setNewType(NewType);
        adminMapper.updateById(admin);
        return true;
    }

    //删除管理员
    @Override
    public Boolean DeleteAdmin(String ID) {
        adminMapper.deleteById(ID);
        return true;
    }

    //查询管理员
    @Override
    public List<Admin> SelectAllAdmin(){
        List<Admin> adminList = adminMapper.selectList(null);
        return adminList;
    }

    //更新超级管理员信息
    @Override
    public Boolean UpdateSPAdmin(Integer ID,String SPAdminName, String Account, String Password, String OldType, String NewType) {
        SPAdmin spadmin = new SPAdmin();
        spadmin.setID(ID);
        spadmin.setSPAdminName(SPAdminName);
        spadmin.setAccount(Account);
        spadmin.setPassword(Password);
        spadmin.setOldType(OldType);
        spadmin.setNewType(NewType);
        spAdminMapper.updateById(spadmin);
        return true;
    }

}
