package com.codergb.service.book;

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
}
