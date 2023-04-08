package com.weun.service;


import com.weun.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService iUserService;

    @Test
    void testRegister(){
        User user=new User();
        user.setUserId("test124");
        user.setUserPassword("030404");
        iUserService.register(user,"030404");
    }
    @Test
    void testLogin(){
        User user=new User();
        user.setUserId("test123");
        user.setUserPassword("786756");
        iUserService.login(user);
    }

}
