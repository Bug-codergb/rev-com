package com.codergb.mapper.subscriber;

import com.codergb.bean.Subscriber;
import com.codergb.dto.subscriber.SubDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubMapper {
  public int sub(@Param("id") String id,
                 @Param("key") String key,
                 @Param("relateId") String relateId,
                 @Param("userId") String userId);
  public List<Subscriber> getUserSub(@Param("userId") String userId,
                                     @Param("key") String key,
                                     @Param("relateId") String relateId);
  public int cancelSub(@Param("key") String key,
                         @Param("relateId") String id,
                         @Param("userId") String userId);
}
