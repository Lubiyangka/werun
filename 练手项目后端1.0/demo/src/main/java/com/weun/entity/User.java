package com.weun.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
@TableName("user")
public class User implements Serializable {
    @TableId
    private String userId;
    private String userPassword;

}
