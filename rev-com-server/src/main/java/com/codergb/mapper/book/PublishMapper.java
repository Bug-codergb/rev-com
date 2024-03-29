package com.codergb.mapper.book;

import com.codergb.bean.book.Publish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishMapper {
  public int createPublish(Publish publish);
  public List<Publish> getAllPublish(@Param("page") Integer page, @Param("limit") Integer limit,@Param("keyword") String keyword);
  public Publish getPublishById(@Param("id") String id);
}
