package com.codergb.dto.movie;

import com.codergb.bean.movie.Movie;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class MovieDTO extends Movie {
  private List<String> directorList;
  private List<String> screenwriterList;
  private List<String> areaList;
  private List<String> actorList;
  private List<String> cateList;
  private String formItem;
}
