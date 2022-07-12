package com.codergb.bean.book;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookCate {
  private String id;
  private String name;
  private List<BookCateCh> bookCateChList;
  private Date createTime;
  private Date updateTime;
}
