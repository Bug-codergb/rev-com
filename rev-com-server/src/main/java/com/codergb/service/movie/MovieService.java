package com.codergb.service.movie;

import com.codergb.bean.movie.*;
import com.codergb.dto.movie.MovieDTO;
import com.codergb.mapper.movie.MovieMapper;
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
  public int createMovie(MovieDTO movie){
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

  public Page<Movie> getAllMovie(Integer page,Integer limit,String form,String cateId,String keyword,String areaId){
    Page<Movie> p= PageHelper.startPage(page,limit);
    List<Movie> movies=movieMapper.getAllMovie(page,limit,form,cateId,keyword,areaId);
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
  //删除电影导演
  public int deleteMovieDirector(String id){
    return movieMapper.deleteMovieDirector(id);
  }
  //删除电影编剧
  public int deleteMovieScreen(String id){
    return movieMapper.deleteMovieScreen(id);
  }
  //删除电影地区
  public int deleteMovieArea(String id){
    return movieMapper.deleteMovieArea(id);
  }
  //删除电影演员
  public int deleteMovieActor(String id){
    return movieMapper.deleteMovieActor(id);
  }
  //删除电影分类
  public int deleteMovieCate(String id){
    return movieMapper.deleteMovieCate(id);
  }
  //更新电影信息
  public int updateMovie(Movie movie){
    return movieMapper.updateMovie(movie);
  }
}
