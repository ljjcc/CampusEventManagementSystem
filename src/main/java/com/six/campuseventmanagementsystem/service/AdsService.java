package com.six.campuseventmanagementsystem.service;

import com.six.campuseventmanagementsystem.entity.Ads;

import java.util.List;

/**
 * 广告信息管理
 */
public interface AdsService {



    /**
     * 获取该比赛的开始时间
     */
    String getRaceBeginTime(Integer raceID);
    /**
     * 比较两个时间，判断比赛是否已经开始
     */
    Boolean isBegin(Integer raceID);
    /**
     * 赞助商新建广告信息
     */
    Integer createAds(String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount);
    /**
     * 管理员新建广告信息
     */
    Integer adminCreateAds(String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id);
    /**
     * 赞助商修改广告信息
     */
    Integer updateAds(Integer adsID,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount);
    /**
     * 管理员修改广告信息
     */
    Integer adminUpdateAds(Integer adsID,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id);
    /**
     * 赞助商删除广告信息
     */
    Integer deleteAds(Integer adsID,Integer id,String UAccount);
    /**
     * 管理员商删除广告信息
     */
    Integer adminDeleteAds(Integer adsID,Integer id);
    /**
     * 根据id查询广告信息
     */
    Ads selectAdsByID(Integer adsID);

    /**
     * 查询全部广告信息
     * @return
     */
    List<Ads> selectAllAds();

}
