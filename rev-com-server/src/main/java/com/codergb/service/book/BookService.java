package com.codergb.service.book;

import com.codergb.bean.book.Book;
import com.codergb.dto.book.BookDTO;
import com.codergb.mapper.book.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  BookMapper bookMapper;
  public int createBook(BookDTO book){
    return bookMapper.createBook(book);
  }
  public int uploadCover(Book book){
    return bookMapper.uploadCover(book);
  }
  //获取书籍根据ID
  public Book getBookById(String id){
    return bookMapper.getBookById(id);
  }
  //删除书籍
  public int deleteBook(String id){
    return bookMapper.deleteBook(id);
  }
  //更新下书籍信息
  public int updateBook(BookDTO bookDTO){
    return bookMapper.updateBook(bookDTO);
  }
}
