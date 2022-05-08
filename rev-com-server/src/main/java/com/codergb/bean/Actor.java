package com.codergb.bean;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Actor extends FileInfo{
  private String id;
  private String name;
  private String avatarUrl;
  private String foreignName;
  private String alias;
  private String constellation;
  private String profession;
  private Date birth;
  private String birthPlace;
  private String family;
  private String description;
  private Date createTime;
  private Date updateTime;
}
