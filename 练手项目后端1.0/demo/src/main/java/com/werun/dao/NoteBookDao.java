package com.werun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.werun.entity.NoteBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteBookDao extends BaseMapper<NoteBook> {
//    //还需要完善
//    int updateNotebookType();
    @Select("SELECT notebook_type FROM notebook")
    List<String> selectAllByNotebookTypeStrings();
}
