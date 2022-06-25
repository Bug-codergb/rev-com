package com.codergb.controller.music.artist;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.FileInfo;
import com.codergb.bean.PageResult;
import com.codergb.bean.movie.Actor;
import com.codergb.bean.music.artist.Artist;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.dto.music.artist.ArtistDTO;
import com.codergb.service.music.artist.ArtistService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.apache.coyote.Response;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/music/artist")
public class ArtistController {
  @Autowired
  ArtistService artistService;
  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> createArtist(@RequestBody ArtistDTO artist){
    if(new EmptyJudge().judgeEmpty(artist.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(artist.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(artist.getTypeId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手类型ID不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(artist.getCateId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手分类ID不能为空",null);
    }else{
      Long id=new Date().getTime();
      artist.setId(id.toString());
      artistService.createArtist(artist);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), artist);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Artist>>> getAllArtist(@RequestParam(value = "keyword",required = false) String keyword,
                                                             @RequestParam(value = "area", required = false) String area,
                                                             @RequestParam(value = "type",required = false) String type,
                                                             @RequestParam("page") Integer page,
                                                             @RequestParam("limit") Integer limit){
    Page<Artist> artist=artistService.getAllArtist(keyword, area, type, page, limit);
    PageResult pageResult=new PageResult<List<Artist>>(artist.getPageNum(),
            artist.getTotal(),
            artist.getPages(),artist);
    return new ResponseType<PageResult<List<Artist>>>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
  //上传歌手头像
  @LoginAuth
  @PostMapping("/avatar/upload/{id}")
  public ResponseType<Object> uploadAvatar(@PathVariable("id") String id,
                                           @RequestBody MultipartFile avatar){
    if(new EmptyJudge().judgeEmpty(avatar)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"歌手头像不能为空",null);
    }else{
      String filename=new FileUniqueName().getFileUniqueName(avatar.getOriginalFilename());
      String avatarUrl= Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/music/artist/avatar/"+id;
      Artist artist=new Artist();
      artist.setId(id);
      artist.setAvatarUrl(avatarUrl);
      artist.setFilename(filename);
      artist.setOriginalname(avatar.getOriginalFilename());
      artist.setSize(avatar.getSize());
      artist.setMimetype(avatar.getContentType());
      artist.setDest(UploadPath.ARTIST_AVATAR_UPLOAD_PATH.getUPLOADPATH());
      try {
        avatar.transferTo(new File(System.getProperty("user.dir")+UploadPath.ARTIST_AVATAR_UPLOAD_PATH.getUPLOADPATH()+filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
      artistService.uploadAvatar(artist);
      return new ResponseType<Object>(HttpStatus.OK.value(),"歌手头像上传成功",null);
    }
  }
  //获取歌手头像
  @GetMapping("/avatar/{id}")
  public ResponseEntity<byte[]> getArtistAvatar(@PathVariable("id") String id){
    Artist artist=artistService.getArtistById(id);
    return new FilePreview().getFilePreview(System.getProperty("user.dir")+artist.getDest()+"/"+artist.getFilename(),artist.getMimetype());
  }
  //更新歌手信息
  @LoginAuth
  @PostMapping("/update")
  public ResponseType<Object> updateArtist(@RequestBody ArtistDTO artist){
    if(new EmptyJudge().judgeEmpty(artist.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手ID不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(artist.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(artist.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(artist.getTypeId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手类型ID不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(artist.getCateId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手分类ID不能为空",null);
    }else{
      artistService.updateArtist(artist);
      return new ResponseType<Object>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //删除歌手信息
  @LoginAuth
  @PostMapping("/delete/{id}")
  public ResponseType<Object> deleteArtist(@PathVariable("id") String id){
    Artist artist=artistService.getArtistById(id);
    File file=new File(System.getProperty("user.dir")+artist.getDest()+artist.getFilename());
    if(file.isFile()&&file.exists()){
      boolean isDelete=file.delete();
    }
    artistService.deleteArtist(id);
    return new ResponseType<Object>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), null);
  }
  //更新歌手头像信息
  @LoginAuth
  @PostMapping("/avatar/update/{id}")
  public ResponseType<Object> updateAvatar(@PathVariable("id") String id,
                                           @RequestBody MultipartFile avatar){
    if(new EmptyJudge().judgeEmpty(avatar)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "头像不能为空",null);
    }else{
      Artist artist=artistService.getArtistById(id);
      File file=new File(System.getProperty("user.dir")+artist.getDest()+artist.getFilename());
      if(file.exists()){
        boolean isDelete=file.delete();
        this.uploadAvatar(id,avatar);
      }else{
        this.uploadAvatar(id,avatar);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
}
