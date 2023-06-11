package com.six.campuseventmanagementsystem.controller;


import com.six.campuseventmanagementsystem.entity.Ads;
import com.six.campuseventmanagementsystem.service.AdsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "赞助商管理广告信息接口",tags = "赞助商管理广告信息接口")
@RequestMapping("/CEMS/Ads")
public class AdsController {
    @Autowired
    private AdsService adsService;

    //赞助商创建广告信息
    @ApiOperation(value = "赞助商创建广告信息接口，多参数",notes ="输入广告信息")
    @PostMapping("/createAds")
    public Integer createAds(Integer adsID,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount) {
        return adsService.createAds(adsID,sponsors,adsType,videoAdress,imageAdress,state,Items,id,UAccount);
    }

    //赞助商修改广告信息
    @ApiOperation(value = "赞助商修改广告信息接口，多参数",notes ="输入广告信息")
    @PutMapping("/updateAds")
    public Integer updateAds(Integer adsID,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount) {
        return adsService.updateAds(adsID,sponsors,adsType,videoAdress,imageAdress,state,Items,id,UAccount);
    }

    //赞助商删除广告信息
    @ApiOperation(value = "赞助商删除广告信息接口，多参数",notes ="输入广告信息id")
    @DeleteMapping("/deleteAds")
    public Integer deleteAds(@ApiParam(value = "adsID广告的id", required = true, example = "1")Integer adsID,@ApiParam(value = "赛事的id", required = true, example = "1")Integer id,@ApiParam(value = "UAccount当前登录的账号", required = true, example = "1")String UAccount){
        return adsService.deleteAds(adsID,id,UAccount);
    }

    //管理员创建广告信息
    @ApiOperation(value = "管理员创建广告信息接口，多参数",notes ="输入广告信息，传递当前登录的账号")
    @PostMapping("/AcreateAds")
    public Integer adminCreateAds(Integer adsID,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id) {
        return adsService.adminCreateAds(adsID,sponsors,adsType,videoAdress,imageAdress,state,Items,id);
    }

    //管理员修改广告信息
    @ApiOperation(value = "管理员修改广告信息接口，多参数",notes ="输入广告信息，传递当前登录的账号")
    @PutMapping("/AupdateAds")
    public Integer adminUpdateAds(Integer adsID,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id) {
        return adsService.adminUpdateAds(adsID,sponsors,adsType,videoAdress,imageAdress,state,Items,id);
    }

    //管理员删除广告信息
    @ApiOperation(value = "管理员删除广告信息接口，多参数",notes ="输入广告信息id，传递当前登录的账号")
    @DeleteMapping("/AdeleteAds")
    public Integer adminDeleteAds(@ApiParam(value = "adsID广告的id", required = true, example = "1")Integer adsID,@ApiParam(value = "赛事的id", required = true, example = "1")Integer id){
        return adsService.adminDeleteAds(adsID,id);
    }

    //查询广告信息
    @ApiOperation(value = "查询广告信息接口，多参数",notes ="输入广告信息id")
    @GetMapping("/selectAds")
    public Ads selectAds(@ApiParam(value = "adsID", required = true, example = "1")Integer adsID){
        return adsService.selectAds(adsID);
    }
}
