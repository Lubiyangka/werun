package com.weun.controller;

import com.weun.entity.NoteBook;
import com.weun.service.INotebookService;
import com.weun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class NotebookController {
    @Autowired
    private INotebookService iNotebookService;
    //新增笔记
    @PostMapping("")
    public R save (NoteBook noteBook){
        return new R(iNotebookService.save(noteBook));
    }
    //删除笔记
    @DeleteMapping("")
    public R delete(Integer id){
        return new R(iNotebookService.removeById(id));
    }
    //批量删除笔记
    @DeleteMapping("")
    public R delete(List<Integer> id){
        return new R(iNotebookService.removeByIds(id));
    }
    //修改笔记状态
    @PutMapping("")
    public R modifyState(Integer id,Integer state){
        return new R(iNotebookService.modifyState(id,state));
    }
    //修改笔记（修改全部）
    @PutMapping("")
    public R modifyAll(Integer id,NoteBook noteBook){
        return new R(iNotebookService.modifyAll(id,noteBook));
    }
    //模糊查询，依据笔记标题
    @GetMapping("")
    public R getNotebookByTitle(String notebookTitle){
        return new R(true,iNotebookService.selectByTitle(notebookTitle));
    }
}
