package com.weun.util;

import com.weun.entity.User;
import com.weun.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {
    @Autowired
    IUserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String jwt=token.getCredentials().toString();
        if(!JwtUtil.verify(jwt)){
            throw new ExpiredCredentialsException("token认证，token错误或者国企，重新登陆");
        }
        String username=JwtUtil.getUsername(jwt);
        User user=userService.selectByUser(username);
        if (user==null){
            throw new AuthenticationException("该用户不存在");
        }
        SecurityUtils.getSubject().getSession().setAttribute("User",user);
        return new SimpleAuthenticationInfo(username,jwt,getName());


//        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
//        String username=usernamePasswordToken.getUsername();
//        User user=userService.selectByUser(username);
//        System.out.println("认证");
//        if(user != null){
//            return new SimpleAuthenticationInfo(username,user.getPassword(),getName());
//        }
//        return null;
    }
}