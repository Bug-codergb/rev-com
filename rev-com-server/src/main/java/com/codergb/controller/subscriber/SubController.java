package com.codergb.controller.subscriber;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Subscriber;
import com.codergb.bean.Thumb;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.subscriber.SubService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sub")
public class SubController {
  //收藏
  @Autowired
  SubService subService;
  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> sub(@RequestParam("key") String key,
                                    @RequestParam("relateId") String related,
                                    @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(key)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "收藏项不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(related)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "收藏项id不能为空",null);
    }else{
      List<Subscriber> sub=subService.getUserSub(key,related,userId);
      if(sub.size()>0){
        return new ResponseType<Object>(HttpStatus.FORBIDDEN.value(), "您已经收藏",null);
      }else{
        Long id=new Date().getTime();
        subService.sub(id.toString(),key,related,userId);
        return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
      }
    }
  }
  //取消收藏
  @LoginAuth
  @PostMapping("/cancel")
  public ResponseType<Object> cancelSub(@RequestParam("key") String key,
                                          @RequestParam("relateId") String related,
                                          @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(key)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "收藏项不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(related)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "收藏项id不能为空",null);
    }else{
      subService.cancelSub(key, related, userId);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
}
