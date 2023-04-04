package com.weun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weun.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
