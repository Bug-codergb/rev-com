package com.codergb.bean.occupation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Occupation {
  private String id;
  private String name;
  private Date createTime;
  private Date updateTime;
}
