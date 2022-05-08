package com.codergb.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileToString {
  private String filePath;
  public ReadFileToString(String path) {
    this.filePath = path;
  }
  public String readFile(){
    StringBuilder contentBuilder=new StringBuilder();
    try {
      Stream<String> stream= Files.lines(Paths.get(this.filePath), StandardCharsets.UTF_8);
      stream.forEach(s->contentBuilder.append(s).append("\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return contentBuilder.toString();
  }
}
