package com.codergb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileInfo {
  private String originalname;
  private String mimetype;
  @JsonIgnore
  private String dest;
  private String filename;
  private Long size;
}

