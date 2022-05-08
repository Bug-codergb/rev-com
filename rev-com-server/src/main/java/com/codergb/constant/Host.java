package com.codergb.constant;

public enum Host {
  HOST_NAME("http://localhost"),
  HOST_PORT("8888");
  private final String HOST;
  Host(String host){
    this.HOST=host;
  }
  public String getHOST() {
    return HOST;
  }
}
