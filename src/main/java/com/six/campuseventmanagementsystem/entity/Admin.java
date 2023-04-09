package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_admin")
public class Admin {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("adminname")
    private String AdminName;
    private String Account;
    private String Password;
    @TableField("oldtype")
    private String OldType;
    @TableField("newtype")
    private String NewType;



    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getOldType() {
        return OldType;
    }

    public void setOldType(String oldType) {
        OldType = oldType;
    }

    public String getNewType() {
        return NewType;
    }

    public void setNewType(String newType) {
        NewType = newType;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID=" + id +
                ", AdminName='" + AdminName + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", OldType='" + OldType + '\'' +
                ", NewType='" + NewType + '\'' +
                '}';
    }
}
