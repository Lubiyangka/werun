package com.weun;

import com.weun.dao.UserDao;
import com.weun.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.selectByUser("Jin le"));
    }

}
