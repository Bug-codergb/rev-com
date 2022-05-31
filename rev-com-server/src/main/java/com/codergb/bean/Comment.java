package com.codergb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  private String id;
  private String content;
  private User user;
  private Comment reply;
  private Date createTime;
  private Date updateTime;
}
