package com.codergb.mapper.music.artist;

import com.codergb.bean.music.artist.Artist;
import com.codergb.dto.music.artist.ArtistDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArtistMapper {
  public int createArtist(ArtistDTO artist);
  //获取所有歌手
  public List<Artist> getAllArtist(@Param("keyword") String keyword, @Param("area") String area,
                                   @Param("type") String type, @Param("page") Integer page,
                                   @Param("limit") Integer limit);
  //上传歌手头像
  public int uploadAvatar(Artist artist);
  //获取歌手
  public Artist getArtistById(@Param("id") String id);
  //更新歌手信息
  public int updateArtist(ArtistDTO artist);
  //删除歌手信息
  public int deleteArtist(@Param("id") String id);
  //更新歌手头像信息
  public int updateAvatar(Artist artist);
}
