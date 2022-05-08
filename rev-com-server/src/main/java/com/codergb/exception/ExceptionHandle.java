package com.codergb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ExceptionHandle extends RuntimeException{
  public ExceptionHandle(){}
  public ExceptionHandle(String message){
    super(message);
  }
}
