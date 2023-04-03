package com.hope.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hope.dao.AccountDao;
import com.hope.pojo.Account;
import com.hope.pojo.RegisterAccount;
import com.hope.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Override
    public Account selectByAccount(String username) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        return accountDao.selectOne(wrapper);
    }
    @Override
    public boolean saveByAccount(Account account) {
        return accountDao.insert(account) == 1;
    }
}
