package com.codergb.mapper.awards;

import com.codergb.bean.Awards;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AwardsMapper {
  public int createAwards(Awards awards);
  public List<Awards> getAllAwards(@Param("page") Integer page,
                                   @Param("limit") Integer limit,
                                   @Param("keyword") String keyword);
  public int updateAwards(Awards awards);
  //上传奖项封面
  public int uploadCover(Awards awards);
  //获取awards
  public Awards getAwardsById(@Param("id") String id);
}
