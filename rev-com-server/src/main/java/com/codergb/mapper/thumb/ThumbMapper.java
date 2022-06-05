package com.codergb.mapper.thumb;

import com.codergb.bean.Thumb;
import com.codergb.dto.thumb.ThumbDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThumbMapper {
  public int thumb(@Param("id") String id,
                   @Param("key") String key,
                   @Param("relateId") String relateId,
                   @Param("userId") String userId);
  public List<Thumb> getUserThumb(@Param("userId") String userId,
                                  @Param("key") String key,
                                  @Param("relateId") String relateId);
  public int cancelThumb(@Param("key") String key,
                         @Param("relateId") String id,
                         @Param("userId") String userId);
}
