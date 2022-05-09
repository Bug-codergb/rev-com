package com.codergb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class FileInfo {
  private String originalname;
  private String mimetype;
  @JsonIgnore
  private String dest;
  private String filename;
  private Long size;
}

