package com.codergb.mapper;

import com.codergb.bean.movie.*;

public interface MovieMapper {
  public int createForm(Form form);
  public int createArea(Area area);
  public int createCate(Category category);
  public int createTag(Tag tag);
  public int createMovie(Movie movie);
}
