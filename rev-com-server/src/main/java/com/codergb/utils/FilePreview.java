package com.codergb.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FilePreview {
  public ResponseEntity<byte[]> getFilePreview(String filePath,String mimetype){
    InputStream is= null;
    ResponseEntity<byte[]> responseEntity=null;
    try {
      is = new FileInputStream(filePath);
      byte[] bytes=new byte[is.available()];
      is.read(bytes);
      MultiValueMap<String ,String> headers=new HttpHeaders();
      headers.add("Content-type",mimetype);
      responseEntity=new ResponseEntity<>(bytes,headers, HttpStatus.OK);
      is.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return responseEntity;
  }
}
