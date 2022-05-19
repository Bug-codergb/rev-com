package com.codergb.controller.book;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.book.Writer;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.book.WriterService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/writer")
public class WriterController {
  @Autowired
  WriterService writerService;

  @LoginAuth
  @RequestMapping("")
  public ResponseType<Object> createWriter(@RequestBody Writer writer){
    if(new EmptyJudge().judgeEmpty(writer.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "作家名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(writer.getGender())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "作家性别不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(writer.getBirth())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "作家生日不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(writer.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "作家出生地不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(writer.getArea())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "地区不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(writer.getForeignName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "作家外文名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(writer.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "作家别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(writer.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "作家简介不能为空",null);
    }else{
      if(new EmptyJudge().judgeEmpty(writer.getDeadTime())){
        writer.setDeadTime(null);
      }
      Long id =new Date().getTime();
      writer.setId(id.toString());
      writerService.createWriter(writer);
      return new ResponseType<Object>(HttpStatus.OK.value(), "作家添加成功",writer);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Writer>>> getAllWriter(@RequestParam("page") Integer page,
                                                             @RequestParam("limit") Integer limit,
                                                             @RequestParam(value = "keyword",required = false) String keyword){
    Page<Writer> writer=writerService.getAllWriter(page, limit, keyword);
    PageResult pageResult=new PageResult<List<Writer>>(writer.getPageNum(),
            writer.getTotal(),
            writer.getPages(),
            writer);
    return new ResponseType<PageResult<List<Writer>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
}
