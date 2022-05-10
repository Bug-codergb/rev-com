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
public class Screenwriter extends FileInfo {
  private String id;
  private String name;
  private String avatarUrl;
  private String alias;
  private String family;
  private List<Occupation> occupations;
  private String gender;
  private String birthPlace;
  private Date birth;
  private String description;
  private Date createTime;
  private Date updateTime;
}
