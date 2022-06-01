package com.codergb.mapper.comment;

import com.codergb.bean.Comment;
import com.codergb.bean.CommentPic;
import com.codergb.dto.comment.CommentDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface CommentMapper {
  public int addCommentPic(CommentPic commentPic);//添加评论图片
  //添加评论
  public int addComment(@Param("id") String id, @Param("content") String content,
                        @Param("userId") String userId,@Param("key") String key,
                        @Param("relateId") String relateId,@Param("title") String title,
                        @Param("score") Double score,@Param("isShort") Integer isShort);
  //获取评论图片信息
  public CommentPic getCommentPic(@Param("id") String id);
  //获取所有短评
  public List<Comment> getAllShortCom(@Param("page")Integer page, @Param("limit") Integer limit,
                                      @Param("key") String key,@Param("relateId") String relateId);
  //获取评论回复
  public List<Comment> getAllReply(@Param("page") Integer page, @Param("limit") Integer limit,@Param("id") String id);
  //获取影评
  public List<Comment> getAllComment(@Param("page")Integer page, @Param("limit") Integer limit,
                                     @Param("key") String key,@Param("relateId") String relateId);
  //获取所有评论(包括短评和影评 根据电影ID)
  public List<Comment> getCommentList(@Param("id") String id);
}
