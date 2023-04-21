package com.werun.pojo;

import lombok.Data;

@Data
public class RegisterAccount {
    private String username;
    private String password;
    private String ConfirmedPassword;

}
