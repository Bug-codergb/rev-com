package com.codergb.service.thumb;

import com.codergb.bean.Thumb;
import com.codergb.mapper.thumb.ThumbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThumbService {
  @Autowired
  ThumbMapper thumbMapper;
  public int thumb(String id,String key,String relateId,String userId){
    return thumbMapper.thumb(id,key,relateId,userId);
  }
  public List<Thumb> getUserThumb(String key, String relateId, String userId){
    return thumbMapper.getUserThumb(userId,key,relateId);
  }
  public int cancelThumb(String key,String relateId,String userId){
    return thumbMapper.cancelThumb(key,relateId,userId);
  }
}
