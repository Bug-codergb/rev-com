package com.codergb.mapper.book;

import com.codergb.dto.book.BookDTO;

public interface BookMapper {
  //添加书籍
  public int createBook(BookDTO book);
}
