package com.codergb.mapper.user;

import com.codergb.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
  public int register(User user);
  public User getUserByNamePass(@Param("userName") String userName,@Param("password") String password);
  public int uploadAvatar(User user);
  public User getUserById(@Param("userId") String userId);
  public User getUserByName(@Param("userName") String userName);
}
