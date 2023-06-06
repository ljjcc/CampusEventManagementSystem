package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/CEMS/Notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/DeleteByid")
    public Integer DeleteById(Integer id){
        return noticeService.DeleteById(id);
    }
}
