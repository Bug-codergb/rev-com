import React,{memo,FC,ReactElement} from "react";
import {
  HotMovieWrapper
}from "./style";
const HotMovie:FC=():ReactElement=>{
  return (
    <HotMovieWrapper>
      热门电影
    </HotMovieWrapper>
  )
}
export default memo(HotMovie);
