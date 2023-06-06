package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Notice;
import com.six.campuseventmanagementsystem.entity.Match;
import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.mapper.NoticeMapper;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.verify.StrNotice;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private MatchMapper matchMapper;

    /**
     * 根据消息的 发送对象和用户账号 创建消息
     * @return 返回更新记录数
     */
    @Override
    public Integer BulidUserNotice(String Sendto, String Account, String NoticeType, String NoticeAction){
        Integer result;
        StrNotice strNotice = new StrNotice();
        DateTime dateTime = new DateTime();
        String Time = dateTime.toString("yyyy-MM-dd hh:mm:ss");
        Notice notice = new Notice(Account+strNotice.Type(NoticeType, NoticeAction), Account+strNotice.Message(NoticeType, NoticeAction), Time, Sendto, Account);
        result = noticeMapper.insert(notice);
        return result;
    }


    /**
     * 根据消息的 发送对象和用户账号 创建赛事消息
     * @return 返回更新记录数
     */
    @Override
    public Integer BulidMatchNotice(Integer MatchId, String Sendto, String Account, String NoticeType, String NoticeAction){
        Integer result;
        StrNotice strNotice = new StrNotice();
        DateTime dateTime = new DateTime();
        String Time = dateTime.toString("yyyy-MM-dd hh:mm:ss");
        QueryWrapper<Match> matchQueryWrapper = new QueryWrapper<>();
        matchQueryWrapper.eq("id", MatchId);
        Match match = matchMapper.selectOne(matchQueryWrapper);
        String mstr = match.getMatchTime() + "," + match.getItems() + " ";
        Notice notice = new Notice(mstr+strNotice.Type(NoticeType, NoticeAction), mstr+strNotice.Message(NoticeType, NoticeAction), Time, Sendto, Account);
        result = noticeMapper.insert(notice);
        return result;
    }


    /**
     * 根据 id 删除消息
     * @return 返回更新记录数
     */
    @Override
    public Integer DeleteById(Integer id){
        Integer result;
        Notice notice = new Notice();
        notice.setId(id);
        result = noticeMapper.deleteById(notice);
        return result;
    }

    /**
     * 根据 用户账号 查找消息
     * @return 返回IPage类型消息记录
     */
    @Override
    public IPage SelectByAccount(String UserType, String Account, Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<Notice> noticepage = new Page<>((page-1)*size,size);
            QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
            if(UserType.equals("赞助商")||UserType.equals("主办方")){
                noticeQueryWrapper.eq("UAccount", Account);
                IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
                return noticeipage;
            }
            else if(UserType.equals("管理员")){
                noticeQueryWrapper.eq("AAcount", Account);
                IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
                return noticeipage;
            }else
                return null;
        }else
            return null;
    }
}
