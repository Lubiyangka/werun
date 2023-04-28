package com.werun.demo_werun.config;


import com.werun.demo_werun.util.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {



    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager manager){

        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置SecurityManger
        bean.setSecurityManager(manager);
        //建立页面拦截
        Map<String,String> map=new LinkedHashMap<>();
        /*
            anon: 无需认证
            authc: 需要认证
            user: 需要使用记住我
            perms:对特定资源的权限
            role: 拥有
         */
        map.put("/notebook/**","authc");
        map.put("/users/logout","logout");
        map.put("/**","anon");
        bean.setFilterChainDefinitionMap(map);
        bean.setLoginUrl("/users/toLogin");
        return bean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }


    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

}
