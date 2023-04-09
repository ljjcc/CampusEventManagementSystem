package com.six.campuseventmanagementsystem.service;

public interface LoginService {
    boolean verify(String Account,String Password);
    boolean sign(String Name,String Account,String Password,String Number,String UserType);
}
