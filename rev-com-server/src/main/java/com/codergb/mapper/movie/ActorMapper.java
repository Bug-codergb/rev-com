package com.codergb.mapper.movie;

import com.codergb.bean.movie.Actor;
import com.codergb.dto.movie.ActorDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActorMapper {
  public int createActor(Actor actor);
  public List<Actor> getAllActor(int page, int limit, @Param("keyword") String keyword,@Param("c") String c);
  public int updateActor(ActorDTO actorDTO);
  public int deleteActor(@Param("id") String id);
  //上传用户头像
  public int uploadAvatar(Actor actor);
  public Actor getActorById(@Param("id") String id);
  //获取导演合作演员
  public List<Actor> getDirectorActor(@Param("dId") String dId,@Param("page") Integer page,@Param("limit") Integer limit);
  //获取演员合作的演员
  public List<Actor> getActorCooperate(@Param("aId") String aId,@Param("page") Integer page,@Param("limit") Integer limit);
}
