package com.codergb.bean.movie;

import com.codergb.bean.FileInfo;
import com.codergb.bean.occupation.Occupation;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Actor extends FileInfo {
  private String id;
  private String name;
  private String avatarUrl;
  private String foreignName;
  private String alias;
  private String constellation;
  private List<Occupation> occupations;
  private Date birth;
  private String birthPlace;
  private String family;
  private String description;
  private Date createTime;
  private Date updateTime;
}
