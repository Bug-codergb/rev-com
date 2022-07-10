package com.codergb.mapper.book;

import com.codergb.bean.book.Book;
import com.codergb.dto.book.BookDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
  //添加书籍
  public int createBook(BookDTO book);
  //上传书籍封面
  public int uploadCover(Book book);
  //获取书籍根据ID
  public Book getBookById(@Param("id") String id);
  //删除书籍
  public int deleteBook(@Param("id") String id);
  //更新书籍信息
  public int updateBook(BookDTO book);
  //获取所有书籍
  public List<Book> getAllBook(@Param("page") Integer page,@Param("limit") Integer limit);
}
