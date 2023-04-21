package com.werun.demo_werun.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.werun.demo_werun.entity.User;
import com.werun.demo_werun.util.R;


public interface IUserService extends IService<User> {
    User selectByUser(String username);
    R register(User user, String rePassword);
    R login(User user);
    Boolean logout();
}
