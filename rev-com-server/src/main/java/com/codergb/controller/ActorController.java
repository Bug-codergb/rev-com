package com.codergb.controller;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.movie.Actor;
import com.codergb.constant.ResponseMessage;
import com.codergb.dto.movie.ActorDTO;
import com.codergb.service.ActorService;
import com.codergb.service.OccupationService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

  @Autowired
  ActorService actorService;
  @Autowired
  OccupationService occupationService;

  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createActor(@RequestBody ActorDTO actor){
    if(new EmptyJudge().judgeEmpty(actor.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getForeignName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员外文名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getConstellation())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员星座不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getBirth())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员生日不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员出生地不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getFamily())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员家庭成员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getOccupationList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员职业不能为空",null);
    }else{
      Long id=new Date().getTime();
      actor.setId(id.toString());
      actorService.createActor(actor);
      for(String item:actor.getOccupationList()){
        occupationService.setOccupation("aId",actor.getId(),item);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Actor>>> getAllActor(@RequestParam("page") Integer page,
                                              @RequestParam("limit") Integer limit,
                                              @RequestParam(value="keyword",required = false) String keyword ){
    if(keyword==null){
      keyword="";
    }
    Page<Actor> actors=actorService.getAllActor(page,limit,keyword);
    PageResult pageResult=new PageResult<List<Actor>>(actors.getPageNum(),
                                                      actors.getTotal(),
                                                      actors.getPages(),
                                                      actors);
    return new ResponseType<PageResult<List<Actor>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
}
