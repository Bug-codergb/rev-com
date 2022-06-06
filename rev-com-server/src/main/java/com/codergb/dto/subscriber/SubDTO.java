package com.codergb.dto.subscriber;

import com.codergb.bean.Subscriber;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class SubDTO extends Subscriber {
  private String userId;
  private String cId;
}
