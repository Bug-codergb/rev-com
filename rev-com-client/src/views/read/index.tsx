import React,{memo,FC,ReactElement} from "react";
import {
  ReadWrapper
}from "./style";
const Read:FC=():ReactElement=>{
  return (
    <ReadWrapper>
      读书
    </ReadWrapper>
  )
}
export default memo(Read);
