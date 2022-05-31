package com.codergb.bean;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentPic extends FileInfo{
  private String id;
  private String cId;
  private String picUrl;
  private Comment comment;
}
