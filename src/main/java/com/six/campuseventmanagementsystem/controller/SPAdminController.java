package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.service.SPAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SPAdmin")
public class SPAdminController {
    @Autowired
    private SPAdminService spAdminService;

    @PostMapping("/add")
    public Boolean InsertAdmin(String AdminName,String Account,String Password,String OldType,String NewType){
        return spAdminService.InsertAdmin(AdminName, Account, Password, OldType, NewType);
    }

    @PutMapping("/UpdateAdmin")
    public Boolean UpdateAdmin(Integer ID,String AdminName,String Account,String Password,String OldType,String NewType){
        return spAdminService.UpdateAdmin(ID, AdminName, Account, Password, OldType, NewType);
    }

    @DeleteMapping("/DeleteAdmin")
    public Boolean DeleteAdmin(String ID){
        return spAdminService.DeleteAdmin(ID);
    }

    @PutMapping("UpdateSPAdmin")
    public Boolean UpdateSPAdmin(Integer ID,String SPAdminName,String Account,String Password,String OldType,String NewType){
        return spAdminService.UpdateSPAdmin(ID, SPAdminName, Account, Password, OldType, NewType);
    }

}
