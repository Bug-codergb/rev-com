package com.codergb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.codergb.mapper")
@SpringBootApplication
public class MainApplication {
  public static void main(String[] args) {
    ConfigurableApplicationContext run= SpringApplication.run(MainApplication.class,args);
    System.out.println(System.getProperty("user.dir"));
  }
}
