package com.codergb.controller.thumb;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Thumb;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.thumb.ThumbService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/thumb")
public class ThumbController {
  @Autowired
  ThumbService thumbService;
  //点赞
  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> thumb(@RequestParam("key") String key,
                                    @RequestParam("relateId") String related,
                                    @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(key)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "点赞项不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(related)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "点赞项id不能为空",null);
    }else{
      List<Thumb> thumb=thumbService.getUserThumb(key,related,userId);
      if(thumb.size()>0){
        return new ResponseType<Object>(HttpStatus.FORBIDDEN.value(), "您已经点赞",null);
      }else{
        Long id=new Date().getTime();
        thumbService.thumb(id.toString(),key,related,userId);
        return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
      }
    }
  }
  //取消点赞
  @LoginAuth
  @PostMapping("/cancel")
  public ResponseType<Object> cancelThumb(@RequestParam("key") String key,
                                          @RequestParam("relateId") String related,
                                          @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(key)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "点赞项不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(related)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "点赞项id不能为空",null);
    }else{
      thumbService.cancelThumb(key, related, userId);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
}
