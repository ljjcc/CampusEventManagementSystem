package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.entity.Player;
import com.six.campuseventmanagementsystem.entity.SPAdmin;
import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.mapper.AdminMapper;
import com.six.campuseventmanagementsystem.mapper.PlayerMapper;
import com.six.campuseventmanagementsystem.mapper.SPAdminMapper;
import com.six.campuseventmanagementsystem.mapper.UserMapper;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPAdminServiceImpl implements SPAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private SPAdminMapper spAdminMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PlayerMapper playerMapper;

    //添加管理员
    @Override
    public Boolean InsertAdmin(String AdminName, String Account, String Password, String OldType, String NewType) {
        Admin admin = new Admin();
        admin.setAdminName(AdminName);
        admin.setAccount(Account);
        admin.setPassword(Password);
        admin.setOldType(OldType);
        admin.setUserType(NewType);
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
        admin.setUserType(NewType);
        adminMapper.updateById(admin);
        return true;
    }

    //删除管理员
    @Override
    public Boolean DeleteAdmin(Integer ID) {
        adminMapper.deleteById(ID);
        return true;
    }

    //注销管理员
    @Override
    public Boolean LogoutAdmin(Integer ID){
        Admin admin = new Admin();
        admin.setID(ID);
        admin.setState("未启用");
        adminMapper.updateById(admin);
        return true;
    }

    //注销普通用户
    @Override
    public Boolean LogoutUser(Integer ID){
        User user = new User();
        user.setID(ID);
        user.setState("未启用");
        userMapper.updateById(user);
        return true;
    }

    //启用管理员
    @Override
    public Boolean EnableAdmin(Integer ID){
        Admin admin = new Admin();
        admin.setID(ID);
        admin.setState("启用");
        adminMapper.updateById(admin);
        return true;
    }

    //启用普通用户
    @Override
    public Boolean EnableUser(Integer ID){
        User user = new User();
        user.setID(ID);
        user.setState("启用");
        userMapper.updateById(user);
        return true;
    }

    //注销
    @Override
    public Boolean Logout(Integer ID,String UserType){
        if(UserType.equals("管理员")){
            return LogoutAdmin(ID);
        }
        else if(UserType.equals("主办方")||UserType.equals("赞助商")){
            return LogoutUser(ID);
        }else
            return false;
    }

    //启用
    @Override
    public Boolean Enable(Integer ID, String UserType){
        if(UserType.equals("管理员")){
            return EnableAdmin(ID);
        }
        else if(UserType.equals("主办方")||UserType.equals("赞助商")){
            return EnableUser(ID);
        }else
            return false;
    }
    //查询管理员
    @Override
    public IPage SelectAdmin(Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<Admin> adminpage = new Page<>(page*size,size);
            IPage adminipage = adminMapper.selectPage(adminpage,null);
            return adminipage;
        }else
            return null;
    }

    //查询普通用户
    public IPage SelectUser(Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<User> userpage = new Page<>(page*size,size);
            IPage useripage = userMapper.selectPage(userpage,null);
            return useripage;
        }else
            return null;
    }

    //查询赛事选手
    public IPage SelectPlayer(Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<Player> playerpage = new Page<>(page*size,size);
            IPage playeripage = playerMapper.selectPage(playerpage,null);
            return playeripage;
        }else
            return null;
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
