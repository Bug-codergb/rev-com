package com.codergb.controller.music.artist;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.music.artist.ArtistCate;
import com.codergb.constant.ResponseMessage;
import com.codergb.service.music.artist.ArtistCateService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/music/artist")
public class ArtistCateController {
  @Autowired
  ArtistCateService artistService;
  @LoginAuth
  @PostMapping("/cate")
  public ResponseType<Object> createArtistCate(@RequestBody ArtistCate artistCate){
    if(new EmptyJudge().judgeEmpty(artistCate.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "歌手分类名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      artistCate.setId(id.toString());
      artistService.createArtistCate(artistCate);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @GetMapping("/cate/all")
  public ResponseType<Object> getAllArtistCate(){
    List<ArtistCate> artistCateList=artistService.getAllArtistCate();
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), artistCateList);
  }
  @LoginAuth
  @GetMapping("/cate/{id}")
  public ResponseType<Object> getArtistCateById(@PathVariable("id") String id){
    ArtistCate artistCate=artistService.getArtistCateById(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), artistCate);
  }
}
