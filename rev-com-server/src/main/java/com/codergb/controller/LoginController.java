package com.codergb.controller;

import com.codergb.bean.User;
import com.codergb.constant.ErrorType;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.UserService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import com.codergb.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
  @Autowired
  UserService userService;

  @PostMapping("/register")
  public ResponseType<Object> register(@RequestBody User user){
     if(new EmptyJudge().judgeEmpty(user.getUserName()) || new EmptyJudge().judgeEmpty(user.getPassword())){
       return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),ErrorType.USER_NAME_OR_PASSWORD_IS_NOT_NULL.getErrorMsg(), null);
     }else{
       User currentUser=userService.getUserByName(user.getUserName());
       if(currentUser==null){
         Long userId=new Date().getTime();
         user.setUserId(userId.toString());
         userService.register(user);
         return new ResponseType<Object>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), null);
       }else{//用户已经存在
         return new ResponseType<Object>(HttpStatus.FORBIDDEN.value(),ErrorType.USER_IS_ALREADY_EXISTS.getErrorMsg(),null );
       }
     }
  }
  @PostMapping("/login")
  public ResponseType<User> login(@RequestBody User user){
    if(new EmptyJudge().judgeEmpty(user.getUserName()) || new EmptyJudge().judgeEmpty(user.getPassword())){
      return new ResponseType<User>(HttpStatus.BAD_REQUEST.value(), ErrorType.USER_NAME_OR_PASSWORD_IS_NOT_NULL.getErrorMsg(),null);
    }else{
      User userResult=userService.getUserByNamePass(user.getUserName(),user.getPassword());
      if(userResult!=null){
        Token token=new Token();
        String tokenStr=token.createJWT(userResult);
        userResult.setToken(tokenStr);
        System.out.println(userResult);
        return new ResponseType<User>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), userResult);
      }else{
        return new ResponseType<User>(HttpStatus.BAD_REQUEST.value(),ErrorType.USER_NAME_OR_PASSWORD_IS_ERROR.getErrorMsg(),null);
      }
    }
  }
}
