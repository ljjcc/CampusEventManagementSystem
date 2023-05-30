package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.six.campuseventmanagementsystem.entity.Notice;
import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.entity.Vetting;
import com.six.campuseventmanagementsystem.entity.Visitor;
import com.six.campuseventmanagementsystem.mapper.*;
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

    //游客提交申请成为主办方/赞助商的审核
    @Override
    public Boolean Submit(String Password, String Account, String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType){
        User user = new User(Password, Account, UserName, Sex, Nation, birthday, DocumentType, DocumentNumber, Unit,Number, Origin, MAddress, UserType);
        user.setState("未启用");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("Account", Account);
        User selectuser =userMapper.selectOne(userQueryWrapper);
        if(selectuser == null){
            userMapper.insert(user);
            StrNotice strNotice = new StrNotice();
            StrVetting strVetting = new StrVetting();
            DateTime dateTime = new DateTime();
            String Time = dateTime.toString("yyyy-MM-dd hh:mm:ss");
            Notice notice = new Notice(strNotice.Type("RealName","submit"), strNotice.Message("RealName", "submit"), Time, UserType, Account);
            Vetting avetting = new Vetting(UserName+strVetting.Type("RealName", "submit"), UserName+strVetting.Message("RealName", UserType), Time, "管理员");
            Vetting svetting = new Vetting(UserName+strVetting.Type("RealName", "submit"), UserName+strVetting.Message("RealName", UserType), Time, "超级管理员");
            noticeMapper.insert(notice);
            vettingMapper.insert(avetting);
            vettingMapper.insert(svetting);
            return true;
        }else
            return false;
    }

    //实名验证，申请成为 主办方or赞助商
    @Override
    public String RealName(String UserName, String Sex, String Nation,String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType){

      return null;
    };
}
