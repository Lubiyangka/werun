package com.weun.controller;

import com.weun.entity.User;
import com.weun.service.IUserService;
import com.weun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *1.前端
 *1.1.用户
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;
    //1.1.1.登录
    @PostMapping("/login")
    public R login(User user){
        return new R(iUserService.login(user));
    }
    //1.1.2.注册
    @PostMapping("/register")
    public R register(User user,String rePassword){
        return new R(iUserService.register(user,rePassword));
    }

}
