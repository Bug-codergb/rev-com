package com.codergb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Aspect
@Component
public class ResponseCode {
  @Autowired
  HttpServletResponse response;
  @Pointcut("@annotation(com.codergb.annotation.ResponseCode)")
  public void ResponseCode(){}

  @Before("ResponseCode()")
  public void before() throws Throwable{
    System.out.println("之前");
  }

  @Around("ResponseCode()")
  public Object after(ProceedingJoinPoint joinPoint) throws Throwable{
    System.out.println("之后");
    MethodSignature signature=(MethodSignature) joinPoint.getSignature();
    Method method=signature.getMethod();
    System.out.println(method);
    System.out.println(signature.getReturnType().getFields().length);
    response.setStatus(500);
    return joinPoint.proceed();
  }

  @AfterReturning("ResponseCode()")
  public void afterReturn() throws Throwable{
    System.out.println("结果之后");
  }
}
