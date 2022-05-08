package com.codergb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Movie  extends FileInfo{
  private String id;
  private String name;
  private List<Director> director;
  private List<Screenwriter> screenwriter;
  private String coverUrl;
  private String area;
  private String language;
  private Date releaseTime;
  private Long duration;
  private String alias;
}
