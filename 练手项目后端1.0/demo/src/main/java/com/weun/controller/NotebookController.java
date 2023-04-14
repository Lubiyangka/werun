package com.weun.controller;

import com.weun.entity.NoteBook;
import com.weun.service.INotebookService;
import com.weun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *1.前端
 *1.2.主页
 */
@RestController
@RequestMapping("/notebooks")
public class NotebookController {
    @Autowired
    private INotebookService iNotebookService;

    /*
     *1.2.1.1
     * 新增笔记分类
     */
    @PostMapping("/saveType/{notebookType}")
    public R saveNotebookType(@PathVariable String notebookType){
        return new R(iNotebookService.saveType(notebookType));
    }
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
    @PostMapping("/saveNotebook")
    public R saveNotebook (@RequestBody NoteBook noteBook){
        return new R(iNotebookService.save(noteBook));
    }
    /*
     *1.2.3
     * 删除笔记
     */
    @DeleteMapping("/delete/{notebookTitle}")
    public R delete(@PathVariable String notebookTitle){
        return new R(iNotebookService.removeById(notebookTitle));
    }
    /*
     *1.2.3.1
     * 批量删除笔记
     */
    @DeleteMapping("/deleteAll")
    public R deleteAll(@RequestParam(value = "notebookTitle") List<String> notebookTitle){
        return new R(iNotebookService.removeByIds(notebookTitle));
    }
    /*
     *1.2.4.1
     * 修改笔记状态
     */
    @PutMapping("/modifyState/{notebookTitle}/{state}")
    public R modifyState(@PathVariable String notebookTitle,@PathVariable Integer state){
        return new R(iNotebookService.modifyState(notebookTitle,state));
    }
    /*
     *1.2.4.2
     * 批量修改笔记状态
     */
    @PutMapping("/modifyState/{state}")
    public R modifyState(@RequestParam(value = "id") List<String> notebookTitle,@PathVariable Integer state){
        return new R(iNotebookService.modifyState(notebookTitle,state));
    }
    /*
     *1.2.4.3
     * 修改笔记（修改全部）
     */
    @PutMapping("/modifyAll/{notebookTitle}")
    public R modifyAll(@PathVariable String notebookTitle,@RequestBody NoteBook noteBook){
        return new R(iNotebookService.modifyAll(notebookTitle,noteBook));
    }
    /*
     *1.2.5
     * 查看笔记（展示分页）
     */
    @GetMapping("/page/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        return new R(true,iNotebookService.getPage(currentPage,pageSize));
    }
    /*
     *1.2.6
     * 模糊查询，依据笔记标题
     */
    @GetMapping("/getNotebookByTitle/{notebookTitle}")
    public R getNotebookByTitle(@PathVariable String notebookTitle){
        return new R(true,iNotebookService.selectByTitle(notebookTitle));
    }
    /*
     *1.2.6
     * 修改笔记，返回笔记内容
     */
    @GetMapping("/getNotebook/{notebookTitle}")
    public R getNotebook(@PathVariable String notebookTitle){
        return new R(true,iNotebookService.showNotebook(notebookTitle));
    }

}
