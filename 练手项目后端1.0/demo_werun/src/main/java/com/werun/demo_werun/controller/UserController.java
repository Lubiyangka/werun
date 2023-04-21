package com.werun.demo_werun.controller;


import com.werun.demo_werun.entity.User;
import com.werun.demo_werun.service.IUserService;
import com.werun.demo_werun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/register/{rePassword}")
    public R register(@RequestBody User user,@PathVariable String rePassword){
        return iUserService.register(user,rePassword);
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
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

}
