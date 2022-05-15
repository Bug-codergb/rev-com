package com.codergb.mapper.movie;

import com.codergb.bean.movie.Actor;
import com.codergb.dto.movie.ActorDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActorMapper {
  public int createActor(Actor actor);
  public List<Actor> getAllActor(int page, int limit, @Param("keyword") String keyword);
  public int updateActor(ActorDTO actorDTO);
  public int deleteActor(@Param("id") String id);
}
