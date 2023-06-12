package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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

    //根据ID删除
    @DeleteMapping("DeleteById")
    public Integer DeleteById(Integer ID){
        return matchService.DeleteById(ID);
    }

    //查询所有赛事信息
    @PostMapping("SeleteAll")
    public IPage SeleteAll(Integer page, Integer size, String token){
        return matchService.SelectAll(page, size, token);
    }

    //根据ID修改赛事信息
    @PutMapping("UpdateById")
    public Integer UpdateById(String unit, Integer id, String unitAddress, String type,
                              String items, String matchTime, String place, String number,
                              String documentNumber, String state){
        return matchService.UpdateById(unit, id, unitAddress, type, items, matchTime, place, number, documentNumber, state);
    }
}
