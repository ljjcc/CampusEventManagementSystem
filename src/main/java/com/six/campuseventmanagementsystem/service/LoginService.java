package com.six.campuseventmanagementsystem.service;

import io.jsonwebtoken.Claims;

import java.io.File;

public interface LoginService {
    String verify(String Account, String Password);
    boolean sign(String Name, String Account, String Password);
    String generateToken(String UserType);
    public Claims getClaimsByToken(String token);

}
