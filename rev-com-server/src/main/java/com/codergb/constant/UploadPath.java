package com.codergb.constant;

public enum UploadPath {
  AVATAR_UPLOAD_PATH("./upload/avatar/"),
  DIRECTOR_AVATAR_UPLOAD_PATH("./upload/director/avatar/"),
  MOVIE_COVER_UPLOAD_PATH("./upload/movie/cover/"),
  ACTOR_AVATAR_UPLOAD_PATH("./upload/actor/avatar/"),
  SCREENWRITER_AVATAR_UPLOAD_PATH("./upload/screenwriter/avatar/"),
  COMMENT_PICTURE_UPLOAD_PATH("./upload/comment/picture/"),
  ARTIST_AVATAR_UPLOAD_PATH("./upload/music/artist/avatar/"),
  FILMLIST_COVER_UPLOAD_PATH("./upload/movie/filmList/"),
  BOOK_COVER_UPLOAD_PATH("./upload/book/cover/");
  private final String UPLOADPATH;
  UploadPath(String UPLOADPATH) {
    this.UPLOADPATH = UPLOADPATH;
  }

  public String getUPLOADPATH() {
    return UPLOADPATH;
  }
}
