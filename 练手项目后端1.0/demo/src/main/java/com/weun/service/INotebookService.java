package com.weun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weun.entity.NoteBook;

import java.util.List;

public interface INotebookService extends IService<NoteBook> {
    Boolean modifyState(String notebookTitle,Integer state);
    Boolean modifyState(List<String> notebookTitle,Integer state);
    Boolean modifyAll(String notebookTitle,NoteBook noteBook);
    Boolean saveType(String notebookType);
    List<NoteBook> selectByTitle(String notebookTitle);
    List<String> showType();
    IPage<NoteBook> getPage(int currentPage,int pageSize);
    NoteBook showNotebook(String notebookType);
}
