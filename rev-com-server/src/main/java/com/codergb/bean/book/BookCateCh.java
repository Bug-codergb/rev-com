package com.codergb.bean.book;

import lombok.*;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookCateCh{
  private String id;
  private String name;
  private BookCate bookCate;
  private Date createTime;
  private Date updateTime;
}
