package com.codergb.controller;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.User;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.service.UserService;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserService userService;

  @LoginAuth
  @PostMapping("/avatar/upload")
  public ResponseType<Object> uploadAvatar(@RequestAttribute("userId") String userId,
                                           @RequestBody MultipartFile avatar){
    String filename=new FileUniqueName().getFileUniqueName(avatar.getOriginalFilename());
    String avatarUrl= Host.HOST_NAME.getHOST()+":"+ Host.HOST_PORT.getHOST()+"/user/avatar/"+userId;
    User user=new User();
    user.setDest(UploadPath.AVATAR_UPLOAD_PATH.getUPLOADPATH());
    user.setOriginalname(avatar.getOriginalFilename());
    user.setMimetype(avatar.getContentType());
    user.setUserId(userId);
    user.setSize(avatar.getSize());
    user.setFilename(filename);
    user.setAvatarUrl(avatarUrl);
    try {
      userService.uploadAvatar(user);
      avatar.transferTo(new File(UploadPath.AVATAR_UPLOAD_PATH.getUPLOADPATH()+filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
  }
  @GetMapping("/avatar/{id}")
  public ResponseEntity<byte[]> getUserAvatar(@PathVariable("id") String id){
    User user=userService.getUserById(id);
    return new FilePreview().getFilePreview(user.getDest()+"/"+user.getFilename(),user.getMimetype());
  }
}
