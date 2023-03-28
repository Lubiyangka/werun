package com.songplatform.song_login_student.daomain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user_student_login")
public class Student extends User implements Serializable {
    private String classNumber;
}
