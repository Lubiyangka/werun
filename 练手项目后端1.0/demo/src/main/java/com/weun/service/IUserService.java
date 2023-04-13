package com.weun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weun.entity.User;

public interface IUserService extends IService<User> {
    User selectByUser(String userId);
    Boolean register(User user,String rePassword);

    Boolean login(User user);
    Boolean logout();
}
