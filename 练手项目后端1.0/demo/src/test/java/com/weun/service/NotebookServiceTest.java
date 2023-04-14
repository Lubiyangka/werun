package com.weun.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weun.entity.NoteBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NotebookServiceTest {
    @Autowired
    private INotebookService iNotebookService;
    @Test
    void testSaveNotebookType(){
        iNotebookService.saveType("C");
    }
    @Test
    void testShowNotebookType(){
        iNotebookService.showType();
    }
    @Test
    void testSaveNotebook(){
        NoteBook noteBook=new NoteBook();
        noteBook.setNotebookType("C");
        noteBook.setNotebookTitle("C prime plus");
        noteBook.setNotebookState(1);
        noteBook.setNotebookContent("content test 0");
        noteBook.setNotebookDescription("description test 0");
        iNotebookService.save(noteBook);
    }
    @Test
    void testDelete(){
        iNotebookService.removeById("C prime plus");
    }
    @Test
    void testDeleteAll(){
        List<String> notebookType=new ArrayList<>();
        notebookType.add("C prime plus");
        notebookType.add("C++ prime");
        iNotebookService.removeByIds(notebookType);
    }


    @Test
    void testModifyState(){
        iNotebookService.modifyState("Java程序设计",0);
    }
    @Test
    void testModifyStateAll(){
        List<String> notebookTitle=new ArrayList<>();
        notebookTitle.add("Java程序设计");
        notebookTitle.add("title0");
        iNotebookService.modifyState(notebookTitle,0);
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
        iNotebookService.modifyAll("Java程序设计",noteBook);
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
    @Test
    void testSelectByTitle(){
        iNotebookService.selectByTitle("title0");
    }
    @Test
    void testShowNotebook(){
        iNotebookService.showNotebook("Java程序设计");
    }
}
