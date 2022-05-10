package com.codergb.service;

import com.codergb.bean.movie.Screenwriter;
import com.codergb.mapper.ScreenwriterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenwriterService {
  @Autowired
  ScreenwriterMapper screenwriterMapper;
  public int createScreenwriter(Screenwriter screenwriter){
    return screenwriterMapper.createScreenwriter(screenwriter);
  }
}
