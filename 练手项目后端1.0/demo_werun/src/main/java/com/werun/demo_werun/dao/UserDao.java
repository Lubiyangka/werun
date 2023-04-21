package com.werun.demo_werun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.werun.demo_werun.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
