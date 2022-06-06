package com.codergb.service.subscriber;

import com.codergb.bean.Subscriber;
import com.codergb.bean.Thumb;
import com.codergb.mapper.subscriber.SubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubService {
  @Autowired
  SubMapper subMapper;
  public int sub(String id,String key,String relateId,String userId){
    return subMapper.sub(id,key,relateId,userId);
  }
  public List<Subscriber> getUserSub(String key, String relateId, String userId){
    return subMapper.getUserSub(userId,key,relateId);
  }
  public int cancelSub(String key,String relateId,String userId){
    return subMapper.cancelSub(key,relateId,userId);
  }
}
