package com.codergb.mapper.music.artist;

import com.codergb.bean.music.artist.ArtistType;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ArtistTypeMapper {
  public int createArtistType(ArtistType artistType);
  public ArtistType getArtistTypeById(@Param("id") String id);
  public List<ArtistType> getAllArtistType();
}
