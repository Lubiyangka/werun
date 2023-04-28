package com.werun.demo_werun.util;


import com.werun.demo_werun.entity.User;
import com.werun.demo_werun.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class MyRealm extends AuthorizingRealm{
    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户信息
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        User user=userService.selectByUser(token.getUsername());
        //使用service获取信息
        //非空判断
        if(user==null){
            return null;
        }
        //返回数据
        return new SimpleAuthenticationInfo(user,user.getUsername(),getName());
    }
}