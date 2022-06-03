package com.codergb.controller.book;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.book.Publish;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.book.PublishService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/publish")
public class PublishController {

  @Autowired
  PublishService publishService;

  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> createPublish(@RequestBody Publish publish){
    if(new EmptyJudge().judgeEmpty(publish.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getForeignName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社外文名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getRepresentative())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社法定代表人不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getIndustry())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版所属行业不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getEstablish())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社成立时间不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getOnline())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社官方网站不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getOrganizer())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社主办单位不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(publish.getType())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出版社类型不能为空",null);
    }else{
      Long id=new Date().getTime();
      publish.setId(id.toString());
      publishService.createPublish(publish);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), publish);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Publish>>> getAllWriter(@RequestParam("page") Integer page,
                                                             @RequestParam("limit") Integer limit,
                                                             @RequestParam(value = "keyword",required = false) String keyword){
    Page<Publish> publishes=publishService.getAllPublish(page, limit, keyword);
    PageResult pageResult=new PageResult<List<Publish>>(publishes.getPageNum(),
            publishes.getTotal(),
            publishes.getPages(),
            publishes);
    return new ResponseType<PageResult<List<Publish>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
}
