package com.codergb.dto.movie;

import com.codergb.bean.movie.FilmList;
import lombok.*;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FilmListDTO extends FilmList {
  private String userId;
}
