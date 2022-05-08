package com.codergb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
  private String userId;
  private String userName;
  private String password;
  private String token;
  private String avatarUrl;
  private Date createTime;
  private Date updateTime;
  private Integer auth;
  private Integer manage;
  private Date expireTime;
  private String originalname;
  private String mimetype;
  private String dest;
  private String filename;
  private Long size;
}
