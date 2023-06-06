package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.service.MatchService;
import com.six.campuseventmanagementsystem.service.VettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/CEMS/Vetting")
public class VettingController {

    @Autowired
    private VettingService vettingService;
    @Autowired
    private MatchService matchService;

    //审核用户的申请
    @PutMapping("/ChangeUserState")
    public Integer ChangeUserState(Integer id, String State){
        return vettingService.ChangeUserState(id, State);
    }

    //审核赛事的申请
    @PutMapping("/ChangeMatchState")
    public Integer ChangeMatchState(Integer MatchId, String Account, String State){
        return vettingService.ChangeMatchState(MatchId, Account, State);
    }

    //删除审核消息
    @PostMapping("/DeleteById")
    public Integer DeleteById(Integer id){
        return vettingService.DeleteById(id);
    }
}
