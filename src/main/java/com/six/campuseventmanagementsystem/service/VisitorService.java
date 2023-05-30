package com.six.campuseventmanagementsystem.service;

import com.six.campuseventmanagementsystem.entity.User;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;

import java.sql.Date;

public interface VisitorService {
    //实名验证，申请成为 主办方or赞助商
    Boolean Submit(String Password, String Account, String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType);
    String RealName(String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType);
}
