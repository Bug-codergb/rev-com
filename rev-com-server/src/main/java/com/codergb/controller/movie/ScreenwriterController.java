package com.codergb.controller.movie;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.movie.Screenwriter;
import com.codergb.constant.ResponseMessage;
import com.codergb.dto.movie.ScreenwriterDTO;
import com.codergb.service.movie.ScreenwriterService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/screenwriter")
public class ScreenwriterController {

  @Autowired
  ScreenwriterService screenwriterService;

  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createScreenwriter(@RequestBody ScreenwriterDTO screenwriter){
    if(new EmptyJudge().judgeEmpty(screenwriter.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getFamily())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "家庭成员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getGender())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "性别不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出生地不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getBirth())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "生日不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getOccupationList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "职业不能为空",null);
    }else{
      Long id=new Date().getTime();
      screenwriter.setId(id.toString());
      screenwriterService.createScreenwriter(screenwriter);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Screenwriter>>> getAllScreenwriter(@RequestParam("page") Integer page,
                                                                  @RequestParam("limit") Integer limit,
                                                                  @RequestParam(value = "keyword",required = false) String keyword){
    if(keyword==null){
      keyword="";
    }
    Page<Screenwriter> screenwriters= screenwriterService.getAllScreenwriter(page,limit,keyword);
    PageResult pageResult=new PageResult<List<Screenwriter>>(screenwriters.getPageNum(),
                                                             screenwriters.getTotal(),
                                                             screenwriters.getPages(),
                                                              screenwriters);
    return new ResponseType<PageResult<List<Screenwriter>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
}
