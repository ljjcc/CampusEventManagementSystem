package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

/**
 * 实体类
 */
@ApiModel(value = "管理员实体类",description = "管理员身份消息信息，对应数据库中的tb_admin表")
@TableName("tb_admin")
public class Admin {

    @TableField("adminname")
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String AdminName;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Sex;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Nation;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private DateTime Birthday;
    @TableField("documenttype")
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String DocumentType;
    @TableField("documentnumber")
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String DocumentNumber;
    @TableField("maddress")
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String MAddress;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private Integer id;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Unit;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Address;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Age;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Number;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Origin;
    @TableField("usertype")
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String UserType;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Account;
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String Password;
    @TableField("state")
    @ApiModelProperty(value = "管理员名字",name = "AdminName")
    private String State;

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public DateTime getBirthday() {
        return Birthday;
    }

    public void setBirthday(DateTime birthday) {
        Birthday = birthday;
    }

    public String getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(String documentType) {
        DocumentType = documentType;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public String getMAddress() {
        return MAddress;
    }

    public void setMAddress(String MAddress) {
        this.MAddress = MAddress;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
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

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminName='" + AdminName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", id=" + id +
                ", Unit='" + Unit + '\'' +
                ", Address='" + Address + '\'' +
                ", Age='" + Age + '\'' +
                ", Number='" + Number + '\'' +
                ", Origin='" + Origin + '\'' +
                ", UserType='" + UserType + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
