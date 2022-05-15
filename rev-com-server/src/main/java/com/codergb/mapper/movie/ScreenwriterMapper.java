package com.codergb.mapper.movie;

import com.codergb.bean.movie.Screenwriter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScreenwriterMapper {
  public int createScreenwriter(Screenwriter screenwriter);
  public List<Screenwriter> getAllScreenwriter(int page,int limit,@Param("keyword") String keyword);
}
