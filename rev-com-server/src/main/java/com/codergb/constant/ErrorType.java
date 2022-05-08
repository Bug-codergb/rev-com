package com.codergb.constant;

public enum ErrorType {
  USER_NAME_OR_PASSWORD_IS_NOT_NULL("用户名或者密码不能为空"),
  USER_NAME_OR_PASSWORD_IS_ERROR("用户名或者密码错误"),
  UNAUTHORIZATION("请登录"),
  USER_IS_ALREADY_EXISTS("用户名已经存在"),
  FILE_CANNOT_BE_EMPTY("上传文件不能为空");
  private final String ERRORMESSAGE;
  ErrorType(String errorMsg){
    this.ERRORMESSAGE=errorMsg;
  }
  public String getErrorMsg(){
    return ERRORMESSAGE;
  }
}
