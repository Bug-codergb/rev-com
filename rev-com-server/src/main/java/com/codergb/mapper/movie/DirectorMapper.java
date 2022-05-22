package com.codergb.mapper.movie;

import com.codergb.bean.movie.Director;
import com.codergb.dto.movie.DirectorDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface DirectorMapper {
  public int createDirector(Director director);
  public List<Director> getAllDirect(int page,int limit,@Param("keyword") String keyword);
  public int uploadAvatar(Director director);
  public Director getDirectorById(@Param("id") String id);
  public int updateDirector(DirectorDTO directorDTO);
  public int deleteDirector(@Param("id") String id);
  //获取导演合作导演
  public List<Director> getDirectorCooperate(@Param("dId") String dId,
                                             @Param("page") Integer page,
                                             @Param("limit") Integer limit);
  //获取演员合作导演
  public List<Director> getActorCooperateDir(@Param("aId") String aId,
                                             @Param("page") Integer page,
                                             @Param("limit") Integer limit);

}
