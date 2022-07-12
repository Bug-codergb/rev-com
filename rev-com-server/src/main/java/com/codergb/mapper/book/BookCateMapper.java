package com.codergb.mapper.book;

import com.codergb.bean.book.BookCate;
import com.codergb.bean.book.BookCateCh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookCateMapper {
  public int createBookCate(BookCate bookCate);
  //删除书籍分类信息
  public int deleteBookCate(@Param("id") String id);
  //获取所有分类信息
  public List<BookCate> getAllBookCate();
  //添加子分类
  public int createCateCh(BookCateCh bookCateCh);
  //获取所有分类（包含子分类）
  public List<BookCate> getAllCateDetail();
  //获取子分类根据分类ID
  public List<BookCateCh> getCateChByCId(@Param("cId") String cId);
  //删除子分类
  public int deleteCateCh(@Param("id") String id);
}
