package com.werun.demo_werun;

import com.werun.demo_werun.entity.User;
import com.werun.demo_werun.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoWerunApplicationTests {
    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
        User user=new User();
        user.setPassword("234");
        user.setUsername("Jin le");
        userService.login(user);
    }

}
