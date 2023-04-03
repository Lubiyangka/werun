package com.weun.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("")
public class NoteBook {
    private Integer id;
    private String notebookTitle;
    private String notebookType;
    private String notebookState;
    private String notebookCreatedTime;
    private String notebookContent;
    private String notebookDescription;
}
