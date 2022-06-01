package com.codergb.mapper.rate;

import com.codergb.bean.Rate;
import org.apache.ibatis.annotations.Param;

public interface RateMapper {
  //获取电影评分信息根据电影id
  public Rate getMovieRateById(@Param("id") String id);
}
