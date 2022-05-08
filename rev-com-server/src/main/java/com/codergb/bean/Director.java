package com.codergb.bean;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Director extends FileInfo{
  private String id;
  private String name;
  private String alias;
  private String avatarUrl;
  private String gender;
  private String birthPlace;
  private String profession;
  private String description;
  private Date createTime;
  private Date updateTime;
}
