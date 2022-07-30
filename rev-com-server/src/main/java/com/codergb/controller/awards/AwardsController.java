package com.codergb.controller.awards;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Awards;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.awards.AwardsService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/awards")
public class AwardsController {
  @Autowired
  AwardsService awardsService;
  //创建奖项
  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> createAwards(@RequestBody Awards awards){
    if(new EmptyJudge().judgeEmpty(awards.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getArea())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项地区不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getEstablished())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项成立时间不能为空",null);
    }else{
      Long id=new Date().getTime();
      awards.setId(id.toString());
      awardsService.createAwards(awards);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), awards);
    }
  }
}
