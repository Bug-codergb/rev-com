package com.codergb.dto.thumb;

import com.codergb.bean.Thumb;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ThumbDTO extends Thumb {
  private String userId;
  private String cId;
}
