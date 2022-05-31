package com.codergb.controller.movie;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.CommentPic;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/comment")
public class CommentController {
  @Autowired
  CommentService commentService;
  //发布评论
  @LoginAuth
  @PostMapping("/publish")
  public ResponseType<Object> publishComment(@RequestBody CommentDTO commentDTO,
                                             @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(commentDTO.getContent())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "评论内容不能为空",null);
    }else {
      commentDTO.setUserId(userId);
      Long id=new Date().getTime();
      commentDTO.setId(id.toString());
      commentService.addComment(commentDTO);
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
}
