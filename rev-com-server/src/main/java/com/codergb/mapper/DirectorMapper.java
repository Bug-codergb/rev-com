package com.codergb.mapper;

import com.codergb.bean.movie.Director;

import java.util.List;

public interface DirectorMapper {
  public int createDirector(Director director);
  public List<Director> getAllDirect(int page,int limit);
}
