package com.codergb.controller.movie;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.movie.FilmList;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.dto.movie.FilmListDTO;
import com.codergb.service.movie.FilmListService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/movie/filmList")
public class FilmListController {
  @Autowired
  FilmListService filmListService;
  //创建片单
  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> createFilmList(@RequestBody FilmListDTO filmList,
                                             @RequestAttribute("userId") String userId){
    if(new EmptyJudge().judgeEmpty(filmList.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "片单名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(filmList.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"片单简介不能为空",null);
    }else{
      Long id=new Date().getTime();
      filmList.setUserId(userId);
      filmList.setId(id.toString());
      filmListService.createFilmList(filmList);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), filmList);
    }
  }
  //上传片单封面
  @LoginAuth
  @PostMapping("/cover/upload/{id}")
  public ResponseType<Object> uploadCover(@PathVariable("id") String id,
                                          @RequestBody MultipartFile cover){
    if(new EmptyJudge().judgeEmpty(cover)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "封面不能为空",null);
    }
    String filename=new FileUniqueName().getFileUniqueName(cover.getOriginalFilename());
    FilmList filmList=new FilmList();
    filmList.setId(id);
    filmList.setFilename(filename);
    filmList.setDest(UploadPath.FILMLIST_COVER_UPLOAD_PATH.getUPLOADPATH());
    filmList.setOriginalname(cover.getOriginalFilename());
    filmList.setMimetype(cover.getContentType());
    filmList.setSize(cover.getSize());
    filmList.setCoverUrl(Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/movie/filmList/cover/"+id);
    try {
      cover.transferTo(new File(System.getProperty("user.dir")+UploadPath.FILMLIST_COVER_UPLOAD_PATH.getUPLOADPATH()+filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    filmListService.uploadCover(filmList);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
  }
  //获取片单封面
  @GetMapping("/cover/{id}")
  public ResponseEntity<byte[]> getFilmListCover(@PathVariable("id") String id){
    FilmList filmList=filmListService.getFilmListById(id);
    return new FilePreview().getFilePreview(System.getProperty("user.dir")+filmList.getDest()+filmList.getFilename(),filmList.getMimetype());
  }
}
