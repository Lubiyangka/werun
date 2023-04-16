package com.weun.config;

import com.weun.util.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //SecurityUtils.setSecurityManager(manager);
        Map<String,String> map = new HashMap<>();

        //这里应添加所有需拦截页面
        map.put("/notebooks/**","authc");

        //放行页面
        map.put("/users/register/*","anon");
        map.put("/users/login", "anon");
        bean.setFilterChainDefinitionMap(map);

        //设置未登录的重定向url
        bean.setLoginUrl("/users/toLogin");

//        //设置登陆后无权限访问后重定向的页面，这个项目用不到
//        bean.setUnauthorizedUrl("/unauth");
        return bean;
    }


    @Bean
    public DefaultWebSecurityManager manager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        return manager;
    }

    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }
}
