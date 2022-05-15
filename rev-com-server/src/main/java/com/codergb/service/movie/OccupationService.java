package com.codergb.service.movie;

import com.codergb.bean.occupation.Occupation;
import com.codergb.mapper.movie.OccupationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
  public List<Occupation> getAllOccupation(){
    return occupationMapper.getAllOccupation();
  }
  public int deleteOccupationForRole(String key,String id){
    return occupationMapper.deleteOccupationForRole(key,id);
  }
}
