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
    @PostMapping("/save")
    public R save (@RequestBody NoteBook noteBook){
        return new R(iNotebookService.save(noteBook));
    }
    /*
     *1.2.3
     * 删除笔记
     */
    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable Integer id){
        return new R(iNotebookService.removeById(id));
    }
    /*
     *1.2.3.1
     * 批量删除笔记
     */
    @DeleteMapping("/deleteAll")
    public R deleteAll(@RequestParam(value = "id") List<Integer> id){
        return new R(iNotebookService.removeByIds(id));
    }
    /*
     *1.2.4.1
     * 修改笔记状态
     */
    @PutMapping("/modifyState/{id}/{state}")
    public R modifyState(@PathVariable Integer id,@PathVariable Integer state){
        return new R(iNotebookService.modifyState(id,state));
    }
    /*
     *1.2.4.2
     * 批量修改笔记状态
     */
    @PutMapping("/modifyState/{state}")
    public R modifyState(@RequestParam(value = "id") List<Integer> id,@PathVariable Integer state){
        return new R(iNotebookService.modifyState(id,state));
    }
    /*
     *1.2.4.3
     * 修改笔记（修改全部）
     */
    @PutMapping("/modifyAll/{id}")
    public R modifyAll(@PathVariable Integer id,@RequestBody NoteBook noteBook){
        return new R(iNotebookService.modifyAll(id,noteBook));
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

}
