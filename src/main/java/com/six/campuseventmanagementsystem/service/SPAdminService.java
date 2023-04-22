package com.six.campuseventmanagementsystem.service;

import com.six.campuseventmanagementsystem.entity.Admin;

import java.util.List;

public interface SPAdminService {
    Boolean InsertAdmin(String AdminName,String Account,String Password,String OldType,String NewType);
    Boolean UpdateAdmin(Integer ID,String AdminName,String Account,String Password,String OldType,String NewType);
    Boolean DeleteAdmin(String ID);
    List<Admin> SelectAllAdmin();
    Boolean UpdateSPAdmin(Integer ID,String SPAdminName,String Account,String Password,String OldType,String NewType);
}
