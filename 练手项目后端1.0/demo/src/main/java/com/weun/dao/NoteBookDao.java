package com.weun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weun.entity.NoteBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteBookDao extends BaseMapper<NoteBook> {
//    //用来显示左侧分类
//    @Select("SELECT note_type FROM note WHERE username = #{username} and note_title is null")
//    List<String> selectType(@Param("username")String username);

    //还需要写笔记的增删改查
}
