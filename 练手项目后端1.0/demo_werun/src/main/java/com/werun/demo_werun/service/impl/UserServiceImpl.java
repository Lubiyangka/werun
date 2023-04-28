package com.werun.demo_werun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.werun.demo_werun.dao.UserDao;
import com.werun.demo_werun.entity.User;
import com.werun.demo_werun.service.IUserService;
import com.werun.demo_werun.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectByUser(String username) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return userDao.selectOne(queryWrapper);
    }
    @Override
    public R register(User user, String rePassword){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        User one=super.getOne(wrapper);
        if(one != null){
            return new R(false,"账户已注册");
        }
        else {
            if(user.getPassword().equals(rePassword)){
                return new R(userDao.insert(user)>0);
            }
            else {
                return new R(false,"两次密码不一致");
            }
        }
    }
    public R login(User user){
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            subject.login(token);
            return new R(true);
        }
        catch (UnknownAccountException unknownAccountException){
            return new R(false,"账户不存在");
        }
        catch (IncorrectCredentialsException incorrectCredentialsException){
            return new R(false,"密码错误");
        }
//        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("username",user.getUsername());
//        User one=super.getOne(queryWrapper);
//        if (one.getPassword().equals(user.getPassword())){
//            return new R(true,"login!");
//        }
//        else{
//            return new R(false,"shibai");
//        }
    }

    @Override
    public Boolean logout() {
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return true;
    }
}
