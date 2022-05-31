package com.codergb.mapper.comment;

import com.codergb.bean.CommentPic;
import com.codergb.dto.comment.CommentDTO;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
  public int addCommentPic(CommentPic commentPic);//添加评论图片
  //添加评论
  public int addComment(CommentDTO commentDTO);
  //获取评论图片信息
  public CommentPic getCommentPic(@Param("id") String id);
}
