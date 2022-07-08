package com.codergb.controller.book;

import com.codergb.annotation.LoginAuth;
import com.codergb.constant.ResponseMessage;
import com.codergb.dto.book.BookDTO;
import com.codergb.service.book.BookService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/book")
public class BookController {
  @Autowired
  BookService bookService;

  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> createBook(@RequestBody BookDTO book){
    if(new EmptyJudge().judgeEmpty(book.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getWriterId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍作者不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPublishTime())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍出版时间不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPublishId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍出版社不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPrice())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍价格不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPageCount())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍页数不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍简介不能为空",null);
    }else{
      Long id=new Date().getTime();
      book.setId(id.toString());
      bookService.createBook(book);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), book);
    }
  }
}
