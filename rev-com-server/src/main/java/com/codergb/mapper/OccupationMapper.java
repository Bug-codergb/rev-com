package com.codergb.mapper;

import com.codergb.bean.occupation.Occupation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OccupationMapper {
  public int createOccupation(@Param("id") String id,@Param("name") String name);
  //为导演，演员，编剧添加职业
  public int setOccupation(@Param("key") String key, @Param("id") String id,@Param("oId") String oId);
  //获取所有职业 为导演，演员
  public List<Occupation> getOccupationById(@Param("key") String key,@Param("id") String id);
}
