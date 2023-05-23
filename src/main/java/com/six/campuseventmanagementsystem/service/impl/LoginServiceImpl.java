package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.six.campuseventmanagementsystem.entity.*;
import com.six.campuseventmanagementsystem.mapper.AdminMapper;
import com.six.campuseventmanagementsystem.mapper.SPAdminMapper;
import com.six.campuseventmanagementsystem.mapper.UserMapper;
import com.six.campuseventmanagementsystem.service.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SPAdminMapper spAdminMapper;
    @Autowired
    private AdminMapper adminMapper;
    //1天过期
    private static int expire = 86400;
    //32位密钥
    private static String secret = "abcdfghiabcdfghiabcdfghiabcdfghi";

    @Override
    public String verify(String Account, String Password){
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        QueryWrapper<Admin> AqueryWrapper = new QueryWrapper<>();
        QueryWrapper<SPAdmin> SqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("Account",Account).eq("Password",Password);
        AqueryWrapper.eq("Account",Account).eq("Password",Password);
        SqueryWrapper.eq("Account",Account).eq("Password",Password);
        User user = userMapper.selectOne(UqueryWrapper);
        Admin admin = adminMapper.selectOne(AqueryWrapper);
        SPAdmin spAdmin = spAdminMapper.selectOne(SqueryWrapper);
        if(user != null&&user.getUserType().equals("启用")){
            if(user.getUserType().equals("主办方")){
                generateToken("主办方");
                String organizer = "{\n" +
                        "  \"code\": 20000,\n" +
                        "  \"data\": {\n" +
                        "    \"menu\": [\n" +
                        "      {\n" +
                        "        \"path\": \"/\",\n" +
                        "        \"name\": \"home\",\n" +
                        "        \"label\": \"首页\",\n" +
                        "        \"icon\": \"s-home\",\n" +
                        "        \"url\": \"home/index\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"label\": \"赛事管理\",\n" +
                        "        \"icon\": \"video-play\",\n" +
                        "        \"path\": \"/match\",\n" +
                        "        \"children\": [\n" +
                        "          {\n" +
                        "            \"path\": \"/activity\",\n" +
                        "            \"name\": \"activity\",\n" +
                        "            \"label\": \"赛事活动管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"match/activity.vue\"\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"path\": \"/competitor\",\n" +
                        "            \"name\": \"competitor\",\n" +
                        "            \"label\": \"赛事选手管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"match/competitor.vue\"\n" +
                        "          }\n" +
                        "        ]\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"token\":" +"\""+generateToken("主办方")+"\""+","+
                        "    \"message\": \"获取成功\"\n" +
                        "  }\n" +
                        "}";
                return organizer;
            }
            else if(user.getUserType().equals("赞助商")){
                String sponsor = "{\n" +
                        "  \"code\": 20000,\n" +
                        "  \"data\": {\n" +
                        "    \"menu\": [\n" +
                        "      {\n" +
                        "        \"path\": \"/\",\n" +
                        "        \"name\": \"home\",\n" +
                        "        \"label\": \"首页\",\n" +
                        "        \"icon\": \"s-home\",\n" +
                        "        \"url\": \"home/index\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"label\": \"赞助管理\",\n" +
                        "        \"icon\": \"location\",\n" +
                        "        \"path\": \"/sponsor\",\n" +
                        "        \"children\": [\n" +
                        "          {\n" +
                        "            \"path\": \"/ad\",\n" +
                        "            \"name\": \"ad\",\n" +
                        "            \"label\": \"广告信息管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"sponsor/ad.vue\"\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"path\": \"/price\",\n" +
                        "            \"name\": \"price\",\n" +
                        "            \"label\": \"奖品信息管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"sponsor/price.vue\"\n" +
                        "          }\n" +
                        "        ]\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"token\":" +"\""+generateToken("赞助商")+"\""+","+
                        "    \"message\": \"获取成功\"\n" +
                        "  }\n" +
                        "}";
                return sponsor;
            }
            else
                return null;
        }
        else if(admin != null&&admin.getUserType().equals("启用")){
            String ad = "{\n" +
                    "  \"code\": 20000,\n" +
                    "  \"data\": {\n" +
                    "    \"menu\": [\n" +
                    "      {\n" +
                    "        \"path\": \"/home\",\n" +
                    "        \"name\": \"home\",\n" +
                    "        \"label\": \"首页\",\n" +
                    "        \"icon\": \"s-home\",\n" +
                    "        \"url\": \"home/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赛事管理\",\n" +
                    "        \"icon\": \"video-play\",\n" +
                    "        \"path\": \"/match\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/activity\",\n" +
                    "            \"name\": \"activity\",\n" +
                    "            \"label\": \"赛事活动管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/activity.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/competitor\",\n" +
                    "            \"name\": \"competitor\",\n" +
                    "            \"label\": \"赛事选手管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/competitor.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"用户管理\",\n" +
                    "        \"icon\": \"user\",\n" +
                    "        \"path\": \"/user\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/account\",\n" +
                    "            \"name\": \"account\",\n" +
                    "            \"label\": \"账号管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/account.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/user\",\n" +
                    "            \"name\": \"user\",\n" +
                    "            \"label\": \"用户信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/user.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赞助管理\",\n" +
                    "        \"icon\": \"location\",\n" +
                    "        \"path\": \"/sponsor\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/ad\",\n" +
                    "            \"name\": \"ad\",\n" +
                    "            \"label\": \"广告信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/ad.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/price\",\n" +
                    "            \"name\": \"price\",\n" +
                    "            \"label\": \"奖品信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/price.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"token\":" +"\""+generateToken("管理员")+"\""+","+
                    "    \"message\": \"获取成功\"\n" +
                    "  }\n" +
                    "}";
            return ad;
        }
        else if(spAdmin != null) {
            String spad = "{\n" +
                    "  \"code\": 20000,\n" +
                    "  \"data\": {\n" +
                    "    \"menu\": [\n" +
                    "      {\n" +
                    "        \"path\": \"/home\",\n" +
                    "        \"name\": \"home\",\n" +
                    "        \"label\": \"首页\",\n" +
                    "        \"icon\": \"s-home\",\n" +
                    "        \"url\": \"home/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赛事管理\",\n" +
                    "        \"icon\": \"video-play\",\n" +
                    "        \"path\": \"/match\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/activity\",\n" +
                    "            \"name\": \"activity\",\n" +
                    "            \"label\": \"赛事活动管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/activity.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/competitor\",\n" +
                    "            \"name\": \"competitor\",\n" +
                    "            \"label\": \"赛事选手管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/competitor.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"用户管理\",\n" +
                    "        \"icon\": \"user\",\n" +
                    "        \"path\": \"/user\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/account\",\n" +
                    "            \"name\": \"account\",\n" +
                    "            \"label\": \"账号管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/account.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/user\",\n" +
                    "            \"name\": \"user\",\n" +
                    "            \"label\": \"用户信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/user.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赞助管理\",\n" +
                    "        \"icon\": \"location\",\n" +
                    "        \"path\": \"/sponsor\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/ad\",\n" +
                    "            \"name\": \"ad\",\n" +
                    "            \"label\": \"广告信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/ad.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/price\",\n" +
                    "            \"name\": \"price\",\n" +
                    "            \"label\": \"奖品信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/price.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"token\":" +"\""+generateToken("超级管理员")+"\""+","+
                    "    \"message\": \"获取成功\"\n" +
                    "  }\n" +
                    "}";
            return spad;
        }
        else if(admin.getUserType().equals("未启用")){
            return null;
        }
        else if(user.getUserType().equals("未启用")){
            return null;
        }
        else
            return null;
    }

    @Override
    public boolean sign(String Name, String Account, String Password) {
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("Account",Account);
        User user = userMapper.selectOne(UqueryWrapper);
        if(user != null){
            return false;
        }
        else{
            User user1 = new User();
            user1.setUserName(Name);
            user1.setAccount(Account);
            user1.setPassword(Password);
            userMapper.insert(user1);
            return true;
        }
    }
    //生成token
    @Override
    public String generateToken(String UserType){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(UserType)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    //解析Token
    @Override
    public String getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }


}
