package com.codergb.controller.book;

import com.codergb.annotation.LoginAuth;
import com.codergb.bean.PageResult;
import com.codergb.bean.book.Book;
import com.codergb.constant.Host;
import com.codergb.constant.ResponseMessage;
import com.codergb.constant.UploadPath;
import com.codergb.dto.book.BookDTO;
import com.codergb.service.book.BookService;
import com.codergb.utils.EmptyJudge;
import com.codergb.utils.FilePreview;
import com.codergb.utils.FileUniqueName;
import com.codergb.utils.ResponseType;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
  @LoginAuth
  @PostMapping("/cover/upload/{id}")
  public ResponseType<Object> uploadCover(@RequestBody MultipartFile cover,
                                          @PathVariable("id") String id){
    if(new EmptyJudge().judgeEmpty(cover)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"书籍封面不能为空",null);
    }else{
      Book book=new Book();
      book.setId(id);
      String filename=new FileUniqueName().getFileUniqueName(cover.getOriginalFilename());
      book.setOriginalname(cover.getOriginalFilename());
      book.setFilename(filename);
      book.setMimetype(cover.getContentType());
      book.setSize(cover.getSize());
      book.setDest(UploadPath.BOOK_COVER_UPLOAD_PATH.getUPLOADPATH());
      book.setCoverUrl(Host.HOST_NAME.getHOST()+":"+Host.HOST_PORT.getHOST()+"/book/cover/"+id);
      try {
        cover.transferTo(new File(System.getProperty("user.dir")+UploadPath.BOOK_COVER_UPLOAD_PATH.getUPLOADPATH()+filename));
        bookService.uploadCover(book);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  @GetMapping("/cover/{id}")
  public ResponseEntity<byte[]> getBookCover(@PathVariable("id") String id){
    Book book= bookService.getBookById(id);
    return new FilePreview().getFilePreview(System.getProperty("user.dir")+book.getDest()+book.getFilename(),book.getMimetype());
  }
  @PostMapping("/delete/{id}")
  public ResponseType<Object> deleteBook(@PathVariable("id") String id){
    Book book= bookService.getBookById(id);
    File file=new File(System.getProperty("user.dir")+book.getDest()+book.getFilename());
    if(file.exists()){
      boolean isDelete = file.delete();
    }
    bookService.deleteBook(id);
    return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
  }
  //更新书籍信息
  @LoginAuth
  @PostMapping("/update")
  public ResponseType<Object> updateBook(@RequestBody BookDTO book){
    if(new EmptyJudge().judgeEmpty(book.getId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"书籍ID不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getName())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍名称不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getWriterId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍作者不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPublishTime())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍出版时间不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPublishId())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍出版社不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getDescription())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"书籍简介不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPrice())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍价格不能为空",null);
    }else if(new EmptyJudge().judgeEmpty(book.getPageCount())){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(), "书籍页数不能为空",null);
    }else{
      bookService.updateBook(book);
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //更新封面信息
  @LoginAuth
  @PostMapping("/cover/update/{id}")
  public ResponseType<Object> updateCover(@PathVariable("id") String id,
                                          @RequestBody MultipartFile cover){
    if(new EmptyJudge().judgeEmpty(cover)){
      return new ResponseType<Object>(HttpStatus.BAD_REQUEST.value(),"头像不能为空",null);
    }else{
      Book book= bookService.getBookById(id);
      File file=new File(System.getProperty("user.dir")+book.getDest()+book.getFilename());
      if(file.exists()){
        Boolean isDelete=file.delete();
        this.uploadCover(cover,id);
      }else{
        this.uploadCover(cover, id);
      }
      return new ResponseType<Object>(HttpStatus.OK.value(), ResponseMessage.SUCCESS.getMESSAGE(), null);
    }
  }
  //获取所有书籍
  @LoginAuth
  @GetMapping("/all")
  public ResponseType<PageResult<List<Book>>> getAllBook(@RequestParam("page") Integer page,
                                                         @RequestParam("limit") Integer limit){
    Page<Book> books=bookService.getAllPage(page,limit);
    PageResult pageResult=new PageResult<List<Book>>(books.getPageNum(),
            books.getTotal(),
            books.getPages(),books);
    return new ResponseType<PageResult<List<Book>>>(HttpStatus.OK.value(),ResponseMessage.SUCCESS.getMESSAGE(), pageResult);
  }
}
