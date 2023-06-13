package com.six.campuseventmanagementsystem.service;

import com.six.campuseventmanagementsystem.entity.Prize;

import java.util.List;

public interface PrizeService {
    /**
     * 赞助商创建奖品信息
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @param UAccount 当前登录的账号
     * @return 返回创建的奖品信息条数
     */
    Integer InsertPrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                        String level,String details,String image,String state,Integer raceID,String UAccount);

    /**
     * 赞助商更新奖品信息
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @param UAccount 当前登录的账号
     * @return 返回更新的奖品信息条数
     */
    Integer UpdatePrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                        String level,String details,String image,String state,Integer raceID,String UAccount);

    /**
     * 赞助商删除奖品信息
     * @param raceID 所属赛事id
     * @param id 奖品id
     * @param UAccount 当前登录的账号
     * @return 返回删除的奖品信息条数
     */
    Integer DeletePrize(Integer raceID,Integer id,String UAccount);

    /**
     * 管理员新建奖品信息
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @return 返回新建的奖品信息条数
     */
    Integer adminInsertPrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                             String level,String details,String image,String state,Integer raceID);
    /**
     * 管理员更新奖品信息
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @return 返回更新的奖品信息条数
     */
    Integer adminUpdatePrize(Integer id,String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                             String level,String details,String image,String state,Integer raceID);

    /**
     * 管理员删除奖品信息
     * @param id 奖品id
     * @return 返回删除的奖品条数
     */
    Integer adminDeletePrize(Integer id);

    /**
     * 根据id查询奖品信息
     * @param id 奖品id
     * @return 返回查询到的奖品信息，封装在Prize对象里
     */
    Prize SelectPrizeById(Integer id);

    /**
     * 查询全部奖品信息
     * @return 返回查询一个封装有全部奖品信息对象的数组
     */
    List<Prize> selectAllPrize();


}
