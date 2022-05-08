package com.codergb.constant;

public enum UploadPath {
  AVATAR_UPLOAD_PATH(System.getProperty("user.dir")+"/upload/avatar/");
  private final String UPLOADPATH;
  UploadPath(String UPLOADPATH) {
    this.UPLOADPATH = UPLOADPATH;
  }

  public String getUPLOADPATH() {
    return UPLOADPATH;
  }
}
