package com.codergb.service.awards;

import com.codergb.bean.Awards;
import com.codergb.mapper.awards.AwardsMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardsService {
  @Autowired
  AwardsMapper awardsMapper;
  public int createAwards(Awards awards){
    return awardsMapper.createAwards(awards);
  }
  //获取所有奖项
  public Page<Awards> getAllAwards(Integer page,Integer limit, String keyword){
    Page<Awards> p=PageHelper.startPage(page,limit);
    awardsMapper.getAllAwards(page,limit,keyword);
    return p;
  }
  //更新奖项信息
  public int updateAwards(Awards awards){
    return awardsMapper.updateAwards(awards);
  }
  //上传奖项封面信息
  public int uploadCover(Awards awards){
    return awardsMapper.uploadCover(awards);
  }
  public Awards getAwardsById(String id){
    return awardsMapper.getAwardsById(id);
  }
  //删除奖项信息
  public int deleteAwards(String id){
    return awardsMapper.deleteAwards(id);
  }
}
