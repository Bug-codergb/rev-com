package com.codergb.mapper.music.artist;

import com.codergb.bean.music.artist.ArtistCate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArtistCateMapper {
  public int createArtistCate(ArtistCate artistCate);
  public List<ArtistCate> getAllArtistCate();
  public ArtistCate getArtistCateById(@Param("id") String id);
}
