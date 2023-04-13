package com.weun.util;

import com.weun.entity.User;
import com.weun.service.IUserService;
import com.weun.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject= SecurityUtils.getSubject();
        User user=(User) subject.getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
        //return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) authenticationToken;
        User user=userService.selectByUser(usernamePasswordToken.getUsername());
        if(user != null){
            return new SimpleAuthenticationInfo(user,user.getUserPassword(),getName());
        }
        return null;
    }
}
