package com.codergb.controller;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.occupation.Occupation;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.OccupationService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/occupation")
public class OccupationController {

  @Autowired
  OccupationService occupationService;

  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createOccupation(@RequestBody Occupation occupation){
    if(new EmptyJudge().judgeEmpty(occupation) || new EmptyJudge().judgeEmpty(occupation.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "职业名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      occupationService.createOccupation(id.toString(),occupation.getName());
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(),null);
    }
  }
  @LoginAuth
  @PostMapping("/{key}/{id}/{oId}")
  public ResponseType<Object> setOccupation(@PathVariable("key") String key,
                                            @PathVariable("id") String id,
                                            @PathVariable("oId") String oId){
    if(new EmptyJudge().judgeEmpty(key) || new EmptyJudge().judgeEmpty(id) || new EmptyJudge().judgeEmpty(oId)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "参数错误",null);
    }else{
      occupationService.setOccupation(key,id,oId);
      return new ResponseType<Object>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
}
