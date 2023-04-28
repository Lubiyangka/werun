package com.weun.controller;

import com.weun.entity.User;
import com.weun.service.IUserService;
import com.weun.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public R login(@RequestBody User user){
        return iUserService.login(user);
    }
    //1.1.2.注册
    @PostMapping("/register")
    public R register(@RequestBody User user){
        return iUserService.register(user);
    }
//    @PostMapping("/register/{rePassword}")
//    public R register(@RequestBody Map<User,String> map){
//        map.get("userId");
//        return iUserService.register(user,rePassword);
//    }

    //1.1.3.退出登录
    @PostMapping("/logout")
    public R logout(){
        return new R(iUserService.logout(),"退出登录成功");
    }
    /*
     *前端对接
     */

}
