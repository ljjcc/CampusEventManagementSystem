package com.six.campuseventmanagementsystem.service;

public interface SPAdminService {
    Boolean InsertAdmin(String AdminName,String Account,String Password,String OldType,String NewType);
    Boolean UpdateAdmin(Integer ID,String AdminName,String Account,String Password,String OldType,String NewType);
    Boolean DeleteAdmin(String ID);
    Boolean UpdateSPAdmin(Integer ID,String SPAdminName,String Account,String Password,String OldType,String NewType);
}
