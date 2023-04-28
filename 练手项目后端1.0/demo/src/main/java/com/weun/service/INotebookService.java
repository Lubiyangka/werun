package com.weun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weun.entity.NoteBook;

import java.util.List;

public interface INotebookService extends IService<NoteBook> {
    //Boolean removeByType(String notebookType,String username);

    Boolean removeById(String notebookTitle,String username);
    Boolean removeByIds(List<String> notebookTitle,String username);
    Boolean modifyState(String notebookTitle,Integer state,String username);
    Boolean modifyState(List<String> notebookTitle,Integer state,String username);
    Boolean modifyAll(String notebookTitle,NoteBook noteBook,String username);
    //Boolean saveType(String notebookType,String username);
    IPage<NoteBook> selectByTitle(int currentPage, int pageSize,String notebookTitle,String username);
    //List<String> showType(String username);
    IPage<NoteBook> getPage(int currentPage,int pageSize,String username);
    NoteBook showNotebook(String notebookType,String username);
}
