package com.codergb.service.comment;
import com.codergb.bean.Comment;
import com.codergb.bean.CommentPic;
import com.codergb.dto.comment.CommentDTO;
import com.codergb.mapper.comment.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
  @Autowired
  CommentMapper commentMapper;
  public int addCommentPic(CommentPic commentPic){
    return commentMapper.addCommentPic(commentPic);
  }
  public int addComment(CommentDTO commentDTO){
    return commentMapper.addComment(commentDTO);
  }
  public CommentPic getCommentPic(String id){
    return commentMapper.getCommentPic(id);
  }
}
