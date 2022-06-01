package com.codergb.utils;

import java.util.List;

public class Average {
  public Double getAverage(List<Double> nums){
    Double sum=0.0;
    for(Double item :nums){
      sum+=item;
    }
    return sum/nums.size();
  }
}
