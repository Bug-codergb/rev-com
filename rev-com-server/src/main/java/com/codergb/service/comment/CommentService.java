package com.codergb.service.comment;
import com.codergb.bean.Comment;
import com.codergb.bean.CommentPic;
import com.codergb.dto.comment.CommentDTO;
import com.codergb.mapper.comment.CommentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
  @Autowired
  CommentMapper commentMapper;
  public int addCommentPic(CommentPic commentPic){
    return commentMapper.addCommentPic(commentPic);
  }
  public int addComment(String id,String content,String userId,String key,String relateId,String title,Double score,Integer isShort){
    return commentMapper.addComment(id,content,userId,key,relateId,title,score,isShort);
  }
  public CommentPic getCommentPic(String id){
    return commentMapper.getCommentPic(id);
  }
  //获取所有短评
  public Page<Comment> getAllShortCom(Integer page, Integer limit,String key,String relateId){
    Page<Comment> p= PageHelper.startPage(page,limit);
    commentMapper.getAllShortCom(page,limit,key,relateId);
    return p;
  }
  //获取所有影评
  public Page<Comment> getAllComment(Integer page, Integer limit,String key,String relateId){
    Page<Comment> p= PageHelper.startPage(page,limit);
    commentMapper.getAllComment(page,limit,key,relateId);
    return p;
  }
  //获取所有评论根据电影ID（计算评分）
  public List<Comment> getCommentList(String id){
    return commentMapper.getCommentList(id);
  }
  //获取评论详情根据id
  public Comment getCommentDetail(String id){
    return commentMapper.getCommentDetail(id);
  }
  //回复评论
  public int replyComment(CommentDTO commentDTO){
    return commentMapper.replyComment(commentDTO);
  }
  //获取所有评论回复
  public Page<Comment> getAllCommentReply(Integer page,Integer limit,String id){
    Page<Comment> p=PageHelper.startPage(page,limit);
    commentMapper.getCommentReply(page,limit,id);
    return p;
  }
}
