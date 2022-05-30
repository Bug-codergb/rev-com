import React,{memo,FC,ReactElement} from "react";
import {
  ToplistWrapper
}from "./style";
const Toplist:FC=():ReactElement=>{
  return (
    <ToplistWrapper className="center-auto">
      排行榜
    </ToplistWrapper>
  )
}
export default memo(Toplist);
