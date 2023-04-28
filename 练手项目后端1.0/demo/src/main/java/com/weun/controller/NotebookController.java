package com.weun.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weun.entity.NoteBook;
import com.weun.entity.NotebookType;
import com.weun.service.INotebookService;
import com.weun.service.INotebookTypeService;
import com.weun.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

    @Autowired
    private INotebookTypeService iNotebookTypeService;

    /*
     *1.2.1.1
     * 新增笔记分类
     */
    @PostMapping("/saveType")
    public R saveNotebookType(@RequestParam String notebookType){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        QueryWrapper<NotebookType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("notebook_type",notebookType);
        if(iNotebookTypeService.getOne(queryWrapper)==null){
            return new R(iNotebookTypeService.saveType(notebookType,username),"新增笔记成功");
        }
        else {
            return new R(false,"该笔记分类已存在");
        }
    }
    /*
     *1.2.1.2
     * 展示笔记分类
     */
    @GetMapping("/showType")
    public R showNotebookType(){
        Subject subject= SecurityUtils.getSubject();
        String username=subject.getPrincipal().toString();
        return new R(true,iNotebookTypeService.showType(username),"展示笔记分类成功");
    }
    /*
     * 1.2.1.3
     * 删除笔记分类
     */
    @DeleteMapping("/deleteType")
    public R deleteNotebookType(@RequestParam String notebookType){
        Subject subject=SecurityUtils.getSubject();
        String username=subject.getPrincipal().toString();
        return new R(iNotebookTypeService.removeByType(notebookType,username));
    }
    /*
     *1.2.2
     * 新增笔记
     */
    @PostMapping("/saveNotebook")
    public R saveNotebook (@RequestBody NoteBook noteBook){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        noteBook.setUsername(username);
        QueryWrapper<NoteBook> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("notebook_title",noteBook.getNotebookTitle()).eq("username",noteBook.getUsername());
        if(iNotebookService.getOne(queryWrapper)==null){
            return new R(iNotebookService.save(noteBook));
        }
        else {
            return new R(false,"该笔记已存在");
        }
    }
    /*
     *1.2.3
     * 删除笔记
     */
    @DeleteMapping("/delete")
    public R delete(@RequestParam String notebookTitle){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(iNotebookService.removeById(notebookTitle,username));
    }
    /*
     *1.2.3.1
     * 批量删除笔记
     */
    @DeleteMapping("/deleteAll")
    public R deleteAll(@RequestParam(value = "notebookTitle") List<String> notebookTitle){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(iNotebookService.removeByIds(notebookTitle,username));
    }
    /*
     *1.2.4.1
     * 修改笔记状态
     */
    @PutMapping("/modifyState")
    public R modifyState(@RequestParam String notebookTitle,@RequestParam Integer state){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(iNotebookService.modifyState(notebookTitle,state,username));
    }
    /*
     *1.2.4.2
     * 批量修改笔记状态
     */
    @PutMapping("/modifyStateAll")
    public R modifyStateBatch(@RequestParam List<String> notebookTitle,@RequestParam Integer state){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(iNotebookService.modifyState(notebookTitle,state,username));
    }
    /*
     *1.2.4.3
     * 修改笔记（修改全部）
     */
    @PutMapping("/modifyAll")
    public R modifyAll(@RequestParam String notebookTitle,@RequestBody NoteBook noteBook){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(iNotebookService.modifyAll(notebookTitle,noteBook,username));
    }
    /*
     *1.2.5
     * 查看笔记（展示分页）
     */
    @GetMapping("/page/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(true,iNotebookService.getPage(currentPage,pageSize,username),"分页成功");
    }
    /*
     *1.2.6
     * 模糊查询，依据笔记标题
     */
    @GetMapping("/getNotebookByTitle")
    public R getNotebookByTitle(@RequestParam String notebookTitle,@RequestParam int currentPage,@RequestParam int pageSize){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(true,iNotebookService.selectByTitle(currentPage,pageSize,notebookTitle,username),"模糊查询");
    }
    /*
     *1.2.6
     * 修改笔记，返回笔记内容
     */
    @GetMapping("/getNotebook")
    public R getNotebook(@RequestParam String notebookTitle){
        Subject subject= SecurityUtils.getSubject();
        String username= subject.getPrincipal().toString();
        return new R(true,iNotebookService.showNotebook(notebookTitle,username),"修改笔记");
    }

}
