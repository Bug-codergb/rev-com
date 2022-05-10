package com.codergb.mapper;

import com.codergb.bean.movie.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActorMapper {
  public int createActor(Actor actor);
  public List<Actor> getAllActor(int page, int limit, @Param("keyword") String keyword);
}
