package com.codergb.controller.movie;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.movie.Screenwriter;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.dto.movie.ScreenwriterDTO;
import com.codergb.service.movie.OccupationService;
import com.codergb.service.movie.ScreenwriterService;
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
@RequestMapping("/screenwriter")
public class ScreenwriterController {

  @Autowired
  ScreenwriterService screenwriterService;
  @Autowired
  OccupationService occupationService;
  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createScreenwriter(@RequestBody ScreenwriterDTO screenwriter){
    if(new EmptyJudge().judgeEmpty(screenwriter.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getFamily())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "家庭成员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getGender())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "性别不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出生地不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getBirth())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "生日不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getOccupationList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "职业不能为空",null);
    }else{
      Long id=new Date().getTime();
      screenwriter.setId(id.toString());
      screenwriterService.createScreenwriter(screenwriter);
      for(String item :screenwriter.getOccupationList()){
        occupationService.setOccupation("sId",screenwriter.getId(),item);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), screenwriter);
    }
  }
  @LoginAuth
  @PostMapping("/avatar/upload/{id}")
  public ResponseType<Object> uploadAvatar(@RequestBody MultipartFile avatar,
                                           @PathVariable("id") String id){
    if(new EmptyJudge().judgeEmpty(avatar)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧头像不能为空",null);
    }else{
      String filename=new FileUniqueName().getFileUniqueName(avatar.getOriginalFilename());
      String avatarUrl= Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/screenwriter/avatar/"+id;
      Screenwriter screenwriter=new Screenwriter();
      screenwriter.setId(id);
      screenwriter.setAvatarUrl(avatarUrl);
      screenwriter.setOriginalname(avatar.getOriginalFilename());
      screenwriter.setFilename(filename);
      screenwriter.setMimetype(avatar.getContentType());
      screenwriter.setDest(UploadPath.SCREENWRITER_AVATAR_UPLOAD_PATH.getUPLOADPATH());
      screenwriter.setSize(avatar.getSize());
      try {
        avatar.transferTo(new File(System.getProperty("user.dir")+UploadPath.SCREENWRITER_AVATAR_UPLOAD_PATH.getUPLOADPATH()+filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
      screenwriterService.uploadAvatar(screenwriter);
      return new ResponseType<Object>(HttpStatus.OK.value(), "头像上传成功",null);
    }
  }
  //获取编剧封面
  @GetMapping("/avatar/{id}")
  public ResponseEntity<byte[]> getScreenwriter(@PathVariable("id") String id){
    Screenwriter screenwriter= screenwriterService.getScreenwriterById(id);
    return new FilePreview().getFilePreview(System.getProperty("user.dir")+screenwriter.getDest()+"/"+screenwriter.getFilename(),screenwriter.getMimetype());
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Screenwriter>>> getAllScreenwriter(@RequestParam("page") Integer page,
                                                                  @RequestParam("limit") Integer limit,
                                                                  @RequestParam(value = "keyword",required = false) String keyword){
    if(keyword==null){
      keyword="";
    }
    Page<Screenwriter> screenwriters= screenwriterService.getAllScreenwriter(page,limit,keyword);
    PageResult pageResult=new PageResult<List<Screenwriter>>(screenwriters.getPageNum(),
                                                             screenwriters.getTotal(),
                                                             screenwriters.getPages(),
                                                              screenwriters);
    return new ResponseType<PageResult<List<Screenwriter>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
  @LoginAuth
  @PostMapping("/update")
  public ResponseType<Object> updateScreenwriter(@RequestBody ScreenwriterDTO screenwriter){
    if(new EmptyJudge().judgeEmpty(screenwriter.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧ID不能为空",null);
    } else if(new EmptyJudge().judgeEmpty(screenwriter.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getFamily())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "家庭成员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getGender())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "性别不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "出生地不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getBirth())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "生日不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(screenwriter.getOccupationList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "职业不能为空",null);
    }else{
      occupationService.deleteOccupationForRole("sId",screenwriter.getId());
      for(String item : screenwriter.getOccupationList()){
        occupationService.setOccupation("sId",screenwriter.getId(),item);
      }
      screenwriterService.updateScreenwriter(screenwriter);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), screenwriter);
    }
  }
  //更新头像信息
  @LoginAuth
  @PostMapping("/avatar/update/{id}")
  public ResponseType<Object> updateAvatar(@PathVariable("id") String id,
                                           @RequestBody MultipartFile avatar){
    if(new EmptyJudge().judgeEmpty(avatar)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"编剧头像不能为空",null);
    }else{
      Screenwriter screenwriter= screenwriterService.getScreenwriterById(id);
      File file=new File(System.getProperty("user.dir")+screenwriter.getDest()+screenwriter.getFilename());
      if(file.exists()){
        Boolean isDelete=file.delete();
        this.uploadAvatar(avatar,id);
      }else{
        this.uploadAvatar(avatar,id);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(),"编剧头像更新成功",null);
    }
  }
  //删除编剧
  @LoginAuth
  @PostMapping("/delete/{id}")
  public ResponseType<Object> deleteScreenwriter(@PathVariable("id") String id){
    Screenwriter screenwriter=screenwriterService.getScreenwriterById(id);
    File file=new File(System.getProperty("user.dir")+screenwriter.getDest()+screenwriter.getFilename());
    if(file.exists()){
      file.delete();
    }
    screenwriterService.deleteScreenwriter(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), "编剧删除成功",null);
  }
}
