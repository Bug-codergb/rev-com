package com.codergb.bean;

import lombok.*;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Awards extends FileInfo{
  private String id;
  private String name;
  private String coverUrl;
  private String area;
  private Date established;
  private String description;
  private String alias;
}
