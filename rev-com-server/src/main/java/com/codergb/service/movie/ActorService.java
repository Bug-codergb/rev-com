package com.codergb.service.movie;

import com.codergb.bean.movie.Actor;
import com.codergb.dto.movie.ActorDTO;
import com.codergb.mapper.movie.ActorMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
  @Autowired
  ActorMapper actorMapper;
  public int createActor(Actor actor){
    return actorMapper.createActor(actor);
  }
  public Page<Actor> getAllActor(Integer page,Integer limit,String keyword){
    Page<Actor> p= PageHelper.startPage(page,limit);
    List<Actor> actors=actorMapper.getAllActor(page,limit,keyword);
    return p;
  }
  public int updateActor(ActorDTO actorDTO){
    return actorMapper.updateActor(actorDTO);
  }
  public int deleteActor(String id){
    return actorMapper.deleteActor(id);
  }
  public int uploadAvatar(Actor actor){
    return actorMapper.uploadAvatar(actor);
  }
  public Actor getActorById(String id){
    return actorMapper.getActorById(id);
  }
  public Page<Actor> getDirectorActor(String id,Integer page,Integer limit){
    Page<Actor> p=PageHelper.startPage(page,limit);
    List<Actor> actors=actorMapper.getDirectorActor(id,page,limit);
    return p;
  }
  //获取演员合作演员
  public Page<Actor> getActorCooperate(String id,Integer page,Integer limit){
    Page<Actor> p=PageHelper.startPage(page,limit);
    List<Actor> actors=actorMapper.getActorCooperate(id,page,limit);
    return p;
  }
}
