package com.weun.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weun.util.JwtToken;
import com.weun.util.R;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtFilter extends BasicHttpAuthenticationFilter {
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        System.out.println("isLoginAttempt");
        HttpServletRequest req= (HttpServletRequest) request;
        String token=req.getHeader("Authorization");
        return token!=null;
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断请求的请求头是否带上 "Token"
        if (isLoginAttempt(request, response)) {
            String token = null;
            try {
                HttpServletRequest req = (HttpServletRequest) request;
                token = req.getHeader("Authorization");
                JwtToken jwt = new JwtToken(token);
                //交给自定义的realm对象去登录，如果错误他会抛出异常并被捕获
                getSubject(request, response).login(jwt);
                return true;
            } catch (ExpiredCredentialsException e) {
                R result = R.error(500,"Token认证失败!");
                try {
                    out(response, result);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return false;
            } catch (AuthenticationException e) {
                R result = R.error(500,"Token错误!用户不存在!");
                try {
                    out(response, result);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        }
        //token不存在
        R result = R.error(500,"无token,请重新登录!");
        try {
            out(response,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private void out(ServletResponse response, R res) throws IOException {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        ObjectMapper mapper = new ObjectMapper();
        String jsonRes = mapper.writeValueAsString(res);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.getOutputStream().write(jsonRes.getBytes());
    }

}
