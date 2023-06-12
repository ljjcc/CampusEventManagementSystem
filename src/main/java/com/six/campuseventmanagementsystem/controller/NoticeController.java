package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/CEMS/Notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //删除通知消息
    @DeleteMapping("/DeleteByid")
    public Integer DeleteById(Integer id){
        return noticeService.DeleteById(id);
    }

    //查询通知消息 UserType = 管理员 or 主办方 or 赞助商
    @PostMapping("/SelectByAccount")
    public IPage SelectByAccount(String UserType, String Account, Integer page, Integer size, String token){
        return noticeService.SelectByAccount(UserType, Account, page, size, token);
    }
}
