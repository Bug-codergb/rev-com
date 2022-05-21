package com.codergb.bean.movie;

import com.codergb.bean.FileInfo;
import com.codergb.bean.occupation.Occupation;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Director extends FileInfo {
  private String id;
  private String name;
  private String alias;
  private String avatarUrl;
  private String gender;
  private String birthPlace;
  private List<Occupation> occupations;
  private List<Movie> movies;
  private String description;
  private Date createTime;
  private Date updateTime;
}
