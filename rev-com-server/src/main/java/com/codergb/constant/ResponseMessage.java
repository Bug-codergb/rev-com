package com.codergb.constant;

public enum ResponseMessage {
  SUCCESS("success");
  private final String MESSAGE_NAME;
  ResponseMessage(String msg){
    this.MESSAGE_NAME=msg;
  }
  public String getMESSAGE() {
    return MESSAGE_NAME;
  }
}
