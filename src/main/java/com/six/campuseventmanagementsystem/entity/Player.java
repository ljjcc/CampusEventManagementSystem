package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 欣欣
 * headshot头像,nickname昵称,name姓名,school学校,address地址,sex性别,phone电话,origin籍贯;
 */
@Data
@TableName("tb_player")
public class Player {
    @TableId(type = IdType.AUTO)
    private int id;
    private int age;
    private String headshot,nickname,name,school,address,sex,phone,origin;
}
