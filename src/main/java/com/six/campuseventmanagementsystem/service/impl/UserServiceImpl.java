package com.six.campuseventmanagementsystem.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.entity.Notice;
import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.mapper.NoticeMapper;
import com.six.campuseventmanagementsystem.mapper.UserMapper;
import com.six.campuseventmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    //更新类别
    @Override
    public Boolean UpdateUserType(Integer ID,String UserType) {
        User user = new User();
        user.setID(ID);
        user.setUserType(UserType);
        userMapper.updateById(user);
        return true;
    }

    /**
     * 根据User的Account查找User的通知
     * @return 返回IPage类型的User通知
     */
    @Override
    public IPage SelectUserNotice(String Account, Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<Notice> noticepage = new Page<>((page-1)*size,size);
            QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
            noticeQueryWrapper.eq("UAccount", Account);
            IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
            return noticeipage;
        }else
            return null;
    }

    /**
     * 根据Admin的Account查找Admin的通知
     * @return 返回IPage类型的Admin通知
     */
    @Override
    public IPage SelectAdminNotice(String Account, Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<Notice> noticepage = new Page<>((page-1)*size,size);
            QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
            noticeQueryWrapper.eq("AAccount", Account);
            IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
            return noticeipage;
        }else
            return null;
    }
}
