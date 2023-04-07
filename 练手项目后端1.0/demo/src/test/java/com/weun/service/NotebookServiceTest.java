package com.weun.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weun.entity.NoteBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotebookServiceTest {
    @Autowired
    private INotebookService iNotebookService;

    @Test
    void testModifyState(){
        iNotebookService.modifyState(1,1);
    }
    @Test
    void testModifyAll(){
        NoteBook noteBook=new NoteBook();
        noteBook.setId(1);
        noteBook.setNotebookType("java");
        noteBook.setNotebookTitle("title1");
        noteBook.setNotebookState(0);
        noteBook.setNotebookContent("content test");
        noteBook.setNotebookDescription("description test");
        iNotebookService.modifyState(1,1);
    }
    @Test
    void testSelectByTitle(){
        iNotebookService.selectByTitle("title1");
    }
    @Test
    void testShowType(){
        iNotebookService.showType();
    }
    @Test
    void testGetPage(){
        IPage<NoteBook> noteBookIpage=new Page<NoteBook>(1,5);
        iNotebookService.page(noteBookIpage);
        System.out.println (noteBookIpage.getCurrent());
        System.out.println (noteBookIpage.getSize());
        System.out.println (noteBookIpage.getTotal());
        System.out.println (noteBookIpage.getPages());
        System.out.println (noteBookIpage.getRecords());
    }
}
