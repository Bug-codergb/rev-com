package com.codergb.bean.book;

import com.codergb.bean.FileInfo;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Book extends FileInfo {
  private String id;
  private String name;
  private Writer writer;
  private Publish publish;
  private Date publishTime;
  private String coverUrl;
  private Double price;
  private String description;
  private Integer pageCount;
  private Double score;
}
