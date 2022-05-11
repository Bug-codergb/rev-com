package com.codergb.service;

import com.codergb.bean.movie.*;
import com.codergb.mapper.MovieMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
  public int createMovie(Movie movie){
    return movieMapper.createMovie(movie);
  }
  public int setDirectorForMovie(String mId,String dId){
    return movieMapper.setDirectorForMovie(mId,dId);
  }
  public int setAreaForMovie(String mId,String aId){
    return movieMapper.setAreaForMovie(mId,aId);
  }
  public int setScreenwriterForMovie(String mId,String sId){
    return movieMapper.setScreenwriterForMovie(mId,sId);
  }
  public int setActorForMovie(String mId,String aId){
    return movieMapper.setActorForMovie(mId,aId);
  }
  public int setCateForMovie(String mId,String cId){
    return movieMapper.setCateForMovie(mId,cId);
  }

  public Page<Movie> getAllMovie(Integer page,Integer limit){
    Page<Movie> p= PageHelper.startPage(page,limit);
    List<Movie> movies=movieMapper.getAllMovie(page,limit);
    return p;
  }
  //获取所有地区
  public List<Area> getAllArea(){
    return movieMapper.getAllArea();
  }
  //获取所有类型
  public List<Category> getAllCate(){
    return movieMapper.getAllCate();
  }
  //获取所有形式
  public List<Form> getAllForm(){
    return movieMapper.getAllForm();
  }
}
