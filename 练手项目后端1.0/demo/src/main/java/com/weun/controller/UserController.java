package com.weun.controller;

import com.weun.entity.User;
import com.weun.service.IUserService;
import com.weun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private IUserService iUserService;
    //注册
    @PostMapping("")
    public R register(User user,String rePassword){
        return new R(iUserService.register(user,rePassword));
    }
    //登录
    @PostMapping("")
    public R login(User user){
        return new R(iUserService.login(user));
    }
}
