package com.codergb.interceptor;

import com.alibaba.fastjson.JSON;
import com.codergb.annotation.LoginAuth;
import com.codergb.constant.ErrorType;
import com.codergb.exception.ExceptionHandle;
import com.codergb.utils.ResponseType;
import com.codergb.utils.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorController implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    if(!(handler instanceof HandlerMethod)){
      System.out.println("哈哈哈");
      return true;
    }
    HandlerMethod handlerMethod=(HandlerMethod)handler;
    LoginAuth isExists=handlerMethod.getMethodAnnotation(LoginAuth.class);
    if(isExists!=null){
      System.out.println("盒盒盒");
      String token=request.getHeader("Authorization");
      try{
        token=token.replace("Bearer ","");
        Token tokenUtis=new Token();
        if(token.equals("")){
          response.setStatus(HttpStatus.UNAUTHORIZED.value());
          response.setCharacterEncoding("UTF-8");
          ResponseType<Object> res=new ResponseType<Object>(HttpStatus.UNAUTHORIZED.value(), ErrorType.UNAUTHORIZATION.getErrorMsg(), null);
          response.getWriter().write(JSON.toJSONString(res));
          return false;
        }else{
          Claims claims=tokenUtis.parseToken(token);
          System.out.println(claims);
          request.setAttribute("userId",claims.get("userId"));
          request.setAttribute("userName",claims.get("userName"));
          return true;
        }
      }catch (MalformedJwtException e){
        System.out.println("hhh");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setCharacterEncoding("UTF-8");
        ResponseType<Object> res=new ResponseType<Object>(HttpStatus.UNAUTHORIZED.value(), ErrorType.UNAUTHORIZATION.getErrorMsg(), null);
        response.getWriter().write(JSON.toJSONString(res));
        return false;
      }
    }else{
     return true;
    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }
}
