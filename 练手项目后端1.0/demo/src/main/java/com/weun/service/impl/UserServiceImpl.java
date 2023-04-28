package com.weun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weun.dao.UserDao;
import com.weun.entity.User;
import com.weun.service.IUserService;
import com.weun.util.JwtUtil;
import com.weun.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.xml.ws.spi.http.HttpExchange;
import javax.xml.ws.spi.http.HttpHandler;
import java.io.IOException;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements IUserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User selectByUser(String username) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return userDao.selectOne(queryWrapper);
    }
    @Override
    public R register(User user){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        User one=super.getOne(wrapper);
        if(one != null){
            return new R(false,"账户已注册");
        }
        else {
            return new R(userDao.insert(user)>0);
        }
    }
    public R login(User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        User one=super.getOne(queryWrapper);
        if ( one == null){
            return new R(false,"账户不存在");
        }
        else{
            if(one.getPassword().equals(user.getPassword())){
                String token =JwtUtil.createToken(user);
                return new R(true,token,"登录成功");
            }
            else {
                return new R(false,"密码错误");
            }
        }
//        Subject subject=SecurityUtils.getSubject();
//        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
//        token.setRememberMe(true);
//        //System.out.println(subject.isAuthenticated());
//        if(!subject.isAuthenticated()) {
//            try {
//                subject.login(token);
//                return new R(subject.isAuthenticated());
//            } catch (UnknownAccountException unknownAccountException) {
//                System.out.println(subject);
//                return new R(false, "账户不存在");
//            } catch (IncorrectCredentialsException incorrectCredentialsException) {
//                System.out.println(subject);
//                return new R(false, "密码错误");
//            }
//        }
//        else {
//            return new R(false,"账户已登陆");
//        }
    }

    @Override
    public Boolean logout() {
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        System.out.println("deneafa");
        return true;
    }
}
