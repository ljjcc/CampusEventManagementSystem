package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@RestController
@CrossOrigin
@RequestMapping("/CEMS/Match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    //提交
    @PostMapping("/BuildMatch")
    public Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime, String Place, String Number, String DocumentNumber, String Account){
        return matchService.BuildMatch(Unit, UnitAddress, Type, Items, MatchTime, Place, Number, DocumentNumber, Account);
    }
}
