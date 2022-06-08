package com.codergb.bean.movie;

import com.codergb.bean.FileInfo;
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
public class Movie  extends FileInfo {
  private String id;
  private String name;
  private float score;
  private List<Director> directors;
  private List<Screenwriter> screenwriters;
  private String coverUrl;
  private List<Area> area;
  private String language;
  private Date releaseTime;
  private Long duration;
  private String alias;
  private Form form;
  private Integer comment;
  private List<Actor> actors;
  private List<Category> categories;
  private String description;
}
