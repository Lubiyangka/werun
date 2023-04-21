package com.werun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.werun.dao.NoteDao;
import com.werun.pojo.Note;
import com.werun.service.NoteService;
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
