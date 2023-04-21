package com.werun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.werun.pojo.Account;


public interface AccountService extends IService<Account> {
    Account selectByAccount(String username);
    boolean saveByAccount(Account account);

}
