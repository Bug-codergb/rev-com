package com.codergb.service.movie;

import com.codergb.bean.movie.Screenwriter;
import com.codergb.mapper.movie.ScreenwriterMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenwriterService {
  @Autowired
  ScreenwriterMapper screenwriterMapper;
  public int createScreenwriter(Screenwriter screenwriter){
    return screenwriterMapper.createScreenwriter(screenwriter);
  }
  public Page<Screenwriter> getAllScreenwriter(Integer page,Integer limit,String keyword){
    Page<Screenwriter> p= PageHelper.startPage(page,limit);
    List<Screenwriter> screenwriters=screenwriterMapper.getAllScreenwriter(page,limit,keyword);
    return p;
  }
}
