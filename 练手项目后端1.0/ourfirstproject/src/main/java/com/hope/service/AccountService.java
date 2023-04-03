package com.hope.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.pojo.Account;
import com.hope.pojo.RegisterAccount;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.stereotype.Service;


public interface AccountService extends IService<Account> {
    Account selectByAccount(String username);
    boolean saveByAccount(Account account);

}
