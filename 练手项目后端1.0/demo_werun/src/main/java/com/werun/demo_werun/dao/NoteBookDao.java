package com.werun.demo_werun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.werun.demo_werun.entity.NoteBook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteBookDao extends BaseMapper<NoteBook> {

}
