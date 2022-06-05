package com.codergb.controller.comment;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Comment;
import com.codergb.bean.CommentPic;
import com.codergb.bean.PageResult;
import com.codergb.bean.wangEditor.WangData;
import com.codergb.bean.wangEditor.WangEditor;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.dto.comment.CommentDTO;
import com.codergb.service.comment.CommentService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
  @Autowired
  CommentService commentService;
  //发布评论
  @LoginAuth
  @PostMapping("/publish")
  public ResponseType<Object> publishComment(@RequestBody CommentDTO commentDTO,
                                             @RequestParam("key") String key,
                                             @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(commentDTO.getContent())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "评论内容不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(key)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "评论项ID不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(commentDTO.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "评论ID不能为空",null);
    }else {
      commentService.addComment(commentDTO.getId(),commentDTO.getContent(),userId,key,commentDTO.getRelateId(),commentDTO.getTitle(),commentDTO.getScore(),commentDTO.getIsShort());
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), commentDTO);
    }
  }
  //评论图片上传
  @LoginAuth
  @PostMapping("/upload/{id}")
  public WangEditor uploadCommentPic(@RequestBody MultipartFile picture,
                                     @PathVariable("id") String cId){
    if(new EmptyJudge().judgeEmpty(picture)){
      WangEditor wangEditor=new WangEditor();
      wangEditor.setErrno(400);
      wangEditor.setMessage("上传图片不能为空");
      return wangEditor;
    }else{
      CommentPic commentPic=new CommentPic();
      Long id=new Date().getTime();
      commentPic.setId(id.toString());
      String filename=new FileUniqueName().getFileUniqueName(picture.getOriginalFilename());
      String picUrl= Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/comment/picture/"+id;
      commentPic.setCId(cId);
      commentPic.setPicUrl(picUrl);
      commentPic.setMimetype(picture.getContentType());
      commentPic.setOriginalname(picture.getOriginalFilename());
      commentPic.setSize(picture.getSize());
      commentPic.setFilename(filename);
      commentPic.setDest(UploadPath.COMMENT_PICTURE_UPLOAD_PATH.getUPLOADPATH());
      try {
        picture.transferTo(new File(System.getProperty("user.dir")+ UploadPath.COMMENT_PICTURE_UPLOAD_PATH.getUPLOADPATH()+filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
      commentService.addCommentPic(commentPic);
      WangEditor wangEditor=new WangEditor();
      wangEditor.setErrno(0);
      wangEditor.setMessage("图片上传成功");
      wangEditor.setData(new WangData(picUrl,"",""));
      return wangEditor;
    }
  }
  @GetMapping("/picture/{id}")
  public ResponseEntity<byte []> getCommentPic(@PathVariable("id") String id){
    CommentPic commentPic= commentService.getCommentPic(id);
    System.out.println(commentPic.getDest());
    return new FilePreview().getFilePreview(System.getProperty("user.dir")+commentPic.getDest()+"/"+commentPic.getFilename(),commentPic.getMimetype());
  }
  //获取所有短评
  @LoginAuth
  @GetMapping("/short/all")
  public ResponseType<PageResult<List<Comment>>> getAllShort(@RequestParam("page") Integer page,
                                                             @RequestParam("limit") Integer limit,
                                                             @RequestParam("key") String key,
                                                             @RequestParam("relateId") String relateId){
    if(new EmptyJudge().judgeEmpty(key)){
      return new ResponseType<PageResult<List<Comment>>>(HttpStatus.OK.value(), "key不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(relateId)){
      return new ResponseType<PageResult<List<Comment>>>(HttpStatus.OK.value(), "relateId不能为空",null);
    }else{
      Page<Comment> comments=commentService.getAllShortCom(page,limit,key,relateId);
      PageResult pageResult=new PageResult<List<Comment>>(comments.getPageNum(),
              comments.getTotal(),
              comments.getPages(),
              comments);
      return new ResponseType<PageResult<List<Comment>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
    }
  }
  //获取所有影评
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Comment>>> getAllComment(@RequestParam("page") Integer page,
                                                             @RequestParam("limit") Integer limit,
                                                             @RequestParam("key") String key,
                                                             @RequestParam("relateId") String relateId){
    if(new EmptyJudge().judgeEmpty(key)){
      return new ResponseType<PageResult<List<Comment>>>(HttpStatus.OK.value(), "key不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(relateId)){
      return new ResponseType<PageResult<List<Comment>>>(HttpStatus.OK.value(), "relateId不能为空",null);
    }else{
      Page<Comment> comments=commentService.getAllComment(page,limit,key,relateId);
      PageResult pageResult=new PageResult<List<Comment>>(comments.getPageNum(),
              comments.getTotal(),
              comments.getPages(),
              comments);
      return new ResponseType<PageResult<List<Comment>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
    }
  }
  //获取影评详情
  @LoginAuth
  @GetMapping("/detail/{id}")
  public ResponseType<Object> getMovieReviewDetail(@PathVariable("id") String id){
    Comment comment= commentService.getCommentDetail(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), comment);
  }
  //回复评论
  @LoginAuth
  @PostMapping("/reply")
  public ResponseType<Object> replyComment(@RequestBody CommentDTO commentDTO,
                                           @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(commentDTO.getReplyId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"评论ID不能为空",null);
    }else if (new EmptyJudge().judgeEmpty(commentDTO.getContent())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"回复内容不能为空",null);
    }else if (new EmptyJudge().judgeEmpty(userId)){
      return new ResponseType<Object>(HttpStatus.UNAUTHORIZED.value(),"请登录",null);
    }else{
      Long id=new Date().getTime();
      commentDTO.setId(id.toString());
      commentDTO.setUserId(userId);
      commentService.replyComment(commentDTO);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @GetMapping("/reply/all/{id}")
  public ResponseType<PageResult<List<Comment>>> getAllCommentReply(@RequestParam("page") Integer page,
                                                 @RequestParam("limit") Integer limit,
                                                 @PathVariable("id") String id){
    Page<Comment> comments=commentService.getAllCommentReply(page,limit,id);
    PageResult pageResult=new PageResult<List<Comment>>(comments.getPageNum(),
            comments.getTotal(),
            comments.getPages(),comments);
    return new ResponseType<PageResult<List<Comment>>>(HttpStatus.OK.value(),
                                                       ResponseMessage.SUCCESS.getMESSAGE(),
                                                      pageResult);
  }
}
