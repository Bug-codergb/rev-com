package com.codergb.service;

import com.codergb.bean.Actor;
import com.codergb.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
  @Autowired
  ActorMapper actorMapper;
  public int createActor(Actor actor){
    return actorMapper.createActor(actor);
  }
}
