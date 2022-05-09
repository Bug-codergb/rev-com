package com.codergb.service;

import com.codergb.bean.movie.Director;
import com.codergb.mapper.DirectorMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
  @Autowired
  DirectorMapper directorMapper;
  public int createDirector(Director director){
    return directorMapper.createDirector(director);
  }
  public Page<Director> getAllDirector(int page,int limit){
    Page<Director> p= PageHelper.startPage(page,limit);
    List<Director> directors=directorMapper.getAllDirect(page,limit);
    return p;
  }
}
