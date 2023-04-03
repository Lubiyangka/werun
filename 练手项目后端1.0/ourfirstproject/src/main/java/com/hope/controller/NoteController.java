package com.hope.controller;

import com.hope.pojo.Account;
import com.hope.pojo.Note;
import com.hope.pojo.R;
import com.hope.service.impl.NoteServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    @Autowired
    NoteServiceImpl noteService;

    //添加分类，添加笔记功能应该可以重复利用这个请求，本质上分类的note_title是null 后面添加的笔记note_title字段不为null
    @PostMapping("/home/addtype")
    public R addNoteType(@RequestBody Note note){
        R r =new R();
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        note.setUsername(account.getUsername());
        r.setFlag(noteService.addNote(note));
        return r;
    }

    //展示左侧自定义分类
    @PostMapping("/home")
    public R showNoteType(){
        R r =new R();
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        r.setData(noteService.selectType(account.getUsername()));
        return r;
    }
}
