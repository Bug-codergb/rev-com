package com.codergb.controller.rate;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Rate;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.rate.RateService;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class RateController {
  @Autowired
  RateService rateService;

  @LoginAuth
  @PostMapping("/movie/{id}")
  public ResponseType<Rate> getMovieRateById(@PathVariable("id") String id){
    Rate rate= rateService.getMovieRateById(id);
    return new ResponseType<Rate>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), rate);
  }
}
