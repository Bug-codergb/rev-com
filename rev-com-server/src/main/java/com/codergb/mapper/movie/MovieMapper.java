package com.codergb.mapper.movie;

import com.codergb.bean.movie.*;
import com.codergb.dto.movie.DirectorDTO;
import com.codergb.dto.movie.MovieDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {
  public int createForm(Form form);
  public int createArea(Area area);
  public int createCate(Category category);
  public int createTag(Tag tag);
  public int createMovie(MovieDTO movie);
  public int setDirectorForMovie(@Param("mId") String mId,@Param("dId") String dId); //为电影添加导演
  public int setAreaForMovie(@Param("mId") String mId,@Param("aId") String aId);  //为电影添加地区
  public int setScreenwriterForMovie(@Param("mId") String mId,@Param("sId") String sId); //为电影添加编剧
  public int setActorForMovie(@Param("mId") String mId,@Param("aId") String aId);    //为电影添加演员
  public int setCateForMovie(@Param("mId") String mId,@Param("cId") String cId); //为电影添加分类
  public List<Movie> getAllMovie(@Param("page") Integer page,
                                 @Param("limit") Integer limit,
                                 @Param("form") String form,
                                 @Param("cateId") String cateId,
                                 @Param("keyword") String keyword,
                                 @Param("areaId") String areaId); //获取所有电影
  //获取导演列表根据电影
  public List<Director> getDirectorByMid(@Param("mId") String mId);
  public List<Screenwriter> getScreenwriterByMid(@Param("mId") String mId); //获取编剧列表根据电影
  public List<Area> getAreaByMid(@Param("mId") String mId); // 获取地区根据电影
  public List<Actor> getActorByMid(@Param("mId") String mId); //获取演员根据电影
  public List<Category> getCateByMid(@Param("mId") String mId,@Param("cateId") String cateId); //获取分类根据电影
  public Form getFormByMid(@Param("id") String id);//获取电影形式
  //获取所有地区
  public List<Area> getAllArea();
  //获取所有分类
  public List<Category> getAllCate();
  //获取所有形式
  public List<Form> getAllForm();
  //删除电影导演
  public int deleteMovieDirector(@Param("mId") String mId);
  //删除电影编剧
  public int deleteMovieScreen(@Param("mId") String mId);
  //删除电影地区
  public int deleteMovieArea(@Param("mId") String mId);
  //删除电影演员
  public int deleteMovieActor(@Param("mId") String mId);
  //删除电影分类
  public int deleteMovieCate(@Param("mId") String mId);
  //更新电影信息
  public int updateMovie(Movie movie);
  //上传电影封面
  public int uploadCover(Movie movie);
  public Movie getMovieById(@Param("id") String id);
  //删除电影
  public int deleteMovie(@Param("id") String id);
  //获取电影通过导演
  public List<Movie> getMovieByDid(@Param("dId") String dId,@Param("page") Integer page,@Param("limit") Integer limit);
  //获取电影通过演员
  public List<Movie> getMovieByAid(@Param("aId") String aId,@Param("page") Integer page,@Param("limit") Integer limit);
}
