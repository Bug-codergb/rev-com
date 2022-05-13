package com.codergb.mapper;

import com.codergb.bean.movie.Director;
import com.codergb.dto.movie.DirectorDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DirectorMapper {
  public int createDirector(Director director);
  public List<Director> getAllDirect(int page,int limit,@Param("keyword") String keyword);
  public int uploadAvatar(Director director);
  public Director getDirectorById(@Param("id") String id);
  public int updateDirector(DirectorDTO directorDTO);
}
