package com.codergb.service.book;

import com.codergb.bean.book.Publish;
import com.codergb.mapper.book.PublishMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishService {
  @Autowired
  PublishMapper publishMapper;
  public int createPublish(Publish publish){
    return publishMapper.createPublish(publish);
  }
  public Page<Publish> getAllPublish(Integer page, Integer limit, String keyword){
    Page<Publish> p= PageHelper.startPage(page,limit);
    List<Publish> publishes=publishMapper.getAllPublish(page, limit, keyword);
    return p;
  }
}
