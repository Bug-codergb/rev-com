package com.codergb.dto.comment;

import com.codergb.bean.Comment;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class CommentDTO extends Comment {
  private String userId;
  private String replyId;
  private String relateId;
}
