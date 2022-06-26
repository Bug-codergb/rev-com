package com.codergb.mapper.movie;

import com.codergb.bean.movie.FilmList;
import org.apache.ibatis.annotations.Param;

public interface FilmListMapper {
  //创建片单
  public int createFilmList(FilmList filmList);
  //上传片单封面
  public int uploadCover(FilmList filmList);
  //获取片单根据id
  public FilmList getFilmListById(@Param("id") String id);
}
