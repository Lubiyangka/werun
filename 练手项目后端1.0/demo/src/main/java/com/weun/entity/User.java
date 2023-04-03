package com.weun.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("")
public class User implements Serializable {
    private Integer Id;
    private String userId;
    private String userPassword;

}
