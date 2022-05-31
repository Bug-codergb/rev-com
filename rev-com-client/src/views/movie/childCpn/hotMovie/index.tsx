import React,{memo,FC,ReactElement} from "react";
import {
  HotMovieWrapper,
  LeftContent,
  RightContent
}from "./style";
const HotMovie:FC=():ReactElement=>{
  return (
    <HotMovieWrapper className="center-auto">
      热门电影
    </HotMovieWrapper>
  )
}
export default memo(HotMovie);
