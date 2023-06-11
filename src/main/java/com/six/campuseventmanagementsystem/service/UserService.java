package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface UserService {
    Integer SPUpdateUserType(Integer ID, String UserType);

    Integer UpdateUserType(Integer ID,String UserType);

    /**
     * 根据User的ID删除User
     * @return 返回更改数据条数
     */
    Integer DeleteById(Integer ID);
    /**
     * 根据User的Account查找User的通知
     * @return 返回IPage类型的User通知
     */
    IPage SelectUserNotice(String Account, Integer page, Integer size, String token);


    /**
     * 根据Admin的Account查找Admin的通知
     * @return 返回IPage类型的Admin通知
     */
    IPage SelectAdminNotice(String Account, Integer page, Integer size, String token);

}
