package com.codergb.bean.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Form {//电影形式
  private String id;
  private String name;
  private Date createTime;
  private Date updateTime;
}
