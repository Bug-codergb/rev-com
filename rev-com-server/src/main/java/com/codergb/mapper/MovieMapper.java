package com.codergb.mapper;

import com.codergb.bean.movie.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {
  public int createForm(Form form);
  public int createArea(Area area);
  public int createCate(Category category);
  public int createTag(Tag tag);
  public int createMovie(Movie movie);
  public int setDirectorForMovie(@Param("mId") String mId,@Param("dId") String dId); //为电影添加导演
  public int setAreaForMovie(@Param("mId") String mId,@Param("aId") String aId);  //为电影添加地区
  public int setScreenwriterForMovie(@Param("mId") String mId,@Param("sId") String sId); //为电影添加编剧
  public int setActorForMovie(@Param("mId") String mId,@Param("aId") String aId);    //为电影添加演员
  public int setCateForMovie(@Param("mId") String mId,@Param("cId") String cId); //为电影添加分类
  public List<Movie> getAllMovie(@Param("page") Integer page,@Param("limit") Integer limit); //获取所有电影
  //获取导演列表根据电影
  public List<Director> getDirectorByMid(@Param("mId") String mId);
  public List<Screenwriter> getScreenwriterByMid(@Param("mId") String mId); //获取编剧列表根据电影
  public List<Area> getAreaByMid(@Param("mId") String mId); // 获取地区根据电影
  public List<Actor> getActorByMid(@Param("mId") String mId); //获取演员根据电影
  public List<Category> getCateByMid(@Param("mId") String mId); //获取分类根据电影
  public Form getFormByMid(@Param("id") String id);//获取电影形式
  //获取所有地区
  public List<Area> getAllArea();
  //获取所有分类
  public List<Category> getAllCate();
  //获取所有形式
  public List<Form> getAllForm();
}
