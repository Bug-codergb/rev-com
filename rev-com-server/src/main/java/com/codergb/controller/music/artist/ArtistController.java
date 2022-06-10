package com.codergb.controller.music.artist;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.music.artist.Artist;
import com.codergb.constant.ResponseMessage;
import com.codergb.dto.music.artist.ArtistDTO;
import com.codergb.service.music.artist.ArtistService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
