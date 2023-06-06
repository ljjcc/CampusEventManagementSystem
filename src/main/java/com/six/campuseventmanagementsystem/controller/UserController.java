package com.six.campuseventmanagementsystem.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.mapper.AdminMapper;
import com.six.campuseventmanagementsystem.service.MatchService;
import com.six.campuseventmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/CEMS/User")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MatchService matchService;

    //修改用户权限
    @PutMapping("/UpUserType")
    public Boolean UpUserType(Integer ID,String UserType){
        return userService.UpdateUserType(ID,UserType);
    }

    /**
     * 根据User的Account查找User的通知
     * @return 返回IPage类型的User通知
     */
    @PostMapping("/SelectUserNotice")
    public IPage SelectUserNotice(String Account, Integer page, Integer size, String token) {
        return userService.SelectUserNotice(Account, page, size, token);
    }

    /**
     * 根据Admin的Account查找Admin的通知
     * @return 返回IPage类型的Admin通知
     */
    @PostMapping("SelectAdminNotice")
    public IPage SelectAdminNotice(String Account, Integer page, Integer size, String token) {
        return userService.SelectAdminNotice(Account, page, size, token);
    }

    /**
     * 根据提交的 赛事申请表单 生成赛事申请
     * @return 返回更改数据条数
     */
    @PostMapping("/BuildMatch")
    public Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime, String Place, String Number, String DocumentNumber, String Account){
        return matchService.BuildMatch(Unit, UnitAddress, Type, Items, MatchTime, Place, Number, DocumentNumber, Account);
    }

}



