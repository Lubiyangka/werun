package com.werun.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("notebook")
public class NoteBook {
    private Integer id;
    private String notebookTitle;
    private String notebookType;
    private Integer notebookState;
    @TableField(fill = FieldFill.INSERT)
    private Date notebookCreatedTime;
    private String notebookContent;
    private String notebookDescription;
}
