package com.hope.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hope.pojo.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService extends IService<Note> {
    List<String> selectType(String username);
    Boolean addNote(Note note);
}
