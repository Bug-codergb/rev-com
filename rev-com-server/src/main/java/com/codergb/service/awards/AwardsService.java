package com.codergb.service.awards;

import com.codergb.bean.Awards;
import com.codergb.mapper.awards.AwardsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardsService {
  @Autowired
  AwardsMapper awardsMapper;
  public int createAwards(Awards awards){
    return awardsMapper.createAwards(awards);
  }
}
