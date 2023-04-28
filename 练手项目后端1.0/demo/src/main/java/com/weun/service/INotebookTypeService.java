package com.weun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weun.entity.NotebookType;

import java.util.List;

public interface INotebookTypeService extends IService<NotebookType> {
    Boolean saveType(String notebookType,String username);
    Boolean removeByType(String notebookType,String username);
    List<String> showType(String username);
}
