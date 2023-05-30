package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.joda.time.DateTime;

@TableName("tb_vetting")
public class Vetting {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String Type;
    private String Message;
    private String Time;
    private String Sendto;
    private String State;

    public Vetting(String type, String message, String time, String sendto) {
        Type = type;
        Message = message;
        Time = time;
        Sendto = sendto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSendto() {
        return Sendto;
    }

    public void setSendto(String sendto) {
        Sendto = sendto;
    }


    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Vetting{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                ", Message='" + Message + '\'' +
                ", Time=" + Time +
                ", Sendto='" + Sendto + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
