package com.codergb.dto.movie;

import com.codergb.bean.movie.Screenwriter;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class ScreenwriterDTO extends Screenwriter {
  private List<String> occupationList;
}
