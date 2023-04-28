package com.weun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weun.dao.NoteBookDao;
import com.weun.dao.NotebookTypeDao;
import com.weun.entity.NoteBook;
import com.weun.entity.NotebookType;
import com.weun.service.INotebookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookTypeServiceImpl extends ServiceImpl<NotebookTypeDao, NotebookType> implements INotebookTypeService {
    @Autowired
    private NotebookTypeDao notebookTypeDao;

    @Override
    public Boolean saveType(String notebookType,String username) {
        NotebookType oneType=new NotebookType(notebookType,username);
        return notebookTypeDao.insert(oneType)>0;
    }

    @Override
    public Boolean removeByType(String notebookType, String username) {
        QueryWrapper<NotebookType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(true,"notebook_type",notebookType).eq("username",username);
        return notebookTypeDao.delete(queryWrapper)>0;
    }

    @Override
    public List<String> showType(String username) {
        QueryWrapper<NotebookType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return notebookTypeDao.selectAllByNotebookTypeStrings(username);
    }
}
