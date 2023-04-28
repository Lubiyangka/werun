package com.weun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weun.entity.User;
import com.weun.util.R;

public interface IUserService extends IService<User> {
    User selectByUser(String username);
    R register(User user);
    R login(User user);
    Boolean logout();
}
