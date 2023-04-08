package com.werun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.werun.entity.User;

public interface IUserService extends IService<User> {
    Boolean register(User user,String rePassword);

    Boolean login(User user);
}
