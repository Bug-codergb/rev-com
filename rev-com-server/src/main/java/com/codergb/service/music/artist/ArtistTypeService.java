package com.codergb.service.music.artist;

import com.codergb.bean.music.artist.ArtistType;
import com.codergb.mapper.music.artist.ArtistTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistTypeService {
  @Autowired
  ArtistTypeMapper artistTypeMapper;
  public int createArtistCate(ArtistType artistType){
    return artistTypeMapper.createArtistType(artistType);
  }
  public ArtistType getArtistTypeById(String id){
    return artistTypeMapper.getArtistTypeById(id);
  }
  public List<ArtistType> getAllArtistType(){
    return artistTypeMapper.getAllArtistType();
  }
}
