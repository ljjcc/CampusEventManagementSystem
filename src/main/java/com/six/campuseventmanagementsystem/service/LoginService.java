package com.six.campuseventmanagementsystem.service;

import com.alibaba.druid.support.http.util.IPAddress;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.History;
import io.jsonwebtoken.Claims;

import java.io.File;

public interface LoginService {
    String verify(String Account, String Password, String how, String ip);
    boolean sign(String Name, String Account, String Password);
    String generateToken(String UserType);
    String getClaimsByToken(String token);

    /**
     * 根据 用户账号 查找登陆记录
     * @return 返回IPage类型消息记录
     */
    IPage<History> SeleteByAccount(String Account, Integer page, Integer size, String token);

}
