package com.weun.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notebook")
public class NoteBook {
    private Integer id;
    private String notebookTitle;
    private String notebookType;
    private Integer notebookState;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String notebookCreatedTime;
    private String notebookContent;
    private String notebookDescription;
}
