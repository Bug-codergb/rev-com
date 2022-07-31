package com.codergb.controller.awards;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Awards;
import com.codergb.bean.PageResult;
import com.codergb.bean.book.Book;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.awards.AwardsService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
  //获取所有奖项2
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Awards>>> getAllAwards(@RequestParam("page") Integer page,
                                                             @RequestParam("limit") Integer limit,
                                                             @RequestParam(value = "keyword",required = false) String keyword){
    Page<Awards> awards=awardsService.getAllAwards(page, limit, keyword);
    PageResult pageResult=new PageResult<List<Awards>>(awards.getPageNum(),
            awards.getTotal(),
            awards.getPages(),awards);
    return new ResponseType<PageResult<List<Awards>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
  //更新奖项信息
  @LoginAuth
  @PostMapping("/update")
  public ResponseType<Object> updateAwards(@RequestBody Awards awards){
    if(new EmptyJudge().judgeEmpty(awards.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项ID不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getName())){
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
      awardsService.updateAwards(awards);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
}
