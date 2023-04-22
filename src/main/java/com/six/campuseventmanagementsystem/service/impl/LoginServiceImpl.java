package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.six.campuseventmanagementsystem.entity.*;
import com.six.campuseventmanagementsystem.mapper.AdminMapper;
import com.six.campuseventmanagementsystem.mapper.SPAdminMapper;
import com.six.campuseventmanagementsystem.mapper.UserMapper;
import com.six.campuseventmanagementsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SPAdminMapper spAdminMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean verify(String Account, String Password){
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        QueryWrapper<Admin> AqueryWrapper = new QueryWrapper<>();
        QueryWrapper<SPAdmin> SqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("Account",Account).eq("Password",Password);
        AqueryWrapper.eq("Account",Account).eq("Password",Password);
        SqueryWrapper.eq("Account",Account).eq("Password",Password);
        User user = userMapper.selectOne(UqueryWrapper);
        Admin admin = adminMapper.selectOne(AqueryWrapper);
        SPAdmin spAdmin = spAdminMapper.selectOne(SqueryWrapper);
        if(user != null)
            return true;
        else if(admin != null)
            return true;
        else if(spAdmin != null)
            return true;
        else
            return false;
    }

    @Override
    public boolean sign(String Name, String Account, String Password,String Number,String UserType) {
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("Account",Account).eq("Password",Password);
        User user = userMapper.selectOne(UqueryWrapper);
        if(user != null){
            return false;
        }
        else if(UserType.equals("参赛者")||UserType.equals("赞助商")){
            User user1 = new User();
            user1.setUserName(Name);
            user1.setAccount(Account);
            user1.setPassword(Password);
            user1.setNumber(Number);
            user1.setUserType(UserType);
            userMapper.insert(user1);
            return true;
        }
        return false;
    }

}
