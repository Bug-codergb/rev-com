package com.codergb.controller;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.movie.Director;
import com.codergb.bean.PageResult;
import com.codergb.constant.ErrorType;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.service.DirectorService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {

  @Autowired
  DirectorService directorService;

  @LoginAuth
  @PostMapping("/")
  public ResponseType<Director> createDirector(@RequestBody Director director){
    if(new EmptyJudge().judgeEmpty(director.getName())){
      return new ResponseType<Director>(HttpStatus.BAD_REQUEST.value(),"导演名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(director.getAlias())){
      return new ResponseType<Director>(HttpStatus.BAD_REQUEST.value(), "导演别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(director.getGender())){
      return new ResponseType<Director>(HttpStatus.BAD_REQUEST.value(), "性别不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(director.getBirthPlace())){
      return new ResponseType<Director>(HttpStatus.BAD_REQUEST.value(),"出生地不能为空",null );
    }else if(new EmptyJudge().judgeEmpty(director.getDescription())){
      return new ResponseType<Director>(HttpStatus.BAD_REQUEST.value(),"导演简介不能为空",null );
    }else{
      Long id=new Date().getTime();
      director.setId(id.toString());
      directorService.createDirector(director);
      return new ResponseType<Director>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), director);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Director>>> getAllDirector(@RequestParam("page") Integer page,
                                                           @RequestParam("limit") Integer limit,
                                                           @RequestParam(value = "keyword",required = false) String keyword){
    if(keyword==null){
      keyword="";
    }
    Page<Director> directors=directorService.getAllDirector(page,limit,keyword);
    PageResult pageResult=new PageResult<List<Director>>(directors.getPageNum(),
                                                         directors.getTotal(),
                                                         directors.getPages(),
                                                         directors);
    return new ResponseType<PageResult<List<Director>>>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(),pageResult);
  }
  //上传导演头像
  @LoginAuth
  @PostMapping("/avatar/upload/{id}")
  public ResponseType<Object> uploadAvatar(@PathVariable("id") String id,
                                           @RequestBody MultipartFile avatar){
    if(new EmptyJudge().judgeEmpty(avatar)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), ErrorType.FILE_CANNOT_BE_EMPTY.getErrorMsg(), null);
    }else{
      String filename=new FileUniqueName().getFileUniqueName(avatar.getOriginalFilename());
      String avatarUrl= Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/director/avatar/"+id;
      Director director=new Director();
      director.setAvatarUrl(avatarUrl);
      director.setId(id);
      director.setMimetype(avatar.getContentType());
      director.setOriginalname(avatar.getOriginalFilename());
      director.setSize(avatar.getSize());
      director.setFilename(filename);
      director.setDest(UploadPath.DIRECTOR_AVATAR_UPLOAD_PATH.getUPLOADPATH());
      directorService.uploadAvatar(director);
      try {
        avatar.transferTo(new File(UploadPath.DIRECTOR_AVATAR_UPLOAD_PATH.getUPLOADPATH()+filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @GetMapping("/avatar/{id}")
  public ResponseEntity<byte[]> getDirectorAvatar(@PathVariable("id") String id){
    Director director=directorService.getDirectorById(id);
    return new FilePreview().getFilePreview(director.getDest()+"/"+director.getFilename(),director.getMimetype());
  }
}
