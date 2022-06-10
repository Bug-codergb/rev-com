package com.codergb.bean.music.artist;

import com.codergb.bean.FileInfo;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Artist extends FileInfo {
  private String id;
  private String name;
  private String description;
  private String avatarUrl;
  private ArtistCate area;
  private ArtistType type;
  private Date createTime;
  private Date updateTime;
}
