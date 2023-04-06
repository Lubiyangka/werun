package com.weun.controller;

import com.weun.entity.NoteBook;
import com.weun.service.INotebookService;
import com.weun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 *1.前端
 *1.2.主页
 */
@RestController
@RequestMapping("")
public class NotebookController {
    @Autowired
    private INotebookService iNotebookService;

    /*
     *1.2.1.1
     * 新增笔记分类
     */
    @PostMapping("")
    public R saveNotebookType(String notebookType){
        return new R(iNotebookService.saveType(notebookType));
    }
    /*
     *1.2.1.2
     * 展示笔记分类
     */
    @GetMapping
    public R showNotebookType(){
        return new R(true,iNotebookService.showType());
    }
    /*
     *1.2.2
     * 新增笔记
     */
    @PostMapping("")
    public R save (NoteBook noteBook){
        return new R(iNotebookService.save(noteBook));
    }
    /*
     *1.2.3
     * 删除笔记
     */
    @DeleteMapping("")
    public R delete(Integer id){
        return new R(iNotebookService.removeById(id));
    }
    /*
     *1.2.3.1
     * 批量删除笔记
     */
    @DeleteMapping("")
    public R delete(List<Integer> id){
        return new R(iNotebookService.removeByIds(id));
    }
    /*
     *1.2.4.1
     * 修改笔记状态
     */
    @PutMapping("")
    public R modifyState(Integer id,Integer state){
        return new R(iNotebookService.modifyState(id,state));
    }
    /*
     *1.2.4.2
     * 修改笔记（修改全部）
     */
    @PutMapping("")
    public R modifyAll(Integer id,NoteBook noteBook){
        return new R(iNotebookService.modifyAll(id,noteBook));
    }
    /*
     *1.2.5
     * 查看笔记（展示分页）
     */
    @GetMapping("")
    public R getPage(int currentPage, int pageSize){
        return new R(true,iNotebookService.getPage(currentPage,pageSize));
    }
    /*
     *1.2.6
     * 模糊查询，依据笔记标题
     */
    @GetMapping("")
    public R getNotebookByTitle(String notebookTitle){
        return new R(true,iNotebookService.selectByTitle(notebookTitle));
    }
}
