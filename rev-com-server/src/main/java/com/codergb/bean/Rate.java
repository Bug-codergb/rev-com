package com.codergb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rate {
  private Double score;
  private Integer person;
  private Integer one;
  private Integer two;
  private Integer three;
  private Integer four;
  private Integer five;
}
