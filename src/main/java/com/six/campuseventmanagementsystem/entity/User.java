package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_user")
public class User {
    @TableField("username")
    private String UserName;
    private String Sex;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String Unit;
    private String Address;
    private String Age;
    private String Number;
    private String Account;
    private String Password;
    private String Origin;
    @TableField("usertype")
    private String UserType;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
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

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", ID=" + id +
                ", Unit='" + Unit + '\'' +
                ", Address='" + Address + '\'' +
                ", Age='" + Age + '\'' +
                ", Number='" + Number + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", Origin='" + Origin + '\'' +
                ", UserType='" + UserType + '\'' +
                '}';
    }
}
