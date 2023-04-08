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
    void testAddNotebook(){
        NoteBook noteBook=new NoteBook();
        noteBook.setNotebookType("java");
        noteBook.setNotebookTitle("Spring Data Jpa");
        noteBook.setNotebookState(1);
        noteBook.setNotebookContent("content test 0");
        noteBook.setNotebookDescription("description test 0");
        iNotebookService.save(noteBook);
    }

    @Test
    void testModifyState(){
        iNotebookService.modifyState(1,1);
    }
    @Test
    void testModifyAll(){
        NoteBook noteBook=new NoteBook();
        //noteBook.setId(1);
        noteBook.setNotebookType("java");
        noteBook.setNotebookTitle("Java程序设计");
        noteBook.setNotebookState(1);
        noteBook.setNotebookContent("content test changed");
        noteBook.setNotebookDescription("description test changed");
        iNotebookService.modifyAll(1,noteBook);
    }
    @Test
    void testSelectByTitle(){
        iNotebookService.selectByTitle("title0");
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
