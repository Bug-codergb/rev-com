package com.codergb.service;

import com.codergb.bean.User;
import com.codergb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;
  public int register(User user){
    return userMapper.register(user);
  }
  public User getUserByNamePass(String userName,String password){
    return userMapper.getUserByNamePass(userName,password);
  }
  public int uploadAvatar(User user){
    return userMapper.uploadAvatar(user);
  }
  public User getUserById(String userId){
    return userMapper.getUserById(userId);
  }
  public User getUserByName(String userName){
    return userMapper.getUserByName(userName);
  }
}
