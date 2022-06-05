import React,{memo,FC,ReactElement} from "react";
import {
  HotMovieWrapper,
  LeftContent,
  RightContent
}from "./style";

import HotTV from "./childCpn/hotTv";
import  HotRecentMovie from "./childCpn/hotMovie";
const HotMovie:FC=():ReactElement=>{
  return (
    <HotMovieWrapper className="center-auto">
      <LeftContent>
        <HotRecentMovie/>
        <div className="line"> </div>
        <HotTV/>
      </LeftContent>
      <RightContent>

      </RightContent>
    </HotMovieWrapper>
  )
}
export default memo(HotMovie);
