package com.codergb.bean.book;

import com.codergb.bean.FileInfo;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Publish extends FileInfo {
  private String id;
  private String name;
  private String foreignName;
  private String logoUrl;
  private String representative;
  private String industry;
  private Date establish;
  private String online;
  private String organizer;
  private String description;
  private String type;
}
