package com.weun.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Data
@NoArgsConstructor
@TableName("notebook_type")
public class NotebookType implements Serializable {
    @TableId
    private Integer id;
    private String NotebookType;
    private String username;
    public NotebookType(String notebookType){
        if(notebookType != null){
            this.NotebookType=notebookType;
        }
    }
    public NotebookType(String notebookType,String username){
        if(notebookType != null&&username!=null){
            this.NotebookType=notebookType;
            this.username=username;
        }
    }
    public NotebookType (NotebookType notebookType,String username){
        Optional.ofNullable(notebookType).ifPresent(e->{
            this.id=e.getId();
            this.NotebookType=e.getNotebookType();
            this.username=username;
        });
    }

}
