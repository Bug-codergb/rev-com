import React,{memo,FC,ReactElement} from "react";
import {
  HotMovieWrapper,
  LeftContent,
  RightContent
}from "./style";

import HotTV from "./childCpn/hotTv";
import  HotRecentMovie from "./childCpn/hotMovie";
import HotReview from "./childCpn/hotReview";
import WeekToplist from "./childCpn/weekToplist";
const HotMovie:FC=():ReactElement=>{
  return (
    <HotMovieWrapper className="center-auto">
      <LeftContent>
        <HotRecentMovie/>
        <div className="line"> </div>
        <HotTV/>
        <div className="line"> </div>
        <HotReview/>
      </LeftContent>
      <RightContent>
        <WeekToplist/>
      </RightContent>
    </HotMovieWrapper>
  )
}
export default memo(HotMovie);
