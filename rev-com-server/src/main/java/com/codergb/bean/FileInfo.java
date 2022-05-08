package com.codergb.bean;

import lombok.Data;

@Data
public class FileInfo {
  private String originalname;
  private String mimetype;
  private String dest;
  private String filename;
  private Long size;
}

