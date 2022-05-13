package com.codergb.dto.movie;

import com.codergb.bean.movie.Director;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class DirectorDTO extends Director {
  private List<String> occupationList;
}
