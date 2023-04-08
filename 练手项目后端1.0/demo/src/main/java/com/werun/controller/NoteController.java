package com.werun.controller;

import com.werun.entity.NoteBook;
import com.werun.service.INotebookService;
import com.werun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *1.前端
 *1.2.主页
 */
@RestController
@RequestMapping("/notebooks")
public class NoteController {
    @Autowired
    private INotebookService iNotebookService;

    /*
     *1.2.1.1
     * 新增笔记分类
     */
//    @PostMapping("/saveType")
//    public R saveNotebookType(String notebookType){
//        return new R(iNotebookService.saveType(notebookType));
//    }
    /*
     *1.2.1.2
     * 展示笔记分类
     */
    @GetMapping("/showType")
    public R showNotebookType(){
        return new R(true,iNotebookService.showType());
    }
    /*
     *1.2.2
     * 新增笔记
     */
    @PostMapping("save")
    public R save (NoteBook noteBook){
        return new R(iNotebookService.save(noteBook));
    }
    /*
     *1.2.3
     * 删除笔记
     */
    @DeleteMapping("delete")
    public R delete(Integer id){
        return new R(iNotebookService.removeById(id));
    }
    /*
     *1.2.3.1
     * 批量删除笔记
     */
    @DeleteMapping("deleteAll")
    public R deleteAll(List<Integer> id){
        return new R(iNotebookService.removeByIds(id));
    }
    /*
     *1.2.4.1
     * 修改笔记状态
     */
    @PutMapping("modifyState")
    public R modifyState(Integer id,Integer state){
        return new R(iNotebookService.modifyState(id,state));
    }
    /*
     *1.2.4.2
     * 修改笔记（修改全部）
     */
    @PutMapping("modifyAll")
    public R modifyAll(Integer id,NoteBook noteBook){
        return new R(iNotebookService.modifyAll(id,noteBook));
    }
    /*
     *1.2.5
     * 查看笔记（展示分页）
     */
    @GetMapping("page")
    public R getPage(int currentPage, int pageSize){
        return new R(true,iNotebookService.getPage(currentPage,pageSize));
    }
    /*
     *1.2.6
     * 模糊查询，依据笔记标题
     */
    @GetMapping("getNotebookByTitle")
    public R getNotebookByTitle(String notebookTitle){
        return new R(true,iNotebookService.selectByTitle(notebookTitle));
    }
}
