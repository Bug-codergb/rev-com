package com.codergb.service.music.artist;

import com.codergb.bean.music.artist.ArtistCate;
import com.codergb.mapper.music.artist.ArtistCateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistCateService {
  @Autowired
  ArtistCateMapper artistCateMapper;
  public int createArtistCate(ArtistCate artistCate){
    return artistCateMapper.createArtistCate(artistCate);
  }
  public List<ArtistCate> getAllArtistCate(){
    return artistCateMapper.getAllArtistCate();
  }
  public ArtistCate getArtistCateById(String id){
    return artistCateMapper.getArtistCateById(id);
  }
}
