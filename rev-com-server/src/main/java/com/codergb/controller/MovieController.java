package com.codergb.controller;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.movie.*;
import com.codergb.constant.ResponseMessage;
import com.codergb.dto.movie.MovieDTO;
import com.codergb.service.MovieService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/movie")
public class MovieController {
  @Autowired
  MovieService movieService;

  @LoginAuth
  @PostMapping("/form")
  public ResponseType<Object> createForm(@RequestBody Form form){
    if(new EmptyJudge().judgeEmpty(form.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视形式名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      form.setId(id.toString());
      movieService.createForm(form);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/area")
  public ResponseType<Object> createArea(@RequestBody Area area){
    if(new EmptyJudge().judgeEmpty(area.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视地区名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      area.setId(id.toString());
      movieService.createArea(area);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/cate")
  public ResponseType<Object> createArea(@RequestBody Category cate){
    if(new EmptyJudge().judgeEmpty(cate.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视类型名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      cate.setId(id.toString());
      movieService.createCate(cate);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/tag")
  public ResponseType<Object> createArea(@RequestBody Tag tag){
    if(new EmptyJudge().judgeEmpty(tag.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视标签名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      tag.setId(id.toString());
      movieService.createTag(tag);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createMovie(@RequestBody MovieDTO movie){
    if(new EmptyJudge().judgeEmpty(movie.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getDirectorList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "导演不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getScreenWriterList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getActorList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "地区不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getLanguage())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "语言不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getReleaseTime())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "上映时间不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getDuration())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "时长不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getForm())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影形式不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getActorList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getCateList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "分类不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影简介不能为空",null);
    }else{
      System.out.println(movie.getDirectors());
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
}
