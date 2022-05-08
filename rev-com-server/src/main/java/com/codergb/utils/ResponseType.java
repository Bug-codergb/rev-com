package com.codergb.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletResponse;

public class ResponseType<T>{
  private Integer status;
  private String message;
  private T data;
  public ResponseType(Integer status, String message, T data){
    this.status=status;
    this.message=message;
    this.data=data;
    ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse().setStatus(status);
  }
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
