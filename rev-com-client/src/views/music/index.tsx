import React,{memo,FC,ReactElement} from "react";
import {
  MusicWrapper
}from "./style";
const Music:FC=():ReactElement=>{
  return (
    <MusicWrapper>
      音乐
    </MusicWrapper>
  )
}
export default memo(Music);
