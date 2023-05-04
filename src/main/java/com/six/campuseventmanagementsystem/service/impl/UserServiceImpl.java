package com.six.campuseventmanagementsystem.service.impl;


import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.mapper.UserMapper;
import com.six.campuseventmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //更新类别
    @Override
    public Boolean UpdateUserType(Integer ID,String UserType) {
        User user = new User();
        user.setID(ID);
        user.setUserType(UserType);
        userMapper.updateById(user);
        return true;
    }
}
