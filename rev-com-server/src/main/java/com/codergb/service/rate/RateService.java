package com.codergb.service.rate;

import com.codergb.bean.Rate;
import com.codergb.mapper.rate.RateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateService {
  @Autowired
  RateMapper rateMapper;
  public Rate getMovieRateById(String id){
    return rateMapper.getMovieRateById(id);
  }
}
