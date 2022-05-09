package com.codergb.bean.movie;

import com.codergb.bean.FileInfo;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Screenwriter extends FileInfo {
  private String id;
  private String name;
  private String avatarUrl;
  private String alias;
  private String gender;
  private String birthPlace;

  private String description;
  private Date createTime;
  private Date updateTime;
}
