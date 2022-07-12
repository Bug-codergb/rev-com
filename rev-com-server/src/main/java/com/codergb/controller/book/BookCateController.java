package com.codergb.controller.book;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.book.BookCate;
import com.codergb.constant.ResponseMessage;
import com.codergb.dto.book.BookCateChDTO;
import com.codergb.service.book.BookCateService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.ResponseType;
import org.apache.ibatis.ognl.ObjectElementsAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book/cate")
public class BookCateController {
  @Autowired
  BookCateService bookCateService;
  //添加书籍分类
  @LoginAuth
  @PostMapping("")
  public ResponseType<Object> createBookCate(@RequestBody BookCate bookCate){
    if(new EmptyJudge().judgeEmpty(bookCate.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍分类名称不能为空",null);
    }else{
      Long id=new Date().getTime();
      bookCate.setId(id.toString());
      bookCateService.createBookCate(bookCate);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //删除书籍分类
  @LoginAuth
  @PostMapping("/delete/{id}")
  public ResponseType<Object> deleteBookCate(@PathVariable("id") String id){
    bookCateService.deleteBookCate(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
  }
  //获取书籍分类
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<Object> getAllBookCate(){
    List<BookCate> bookCate=bookCateService.getAllBookCate();
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(),bookCate );
  }
  //添加分类子分类
  @LoginAuth
  @PostMapping("/ch")
  public ResponseType<Object> createBookCateCh(@RequestBody BookCateChDTO bookCateCh){
    if(new EmptyJudge().judgeEmpty(bookCateCh.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "子分类名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(bookCateCh.getCateId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "分类ID不能为空",null);
    }else{
      Long id=new Date().getTime();
      bookCateCh.setId(id.toString());
      bookCateService.createBookCateCh(bookCateCh);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //获取所有分类（包含子分类）
  @LoginAuth
  @GetMapping("/detail/all")
  public ResponseType<Object> getAllCateDetail(){
    List<BookCate> bookCateList=bookCateService.getAllCateDetail();
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), bookCateList);
  }
  //删除分类子分类
  @LoginAuth
  @PostMapping("/ch/delete/{id}")
  public ResponseType<Object> deleteCateCh(@PathVariable("id") String id){
    bookCateService.deleteCateCh(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
  }
}
