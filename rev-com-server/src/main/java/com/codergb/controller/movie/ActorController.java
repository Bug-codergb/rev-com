package com.codergb.controller.movie;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.movie.Actor;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.dto.movie.ActorDTO;
import com.codergb.service.movie.ActorService;
import com.codergb.service.movie.OccupationService;
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

import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

  @Autowired
  ActorService actorService;
  @Autowired
  OccupationService occupationService;

  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createActor(@RequestBody ActorDTO actor){
    if(new EmptyJudge().judgeEmpty(actor.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getForeignName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员外文名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getConstellation())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员星座不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getBirth())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员生日不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员出生地不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getFamily())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员家庭成员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actor.getOccupationList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"演员职业不能为空",null);
    }else{
      Long id=new Date().getTime();
      actor.setId(id.toString());
      actorService.createActor(actor);
      for(String item:actor.getOccupationList()){
        occupationService.setOccupation("aId",actor.getId(),item);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Actor>>> getAllActor(@RequestParam("page") Integer page,
                                              @RequestParam("limit") Integer limit,
                                              @RequestParam(value="keyword",required = false) String keyword ){
    if(keyword==null){
      keyword="";
    }
    Page<Actor> actors=actorService.getAllActor(page,limit,keyword);
    PageResult pageResult=new PageResult<List<Actor>>(actors.getPageNum(),
                                                      actors.getTotal(),
                                                      actors.getPages(),
                                                      actors);
    return new ResponseType<PageResult<List<Actor>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
  @LoginAuth
  @PostMapping("/update")
  public ResponseType<Object> updateActor(@RequestBody ActorDTO actorDTO){
    if(new EmptyJudge().judgeEmpty(actorDTO.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员id不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getForeignName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员外文名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getConstellation())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员星座不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getBirth())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员生日不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getBirthPlace())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员出生地不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getFamily())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员家庭成员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(actorDTO.getOccupationList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员职业不能为空",null);
    }else{
      occupationService.deleteOccupationForRole("aId",actorDTO.getId());
      for(String item:actorDTO.getOccupationList()){
        occupationService.setOccupation("aId",actorDTO.getId(),item);
      }
      actorService.updateActor(actorDTO);
      return new ResponseType<Object>(HttpStatus.OK.value(), "演员信息更新成功",null);
    }
  }
  @LoginAuth
  @PostMapping("/delete")
  public ResponseType<Object> deleteActor(@RequestParam("id") String id){
    if(new EmptyJudge().judgeEmpty(id)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员id不能为空",null);
    }else{
      actorService.deleteActor(id);
      return new ResponseType<Object>(HttpStatus.OK.value(),"演员删除成功",null);
    }
  }
  @LoginAuth
  @PostMapping("/avatar/upload/{id}")
  public ResponseType<Object> uploadAvatar(@PathVariable("id") String id,
                                           @RequestBody MultipartFile avatar){
    if(new EmptyJudge().judgeEmpty(avatar)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "演员头像不能为空",null);
    }else{
      String filename=new FileUniqueName().getFileUniqueName(avatar.getOriginalFilename());
      String avatarUrl= Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/actor/avatar/"+id;
      Actor actor=new Actor();
      actor.setId(id);
      actor.setAvatarUrl(avatarUrl);
      actor.setOriginalname(avatar.getOriginalFilename());
      actor.setFilename(filename);
      actor.setMimetype(avatar.getContentType());
      actor.setDest(UploadPath.ACTOR_AVATAR_UPLOAD_PATH.getUPLOADPATH());
      actor.setSize(avatar.getSize());
      try {
        avatar.transferTo(new File(System.getProperty("user.dir")+UploadPath.ACTOR_AVATAR_UPLOAD_PATH.getUPLOADPATH()+filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
      actorService.uploadAvatar(actor);
      return new ResponseType<Object>(HttpStatus.OK.value(), "演员头像上传成功",null);
    }
  }
  @GetMapping("/avatar/{id}")
  public ResponseEntity<byte[]> getActorAvatar(@PathVariable("id") String id){
     Actor actor=actorService.getActorById(id);
     return new FilePreview().getFilePreview(System.getProperty("user.dir")+actor.getDest()+"/"+actor.getFilename(),actor.getMimetype());
  }
}
