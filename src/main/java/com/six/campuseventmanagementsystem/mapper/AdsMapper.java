package com.six.campuseventmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.six.campuseventmanagementsystem.entity.Ads;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * @author 欣欣
 */
@Mapper
public interface AdsMapper extends BaseMapper<Ads> {
    @Select("SELECT MAX(adsID) FROM tb_ads")
    Integer selectMaxadsID();
}
