package com.hope.controller;

import com.hope.pojo.Account;
import com.hope.pojo.R;
import com.hope.pojo.RegisterAccount;
import com.hope.service.impl.AccountServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RestController
public class LoginRegisterController {
    @Autowired
    AccountServiceImpl accountService;

    //用户注册接口
    @PostMapping("/register")
    public R register(@RequestBody RegisterAccount account){
        R r =new R();
        if(accountService.selectByAccount(account.getUsername())!=null){
            r.setMsg("用户名已存在");
            return r;
        }

        if(!(account.getPassword().equals(account.getConfirmedPassword()))){
            r.setMsg("两次密码不一致");
            return r;
        }

        Account savedAccount = new Account();
        savedAccount.setUsername(account.getUsername());
        savedAccount.setPassword(account.getPassword());

        r.setFlag(accountService.saveByAccount(savedAccount));
        if(r.getFlag()) {
            r.setMsg("注册成功！");
        }
        return r;
    }

    //用户登录接口
    @PostMapping("/login")
    public R login(@RequestBody Account account, Model model){
        R r =new R();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account.getUsername(),account.getPassword());
        try {
            subject.login(token);
            r.setMsg("登陆成功！");
            return r;
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            r.setMsg("用户名不存在");
            return r;
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            r.setMsg("密码错误");
            return r;
        }
    }


   //登出接口
    @PostMapping("/logout")
    public R logout(){
        R r =new R();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        r.setMsg("登出成功！");
        return r;
    }
}