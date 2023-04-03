package com.hope.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hope.dao.AccountDao;
import com.hope.dao.NoteDao;
import com.hope.pojo.Account;
import com.hope.pojo.Note;
import com.hope.service.AccountService;
import com.hope.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl extends ServiceImpl<NoteDao, Note> implements NoteService {
    @Autowired
    NoteDao noteDao;


    @Override
    public List<String> selectType(String username) {
        return noteDao.selectType(username);

    }

    @Override
    public Boolean addNote(Note note) {
        return noteDao.insert(note)==1;
    }
}
