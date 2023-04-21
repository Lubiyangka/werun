package com.weun.util;

import com.weun.entity.User;
import com.weun.service.IUserService;
import com.weun.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {
    @Autowired
    IUserService userService;

    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof UsernamePasswordToken;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从刚才封装的JWTToken中重新取出token
//        String jwt= token.getCredentials().toString();
//        //验证token
////        if (!JwtUtil.verify(jwt)){
////            throw new ExpiredCredentialsException("token认证失效，token错误或者过期，重新登陆");
////        }
//
//        //获取用户名
//        String username= JwtUtil.getUserId(jwt);
//
//        //获取用户
//        User user=userService.selectByUser(username);
//        if (user==null){
//            throw new AuthenticationException("该用户不存在");
//        }
//        //return new SimpleAuthenticationInfo(user,jwt,"MyRealm");
//        //对于获取不到对象的问题,网上搜索栏了很多种方法,这是其中一种,但未解决问题
//        //SecurityUtils.getSubject().getSession().setAttribute("User", user);
//        //return new SimpleAuthenticationInfo(jwt,jwt,"MyRealm");
//        //当把第一个参数从jwt变成user对象时,就可以获取当前用户了
//        return new SimpleAuthenticationInfo(user,jwt,"MyRealm");
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
        User user=userService.selectByUser(usernamePasswordToken.getUsername());
        System.out.println("认证");
        if(user != null){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        }
        return null;
    }
}