package com.codergb.mapper.book;

import com.codergb.bean.book.Writer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WriterMapper {
  public int createWriter(Writer writer);
  public List<Writer> getAllWriter(@Param("page") Integer page,@Param("limit") Integer limit,@Param("keyword") String keyword);
}
