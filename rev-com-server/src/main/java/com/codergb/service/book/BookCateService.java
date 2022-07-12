package com.codergb.service.book;

import com.codergb.bean.book.BookCate;
import com.codergb.bean.book.BookCateCh;
import com.codergb.mapper.book.BookCateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCateService {
  @Autowired
  BookCateMapper bookCateMapper;
  public int createBookCate(BookCate bookCate){
    return bookCateMapper.createBookCate(bookCate);
  }
  public int deleteBookCate(String id){
    return bookCateMapper.deleteBookCate(id);
  }
  //获取所有分类信息
  public List<BookCate> getAllBookCate(){
    return bookCateMapper.getAllBookCate();
  }
  //添加分类子分类
  public int createBookCateCh(BookCateCh bookCateCh){
    return bookCateMapper.createCateCh(bookCateCh);
  }
  //获取所有分类（包含子分类）
  public List<BookCate> getAllCateDetail(){
    return bookCateMapper.getAllCateDetail();
  }
  //删除分类子分类
  public int deleteCateCh(String id){
    return bookCateMapper.deleteCateCh(id);
  }
}
