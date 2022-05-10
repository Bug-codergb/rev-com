package com.codergb.service;

import com.codergb.bean.movie.Area;
import com.codergb.bean.movie.Category;
import com.codergb.bean.movie.Form;
import com.codergb.bean.movie.Tag;
import com.codergb.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
  @Autowired
  MovieMapper movieMapper;
  public int createForm(Form form){
    return movieMapper.createForm(form);
  }
  public int createArea(Area area){
    return movieMapper.createArea(area);
  }
  public int createCate(Category category){
    return movieMapper.createCate(category);
  }
  public int createTag(Tag tag){
    return movieMapper.createTag(tag);
  }
}
