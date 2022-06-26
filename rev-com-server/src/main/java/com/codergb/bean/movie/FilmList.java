package com.codergb.bean.movie;

import com.codergb.bean.FileInfo;
import com.codergb.bean.User;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class FilmList extends FileInfo {
  private String id;
  private String name;
  private String coverUrl;
  private String description;
  private User user;
  private Date createTime;
  private Date updateTime;
}
