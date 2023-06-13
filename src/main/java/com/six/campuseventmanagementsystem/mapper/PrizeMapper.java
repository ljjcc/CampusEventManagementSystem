package com.six.campuseventmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.six.campuseventmanagementsystem.entity.Prize;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PrizeMapper extends BaseMapper<Prize> {
    @Select("SELECT MAX(id) FROM tb_prize")
    Integer selectMaxprizeID();
}
