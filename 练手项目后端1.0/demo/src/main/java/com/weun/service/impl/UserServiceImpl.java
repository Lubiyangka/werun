package com.weun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weun.dao.UserDao;
import com.weun.entity.User;
import com.weun.service.IUserService;
import com.weun.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectByUser(String userId) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return userDao.selectOne(queryWrapper);
    }
    @Override
    public R register(User user, String rePassword){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_id",user.getUserId());
        User one=super.getOne(wrapper);
        if(one != null){
            return new R(false,"账户已注册");
        }
        else {
            if(user.getUserPassword().equals(rePassword)){
                return new R(userDao.insert(user)>0);
            }
            else {
                return new R(false,"两次密码不一致");
            }
        }
    }
    public R login(User user){
        Subject subject=SecurityUtils.getSubject();
        System.out.println(subject);
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserId(),user.getUserPassword());
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
    }

    @Override
    public Boolean logout() {
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return true;
    }
}
