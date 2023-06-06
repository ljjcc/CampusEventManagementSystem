package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.six.campuseventmanagementsystem.entity.Notice;
import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.entity.Vetting;
import com.six.campuseventmanagementsystem.entity.Visitor;
import com.six.campuseventmanagementsystem.mapper.*;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.VettingService;
import com.six.campuseventmanagementsystem.service.VisitorService;
import com.six.campuseventmanagementsystem.verify.StrNotice;
import com.six.campuseventmanagementsystem.verify.StrVetting;
import com.sun.org.apache.xpath.internal.operations.Bool;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private VettingMapper vettingMapper;
    @Autowired
    private VettingService vettingService;
    @Autowired
    private NoticeService noticeService;

    //游客提交申请成为主办方/赞助商的审核
    @Override
    public Integer Submit(String Password, String Account, String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType){
        Integer result;
        User user = new User(Password, Account, UserName, Sex, Nation, birthday, DocumentType, DocumentNumber, MAddress, Unit, Number, Origin, UserType);
        user.setState("N");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("Account", Account);
        User selectuser =userMapper.selectOne(userQueryWrapper);
        if(selectuser == null){
            userMapper.insert(user);
            if(UserType.equals("赞助商 ")){
                result = vettingService.BuildAllVetting(Account,"RealName","zzs")+
                         noticeService.BulidUserNotice(UserType, Account, "RealName", "zzs");
                return result;
            }
            else if(UserType.equals("主办方")){
                result = vettingService.BuildAllVetting(Account, "RealName", "zbf")+
                         noticeService.BulidUserNotice(UserType, Account, "RealName", "zbf");
                return result;
            }else
                return null;

        }else
            return null;
    }

//实名验证，申请成为 主办方or赞助商
//    @Override
//    public String RealName(String UserName, String Sex, String Nation,String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType){
//      return null;
//    };
}
