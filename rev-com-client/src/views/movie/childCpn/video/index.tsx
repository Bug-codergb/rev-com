import React,{memo,FC,ReactElement} from "react";
import {
  VideoWrapper
}from "./style";
const Video:FC=():ReactElement=>{
  return (
    <VideoWrapper className="center-auto">
      发现影视
    </VideoWrapper>
  )
}
export default memo(Video);
