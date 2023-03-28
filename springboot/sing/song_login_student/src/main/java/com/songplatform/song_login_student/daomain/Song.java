package com.songplatform.song_login_student.daomain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("song_student")
public class Song implements Serializable {

    private Integer id;
    private String songName;
    private String singer;
    private String platform;
    private Integer songVote;
    private String songTime;
    private Integer songDelete;
}
