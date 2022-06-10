package com.codergb.controller.music.artist;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.music.artist.ArtistType;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.music.artist.ArtistTypeService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/music/artist")
public class ArtistTypeController {
  @Autowired
  ArtistTypeService artistTypeService;
  @LoginAuth
  @PostMapping("/type")
  public ResponseType<Object> createArtistType(@RequestBody ArtistType artistType){
    if(new EmptyJudge().judgeEmpty(artistType.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手类型名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      artistType.setId(id.toString());
      artistTypeService.createArtistCate(artistType);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @GetMapping("/type/{id}")
  public ResponseType<Object> getArtistTypeById(@PathVariable("id") String id){
    ArtistType artistType=artistTypeService.getArtistTypeById(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), artistType);
  }
  @LoginAuth
  @GetMapping("/type/all")
  public ResponseType<Object> getAllArtistType(){
    List<ArtistType> artistTypeList=artistTypeService.getAllArtistType();
    return new ResponseType<Object>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), artistTypeList);
  }
}
