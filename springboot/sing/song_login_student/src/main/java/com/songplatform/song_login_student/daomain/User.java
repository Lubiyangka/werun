package com.songplatform.song_login_student.daomain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
//@TableName("user_teacher_login")
public class User implements Serializable {
    private String id;
    private String name;
    private String password;
}
