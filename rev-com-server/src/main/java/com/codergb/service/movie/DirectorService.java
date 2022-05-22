package com.codergb.service.movie;

import com.codergb.bean.movie.Director;
import com.codergb.dto.movie.DirectorDTO;
import com.codergb.mapper.movie.DirectorMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
  @Autowired
  DirectorMapper directorMapper;
  public int createDirector(Director director){
    return directorMapper.createDirector(director);
  }
  public Page<Director> getAllDirector(int page,int limit,String keyword){
    Page<Director> p= PageHelper.startPage(page,limit);
    List<Director> directors=directorMapper.getAllDirect(page,limit,keyword);
    return p;
  }
  public int uploadAvatar(Director director){
    return directorMapper.uploadAvatar(director);
  }
  public Director getDirectorById(String id){
    return directorMapper.getDirectorById(id);
  }
  public int updateDirector(DirectorDTO directorDTO){
    return directorMapper.updateDirector(directorDTO);
  }
  public int deleteDirector(String id){
    return directorMapper.deleteDirector(id);
  }
  public Page<Director> getDirectorCooperate(String id,Integer page,Integer limit){
    Page<Director> p=PageHelper.startPage(page,limit);
    List<Director> directors=directorMapper.getDirectorCooperate(id,page,limit);
    return p;
  }
  //获取演员合作导演
  public Page<Director> getActorCooperateDir(String id,Integer page, Integer limit){
    Page<Director> p=PageHelper.startPage(page,limit);
    List<Director> directors=directorMapper.getActorCooperateDir(id,page,limit);
    return p;
  }
}
