package com.six.campuseventmanagementsystem.service;

public interface MatchService {

    /**
     * 根据 创建赛事活动信息 内的数据生成 赛事消息 ，并发送通知和申请
     * @return 返回更新记录数
     */
    Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime,
                       String Place, String Number, String DocumentNumber, String Account);




}
