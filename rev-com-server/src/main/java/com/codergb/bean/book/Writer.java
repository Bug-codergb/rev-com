package com.codergb.bean.book;

import com.codergb.bean.FileInfo;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Writer extends FileInfo {
  private String id;
  private String name;
  private String gender;
  private Date birth;
  private Date deadTime;
  private String birthPlace;
  private String area;
  private String foreignName;
  private String alias;
  private String description;
  private Date createTime;
  private Date updateTime;
}
