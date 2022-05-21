package com.codergb.controller.movie;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.movie.*;
import com.codergb.constant.ErrorType;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.dto.movie.MovieDTO;
import com.codergb.service.movie.MovieService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
  @Autowired
  MovieService movieService;

  @LoginAuth
  @PostMapping("/form")
  public ResponseType<Object> createForm(@RequestBody Form form){
    if(new EmptyJudge().judgeEmpty(form.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视形式名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      form.setId(id.toString());
      movieService.createForm(form);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/area")
  public ResponseType<Object> createArea(@RequestBody Area area){
    if(new EmptyJudge().judgeEmpty(area.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视地区名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      area.setId(id.toString());
      movieService.createArea(area);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/cate")
  public ResponseType<Object> createArea(@RequestBody Category cate){
    if(new EmptyJudge().judgeEmpty(cate.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视类型名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      cate.setId(id.toString());
      movieService.createCate(cate);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/tag")
  public ResponseType<Object> createArea(@RequestBody Tag tag){
    if(new EmptyJudge().judgeEmpty(tag.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"影视标签名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      tag.setId(id.toString());
      movieService.createTag(tag);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @LoginAuth
  @PostMapping("/")
  public ResponseType<Object> createMovie(@RequestBody MovieDTO movie){
    if(new EmptyJudge().judgeEmpty(movie.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getDirectorList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "导演不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getScreenwriterList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getAreaList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "地区不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getLanguage())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "语言不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getReleaseTime())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "上映时间不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getDuration())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "时长不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getFormItem())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影形式不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getActorList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getCateList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "分类不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movie.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影简介不能为空",null);
    }else{
      Long id=new Date().getTime();
      movie.setId(id.toString());
      movieService.createMovie(movie);
      for(String dId : movie.getDirectorList()){
        movieService.setDirectorForMovie(id.toString(),dId);
      }
      for(String aId :movie.getAreaList()){
        movieService.setAreaForMovie(id.toString(),aId);
      }
      for(String sId :movie.getScreenwriterList()){
        movieService.setScreenwriterForMovie(id.toString(),sId);
      }
      for(String aId:movie.getActorList()){
        movieService.setActorForMovie(id.toString(),aId);
      }
      for(String cId:movie.getCateList()){
        movieService.setCateForMovie(id.toString(),cId);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), movie);
    }
  }
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Movie>>> getAllMovie(@RequestParam("page") Integer page,
                                                           @RequestParam("limit") Integer limit,
                                                           @RequestParam(value="keyword",required = false) String keyword,
                                                           @RequestParam(value = "form",required = false) String form,
                                                           @RequestParam(value = "cate",required = false) String cateId,
                                                           @RequestParam(value = "area",required = false) String areaId){
    Page<Movie> movies=movieService.getAllMovie(page,limit,form,cateId,keyword,areaId);
    PageResult pageResult=new PageResult<List<Movie>>(movies.getPageNum(),
                                                      movies.getTotal(),
                                                      movies.getPages(),
                                                      movies);
    return new ResponseType<PageResult<List<Movie>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
  //获取所有地区
  @LoginAuth
  @GetMapping("/area/all")
  public ResponseType<List<Area>> getAllArea(){
    List<Area> areas=movieService.getAllArea();
    return new ResponseType<List<Area>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), areas);
  }
  //获取所有类型
  @LoginAuth
  @GetMapping("/cate/all")
  public ResponseType<List<Category>> getAllCate(){
    List<Category> categories=movieService.getAllCate();
    return new ResponseType<List<Category>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), categories);
  }
  //获取所有形式
  @LoginAuth
  @GetMapping("/form/all")
  public ResponseType<List<Form>> getAllForm(){
    List<Form> forms= movieService.getAllForm();
    return new ResponseType<List<Form>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(),forms );
  }
  //更新电影信息
  @LoginAuth
  @PostMapping("/update")
  public ResponseType<Object> updateMovie(@RequestBody MovieDTO movieDTO){
    if(new EmptyJudge().judgeEmpty(movieDTO.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影id不能为空",null);
    } else if(new EmptyJudge().judgeEmpty(movieDTO.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getDirectorList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "导演不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getScreenwriterList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "编剧不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getAreaList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影地区不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getActorList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "演员不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getLanguage())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影语言不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getReleaseTime())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影上映时间不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getDuration())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影时长不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getFormItem())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影形式不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getCateList())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影分类不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(movieDTO.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "电影简介不能为空",null);
    }else{
      movieService.deleteMovieActor(movieDTO.getId());
      movieService.deleteMovieArea(movieDTO.getId());
      movieService.deleteMovieCate(movieDTO.getId());
      movieService.deleteMovieScreen(movieDTO.getId());
      movieService.deleteMovieDirector(movieDTO.getId());
      for(String dId : movieDTO.getDirectorList()){
        movieService.setDirectorForMovie(movieDTO.getId(),dId);
      }
      for(String aId :movieDTO.getAreaList()){
        movieService.setAreaForMovie(movieDTO.getId(),aId);
      }
      for(String sId :movieDTO.getScreenwriterList()){
        movieService.setScreenwriterForMovie(movieDTO.getId(),sId);
      }
      for(String aId:movieDTO.getActorList()){
        movieService.setActorForMovie(movieDTO.getId(),aId);
      }
      for(String cId:movieDTO.getCateList()){
        movieService.setCateForMovie(movieDTO.getId(),cId);
      }
      movieService.updateMovie(movieDTO);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //上传电影封面
  @LoginAuth
  @PostMapping("/cover/upload/{id}")
  public ResponseType<Object> uploadAvatar(@PathVariable("id") String id,
                                           @RequestBody MultipartFile cover){
    if(new EmptyJudge().judgeEmpty(cover)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), ErrorType.FILE_CANNOT_BE_EMPTY.getErrorMsg(), null);
    }else{
      String filename=new FileUniqueName().getFileUniqueName(cover.getOriginalFilename());
      String coverUrl= Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/movie/cover/"+id;
      Movie movie=new Movie();
      movie.setId(id);
      movie.setCoverUrl(coverUrl);
      movie.setOriginalname(cover.getOriginalFilename());
      movie.setFilename(filename);
      movie.setMimetype(cover.getContentType());
      movie.setDest(UploadPath.MOVIE_COVER_UPLOAD_PATH.getUPLOADPATH());
      movie.setSize(cover.getSize());
      movieService.uploadCover(movie);
      try {
        cover.transferTo(new File(System.getProperty("user.dir")+UploadPath.MOVIE_COVER_UPLOAD_PATH.getUPLOADPATH()+filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), "封面上传成功",null);
    }
  }
  @GetMapping("/cover/{id}")
  public ResponseEntity<byte[]> getMovieCover(@PathVariable("id") String id){
    Movie movie= movieService.getMovieById(id);
    return new FilePreview().getFilePreview(System.getProperty("user.dir")+movie.getDest()+"/"+movie.getFilename(),movie.getMimetype());
  }
  @LoginAuth
  @PostMapping("/cover/update/{id}")
  public ResponseType<Object> updateCover(@PathVariable("id") String id,
                                          @RequestBody MultipartFile cover){
    if(new EmptyJudge().judgeEmpty(cover)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "封面不能为空",null);
    }else{
      Movie movie= movieService.getMovieById(id);
      File file=new File(System.getProperty("user.dir")+movie.getDest()+movie.getFilename());
      if(file.exists()){
        boolean isDelete = file.delete();
        this.uploadAvatar(id,cover);
      }else{
        this.uploadAvatar(id,cover);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), "头像更新成功",null);
    }
  }
  @LoginAuth
  @PostMapping("/delete/{id}")
  public ResponseType<Object> deleteMovie(@PathVariable("id") String id){
    Movie movie= movieService.getMovieById(id);
    File file=new File(System.getProperty("user.dir")+movie.getDest()+movie.getFilename());
    if(file.exists()){
      boolean isDelete=file.delete();
    }
    movieService.deleteMovie(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), "电影删除成功",null);
  }
  @LoginAuth
  @GetMapping("/director/{id}")
  public ResponseType<PageResult<List<Movie>>> getMovieByDid(@PathVariable("id") String id,
                                                             @RequestParam("page") Integer page,
                                                             @RequestParam("limit")Integer limit){
    Page<Movie> movies= movieService.getMovieByDid(id, page, limit);
    PageResult pageResult=new PageResult<List<Movie>>(movies.getPageNum(),
            movies.getTotal(),
            movies.getPages(),movies);
    return new ResponseType<PageResult<List<Movie>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
}
