package com.weun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weun.dao.NoteBookDao;
import com.weun.dao.NotebookTypeDao;
import com.weun.entity.NoteBook;
import com.weun.entity.NotebookType;
import com.weun.entity.User;
import com.weun.service.INotebookService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookServiceImpl extends ServiceImpl<NoteBookDao, NoteBook> implements INotebookService {

    @Autowired
    private NoteBookDao noteBookDao;
//    @Autowired
//    private NotebookTypeDao notebookTypeDao;


//    @Override
//    public Boolean removeByType(String notebookType, String username) {
//        QueryWrapper<NotebookType> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq(true,"notebook_type",notebookType).eq("username",username);
//        return notebookTypeDao.delete(queryWrapper)>0;
//    }

    @Override
    public Boolean removeById(String notebookTitle, String username) {
        QueryWrapper<NoteBook> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("notebook_title",notebookTitle).eq("username",username);
        return noteBookDao.delete(queryWrapper)>0;
    }

    @Override
    public Boolean removeByIds(List<String> notebookTitles, String username) {
        for (String notebookTitle:notebookTitles){
            QueryWrapper<NoteBook> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("notebook_title",notebookTitle).eq("username",username);
            noteBookDao.delete(queryWrapper);
        }
        return true;
    }

    @Override
    public Boolean modifyState(String notebookTitle,Integer state,String username) {
        UpdateWrapper<NoteBook> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("notebook_title",notebookTitle).eq("username",username);
        updateWrapper.set("notebook_state",state);
        return noteBookDao.update(null,updateWrapper)>0;
    }

    @Override
    public Boolean modifyState(List<String> notebookTitles, Integer state,String username) {
        for (String notebookTitle:notebookTitles) {
            UpdateWrapper<NoteBook> updateWrapper=new UpdateWrapper<>();
            updateWrapper.eq("notebook_title",notebookTitle).eq("username",username);
            updateWrapper.set("notebook_state",state);
            noteBookDao.update(null,updateWrapper);
        }
        return true;
    }

    @Override
    public Boolean modifyAll(String notebook_title,NoteBook noteBook,String username) {
        UpdateWrapper<NoteBook> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("notebook_title",notebook_title).eq("username",username)
                .set("notebook_state",noteBook.getNotebookState())
                .set("notebook_title",noteBook.getNotebookTitle())
                .set("notebook_type",noteBook.getNotebookType())
                .set("notebook_content",noteBook.getNotebookContent())
                .set("notebook_description",noteBook.getNotebookDescription());
        return noteBookDao.update(null,updateWrapper)>0;

    }

//    @Override
//    public Boolean saveType(String notebookType,String username) {
//        NotebookType oneType=new NotebookType(notebookType,username);
//        return notebookTypeDao.insert(oneType)>0;
//    }

    @Override
    public IPage<NoteBook> selectByTitle(int currentPage, int pageSize,String notebookTitle,String username) {
        QueryWrapper<NoteBook> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username).like("notebook_title",notebookTitle);
        return noteBookDao.selectPage(new Page(currentPage,pageSize),queryWrapper);
    }

//    @Override
//    public List<String> showType(String username) {
//        QueryWrapper<NotebookType> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("username",username);
//        return notebookTypeDao.selectAllByNotebookTypeStrings(username);
//    }

    @Override
    public IPage<NoteBook> getPage(int currentPage, int pageSize,String username) {
        QueryWrapper<NoteBook> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return noteBookDao.selectPage(new Page(currentPage,pageSize),queryWrapper);
    }

    @Override
    public NoteBook showNotebook(String notebookType,String username) {
        QueryWrapper<NoteBook> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("notebook_title",notebookType).eq("username",username);
        return noteBookDao.selectOne(queryWrapper);
    }
}
