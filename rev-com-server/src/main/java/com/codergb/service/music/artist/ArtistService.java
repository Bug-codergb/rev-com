package com.codergb.service.music.artist;

import com.codergb.bean.music.artist.Artist;
import com.codergb.dto.music.artist.ArtistDTO;
import com.codergb.mapper.music.artist.ArtistMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
  @Autowired
  ArtistMapper artistMapper;
  public int createArtist(ArtistDTO artist){
    return artistMapper.createArtist(artist);
  }
  public Page<Artist> getAllArtist(String keyword, String area, String type, Integer page, Integer limit){
    Page<Artist> artists= PageHelper.startPage(page,limit);
    artistMapper.getAllArtist(keyword, area, type, page, limit);
    return artists;
  }
  public int uploadAvatar(Artist artist){
    return artistMapper.uploadAvatar(artist);
  }
  public Artist getArtistById(String id){
    return artistMapper.getArtistById(id);
  }
  public int updateArtist(ArtistDTO artist){
    return artistMapper.updateArtist(artist);
  }
  public int deleteArtist(String id){
    return artistMapper.deleteArtist(id);
  }
  public int updateAvatar(Artist artist){
    return artistMapper.updateAvatar(artist);
  }
}
