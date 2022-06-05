package com.codergb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  private String id;
  private String content;
  private String title;
  private User user;
  private Double score;
  private Integer isShort;
  private Comment reply;
  private Date createTime;
  private Date updateTime;
}
