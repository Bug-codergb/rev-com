package com.codergb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Thumb {
  private String id;
  private User user;
  private Comment comment;
  private Date createTime;
  private Date updateTime;
}
