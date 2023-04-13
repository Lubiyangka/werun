package com.weun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weun.dao.UserDao;
import com.weun.entity.User;
import com.weun.service.IUserService;
import org.apache.shiro.SecurityUtils;
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
        queryWrapper.eq("uesr_id",userId);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public Boolean register(User user,String rePassword){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_id",user.getUserId());
        User one=super.getOne(wrapper);
        if(one != null){
            throw new RuntimeException("账户已注册");
        }
        else {
            if(user.getUserPassword().equals(rePassword)){
                return userDao.insert(user)>0;
            }
            else {
                throw new RuntimeException("两次密码不一致");
            }
        }
    }
    public Boolean login(User user){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id",user.getUserId());
        User oneUserId=super.getOne(wrapper);
        if(oneUserId==null){
            throw new RuntimeException("账户不存在");
        }
        else {
            wrapper.eq("user_password",user.getUserPassword());
            User onePassword=super.getOne(wrapper);
            if(onePassword==null){
                throw new RuntimeException("密码错误");
            }
        }
        return true;
    }

    @Override
    public Boolean logout() {
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return true;
    }
}
