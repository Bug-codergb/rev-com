package com.codergb.service;

import com.codergb.mapper.OccupationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupationService {
  @Autowired
  OccupationMapper occupationMapper;

  public int createOccupation(String id,String name){
    return occupationMapper.createOccupation(id,name);
  }

  public int setOccupation(String key,String id,String oId){
    return occupationMapper.setOccupation(key,id,oId);
  }
}
