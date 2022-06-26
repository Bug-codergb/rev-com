package com.codergb.service.movie;

import com.codergb.bean.movie.FilmList;
import com.codergb.mapper.movie.FilmListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmListService {
  @Autowired
  FilmListMapper filmListMapper;
  //创建片单
  public int createFilmList(FilmList filmList){
    return filmListMapper.createFilmList(filmList);
  }
  //上传片单封面
  public int uploadCover(FilmList filmList){
    return filmListMapper.uploadCover(filmList);
  }
  //获取片单根据id
  public FilmList getFilmListById(String id){
    return filmListMapper.getFilmListById(id);
  }
}
