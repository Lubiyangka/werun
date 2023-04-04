package com.weun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weun.dao.NoteBookDao;
import com.weun.entity.NoteBook;
import com.weun.service.INotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookServiceImpl extends ServiceImpl<NoteBookDao, NoteBook> implements INotebookService {

    @Autowired
    private NoteBookDao noteBookDao;

    @Override
    public Boolean modifyState(Integer id,Integer state) {
        UpdateWrapper<NoteBook> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id).set("note_state",state);
        return noteBookDao.update(null,updateWrapper)>0;
    }

    @Override
    public Boolean modifyAll(Integer id,NoteBook noteBook) {
        UpdateWrapper<NoteBook> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id).setEntity(noteBook);
        return noteBookDao.update(null,updateWrapper)>0;
    }

    @Override
    public List<NoteBook> selectByTitle(String notebookTitle) {
        QueryWrapper<NoteBook> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("notebook_title",notebookTitle);
        return noteBookDao.selectList(queryWrapper);
    }
}
