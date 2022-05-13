package com.codergb.dto.movie;

import com.codergb.bean.movie.Actor;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class ActorDTO extends Actor {
  private List<String> occupationList;
}
