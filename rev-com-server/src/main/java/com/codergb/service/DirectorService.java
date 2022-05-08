package com.codergb.service;

import com.codergb.bean.Director;
import com.codergb.mapper.DirectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
  @Autowired
  DirectorMapper directorMapper;
  public int createDirector(Director director){
    return directorMapper.createDirector(director);
  }
}
