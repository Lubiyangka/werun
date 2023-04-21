package com.weun.controller;

import com.weun.entity.NoteBook;
import com.weun.entity.User;
import com.weun.service.INotebookService;
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

    /*
     *1.2.1.1
     * 新增笔记分类
     */
    @PostMapping("/saveType/{notebookType}")
    public R saveNotebookType(@PathVariable String notebookType,@RequestParam String username){
        return new R(iNotebookService.saveType(notebookType,username));
        //user.getUserId()
    }
    /*
     *1.2.1.2
     * 展示笔记分类
     */
    @GetMapping("/showType")
    public R showNotebookType(@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(true,iNotebookService.showType(username),"展示笔记分类成功");
    }
    /*
     *1.2.2
     * 新增笔记
     */
    @PostMapping("/saveNotebook")
    public R saveNotebook (@RequestBody NoteBook noteBook){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
//        noteBook.setUsername(username);
        return new R(iNotebookService.save(noteBook));
    }
    /*
     *1.2.3
     * 删除笔记
     */
    @DeleteMapping("/delete/{notebookTitle}")
    public R delete(@PathVariable String notebookTitle,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(iNotebookService.removeById(notebookTitle,username));
    }
    /*
     *1.2.3.1
     * 批量删除笔记
     */
    @DeleteMapping("/deleteAll")
    public R deleteAll(@RequestParam(value = "notebookTitle") List<String> notebookTitle,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(iNotebookService.removeByIds(notebookTitle,username));
    }
    /*
     *1.2.4.1
     * 修改笔记状态
     */
    @PutMapping("/modifyState/{notebookTitle}/{state}")
    public R modifyState(@PathVariable String notebookTitle
                        ,@PathVariable(value = "state",required = false) Integer state
                        ,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(iNotebookService.modifyState(notebookTitle,state,username));
    }
    /*
     *1.2.4.2
     * 批量修改笔记状态
     */
    @PutMapping("/modifyStateAll/{state}")
    public R modifyStateBatch(@RequestParam(value = "id") List<String> notebookTitle,@PathVariable Integer state,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(iNotebookService.modifyState(notebookTitle,state,username));
    }
    /*
     *1.2.4.3
     * 修改笔记（修改全部）
     */
    @PutMapping("/modifyAll/{notebookTitle}")
    public R modifyAll(@PathVariable String notebookTitle,@RequestBody NoteBook noteBook,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(iNotebookService.modifyAll(notebookTitle,noteBook,username));
    }
    /*
     *1.2.5
     * 查看笔记（展示分页）
     */
    @GetMapping("/page/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(true,iNotebookService.getPage(currentPage,pageSize,username),"分页成功");
    }
    /*
     *1.2.6
     * 模糊查询，依据笔记标题
     */
    @GetMapping("/getNotebookByTitle/{notebookTitle}")
    public R getNotebookByTitle(@PathVariable String notebookTitle,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(true,iNotebookService.selectByTitle(notebookTitle,username),"模糊查询");
    }
    /*
     *1.2.6
     * 修改笔记，返回笔记内容
     */
    @GetMapping("/getNotebook/{notebookTitle}")
    public R getNotebook(@PathVariable String notebookTitle,@RequestParam String username){
//        Subject subject= SecurityUtils.getSubject();
//        User user=(User) subject.getPrincipal();
        return new R(true,iNotebookService.showNotebook(notebookTitle,username),"修改笔记");
    }

}
