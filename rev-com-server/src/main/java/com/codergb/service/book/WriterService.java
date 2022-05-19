package com.codergb.service.book;

import com.codergb.bean.book.Writer;
import com.codergb.mapper.book.WriterMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService {
  @Autowired
  WriterMapper writerMapper;
  public int createWriter(Writer writer){
    return writerMapper.createWriter(writer);
  }
  public Page<Writer> getAllWriter(Integer page,Integer limit,String keyword){
    Page<Writer> p= PageHelper.startPage(page,limit);
    List<Writer> writers=writerMapper.getAllWriter(page,limit,keyword);
    return p;
  }
}
