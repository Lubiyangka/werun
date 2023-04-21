package com.weun.config;

import com.weun.util.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();

        factoryBean.setSecurityManager(manager);
        ThreadContext.bind(manager);
        //SecurityUtils.setSecurityManager(manager);
        Map<String,String> map = new LinkedHashMap<>();

        //这里应添加所有需拦截页面
        map.put("/notebooks/**","authc");
        //map.put("/users/logout","logout");
        //放行页面
//        map.put("/users/register/*","anon");
//        map.put("/users/login", "anon");
        map.put("/**","anon");
        factoryBean.setFilterChainDefinitionMap(map);

        //设置未登录的重定向url
        factoryBean.setLoginUrl("/users/toLogin");

//        //设置登陆后无权限访问后重定向的页面，这个项目用不到
//        bean.setUnauthorizedUrl("/unauth");
        return factoryBean;
    }


    //2.SecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(MyRealm myRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        // 设置自定义 realm.
        securityManager.setRealm(myRealm);
        //关闭session
        DefaultSubjectDAO subjectDAO=new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator=new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }

    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
