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
        iNotebookService.saveType("Java");
    }
    @Test
    void testShowNotebookType(){
        iNotebookService.showType();
    }
    @Test
    void testDelete(){
        iNotebookService.removeById(5);
    }
    @Test
    void testDeleteAll(){
        List<Integer> ids=new ArrayList<>();
        ids.add(6);
        ids.add(7);
        iNotebookService.removeByIds(ids);
    }
    @Test
    void testAddNotebook(){
        NoteBook noteBook=new NoteBook();
        noteBook.setNotebookType("C++");
        noteBook.setNotebookTitle("C++ prime");
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
    void testModifyStateAll(){
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(3);
        iNotebookService.modifyState(ids,0);
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
