import React,{memo,FC,ReactElement} from "react";
import {
  DirectorWrapper
}from "./style";
const Director:FC=():ReactElement=>{
  return (
    <DirectorWrapper className="center-auto">
      发现导演
    </DirectorWrapper>
  )
}
export default memo(Director);
