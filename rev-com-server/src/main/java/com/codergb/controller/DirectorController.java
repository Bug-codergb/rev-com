package com.codergb.controller;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Director;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.DirectorService;
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
@RequestMapping("/director")
public class DirectorController {

  @Autowired
  DirectorService directorService;

  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createDirector(@RequestBody Director director){
    if(new EmptyJudge().judgeEmpty(director.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"导演名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(director.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "导演别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(director.getGender())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "性别不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(director.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"出生地不能为空",null );
    }else if(new EmptyJudge().judgeEmpty(director.getProfession())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"职业不能为空",null );
    }else if(new EmptyJudge().judgeEmpty(director.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"导演简介不能为空",null );
    }else{
      Long id=new Date().getTime();
      director.setId(id.toString());
      directorService.createDirector(director);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
}
