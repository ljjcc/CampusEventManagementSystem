package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.service.VisitorService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin
@RequestMapping("/CEMS/Visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @PostMapping("/RealName")
    public Integer Submit(String Password, String Account, String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType){
        return visitorService.Submit(Password, Account, UserName, Sex, Nation, birthday, DocumentType, DocumentNumber, Unit, Number, Origin, MAddress, UserType);
    }

    @DeleteMapping("DeleteById")
    public Integer DeleteById(Integer ID){
        return visitorService.DeleteById(ID);
    }
}
