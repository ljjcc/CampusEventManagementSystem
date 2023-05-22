package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.entity.Player;
import com.six.campuseventmanagementsystem.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    //修改个人账户信息
    @PutMapping("/changePMess")
    public Integer changePMess(Integer id,String headshot,String nickname,String name,String school,
                               String address,String sex,String phone,Integer age){
        return playerService.changePMess(id,headshot,nickname,name,school,address,sex,phone,age);
    }

    //删除个人账户信息：注销账户
    @DeleteMapping("/delePMess")
    public Integer delePMess(Integer id){
        return playerService.delePMess(id);
    }

    //查询个人账户信息
    @GetMapping("/selePMess")
    public Player selePMess(Integer id){
        return playerService.selePMess(id);
    }
}
