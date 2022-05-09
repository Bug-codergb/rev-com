package com.codergb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageResult<T> {
  private Integer pageNum ;//当前第几页
  private Long total;   //总条数
  private Integer pages;   // 总页数
  private T data;
}
