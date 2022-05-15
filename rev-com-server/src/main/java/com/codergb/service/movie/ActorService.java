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
}
