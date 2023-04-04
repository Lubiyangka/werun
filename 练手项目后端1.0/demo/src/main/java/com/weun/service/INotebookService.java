package com.weun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weun.entity.NoteBook;

import java.util.List;

public interface INotebookService extends IService<NoteBook> {
    Boolean modifyState(Integer id,Integer state);
    Boolean modifyAll(Integer id,NoteBook noteBook);
    List<NoteBook> selectByTitle(String notebookTitle);
}
