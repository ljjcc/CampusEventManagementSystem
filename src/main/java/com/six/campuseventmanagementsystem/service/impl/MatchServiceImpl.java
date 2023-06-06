package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.six.campuseventmanagementsystem.entity.Match;
import com.six.campuseventmanagementsystem.entity.Vetting;
import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.mapper.VettingMapper;
import com.six.campuseventmanagementsystem.service.MatchService;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.VettingService;
import com.six.campuseventmanagementsystem.verify.StrNotice;
import com.six.campuseventmanagementsystem.verify.StrVetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private VettingMapper vettingMapper;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private VettingService vettingService;

    /**
     * 根据 创建赛事活动信息 内的数据生成 赛事消息 ，并发送通知和审核申请
     * @return 返回更新记录数
     */
    @Override
    public Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime, String Place, String Number, String DocumentNumber, String Account){
        Integer result;
        Match match = new Match(Unit, UnitAddress, Type, Items, MatchTime, Place, Number, DocumentNumber, Account);
        result = matchMapper.insert(match);
        result +=noticeService.BulidMatchNotice(match.getId(), "主办方", Account, "Match", "submit")+
                 vettingService.BuildByMatchId(match.getId(), Account, "Match", "submit");
        return result;
    }



}
