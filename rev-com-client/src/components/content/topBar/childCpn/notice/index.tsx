import React,{memo,FC,ReactElement} from "react";
import {
  NoticeWrapper
}from "./style";
const Notice:FC=():ReactElement=>{
  return (
    <NoticeWrapper>
      <i className="iconfont icon-xiaoxi"> </i>
    </NoticeWrapper>
  )
}
export default memo(Notice);
