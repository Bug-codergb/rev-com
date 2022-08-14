package com.codergb.controller.awards;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.Awards;
import com.codergb.bean.PageResult;
import com.codergb.bean.book.Book;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.service.awards.AwardsService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/awards")
public class AwardsController {
  @Autowired
  AwardsService awardsService;
  //创建奖项
  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> createAwards(@RequestBody Awards awards){
    if(new EmptyJudge().judgeEmpty(awards.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getArea())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项地区不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getEstablished())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项成立时间不能为空",null);
    }else{
      Long id=new Date().getTime();
      awards.setId(id.toString());
      awardsService.createAwards(awards);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), awards);
    }
  }
  //获取所有奖项2
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Awards>>> getAllAwards(@RequestParam("page") Integer page,
                                                             @RequestParam("limit") Integer limit,
                                                             @RequestParam(value = "keyword",required = false) String keyword){
    Page<Awards> awards=awardsService.getAllAwards(page, limit, keyword);
    PageResult pageResult=new PageResult<List<Awards>>(awards.getPageNum(),
            awards.getTotal(),
            awards.getPages(),awards);
    return new ResponseType<PageResult<List<Awards>>>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
  //更新奖项信息
  @LoginAuth
  @PostMapping("/update")
  public ResponseType<Object> updateAwards(@RequestBody Awards awards){
    if(new EmptyJudge().judgeEmpty(awards.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项ID不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getArea())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项地区不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getAlias())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项别名不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(awards.getEstablished())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "奖项成立时间不能为空",null);
    }else{
      awardsService.updateAwards(awards);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //上传奖项封面 信息
  @LoginAuth
  @PostMapping("/cover/upload/{id}")
  public ResponseType<Object> uploadCover(@RequestBody MultipartFile cover,
                                          @PathVariable("id") String id){
   if(new EmptyJudge().judgeEmpty(cover)){
     return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"封面不能为空",null);
   }else{
     Awards awards=new Awards();
     String filename=new FileUniqueName().getFileUniqueName(cover.getOriginalFilename());
     String coverUrl= Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/awards/cover/"+id;
     awards.setId(id);
     awards.setOriginalname(cover.getOriginalFilename());
     awards.setFilename(filename);
     awards.setMimetype(cover.getContentType());
     awards.setSize(cover.getSize());
     awards.setDest(UploadPath.AWARDS_COVER_UPLOAD_PATH.getUPLOADPATH());
     awards.setCoverUrl(coverUrl);
     try {
       cover.transferTo(new File( System.getProperty("user.dir")+UploadPath.AWARDS_COVER_UPLOAD_PATH.getUPLOADPATH()+filename ));
     } catch (IOException e) {
       e.printStackTrace();
     }
     awardsService.uploadCover(awards);
     return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
   }
  }
  //获取封面信息
  @GetMapping("/cover/{id}")
  public ResponseEntity<byte []> getCover(@PathVariable("id") String id){
    Awards awards=awardsService.getAwardsById(id);
    return new FilePreview().getFilePreview(System.getProperty("user.dir")+awards.getDest()+"/"+awards.getFilename(),awards.getMimetype());
  }
  //更新封面信息
  @PostMapping("/cover/update/{id}")
  public ResponseType<Object> updateCover(@PathVariable("id") String id,
                                          @RequestBody MultipartFile cover){
    if(new EmptyJudge().judgeEmpty(cover)){
      return new ResponseType<Object>(HttpStatus.OK.value(), "头像不能为空",null);
    }else{
      Awards awards=awardsService.getAwardsById(id);
      File file=new File(System.getProperty("user.dir")+awards.getDest()+awards.getFilename());
      if(file.exists()){
        file.delete();
        this.uploadCover(cover,id);
      }else{
        this.uploadCover(cover, id);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //删除奖项信息
  @LoginAuth
  @PostMapping("/delete/{id}")
  public ResponseType<Object> deleteAwards(@PathVariable("id") String id){
    Awards awards=awardsService.getAwardsById(id);
    File file=new File(System.getProperty("user.dir")+awards.getDest()+awards.getFilename());
    if(file.exists()){
      boolean isDelete=file.delete();
    }
    awardsService.deleteAwards(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
  }
}
