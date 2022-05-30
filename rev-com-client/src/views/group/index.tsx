import React,{memo,FC,ReactElement} from "react";
import {
  GroupWrapper
}from "./style";
const Group:FC=():ReactElement=>{
  return (
    <GroupWrapper>
      小组
    </GroupWrapper>
  )
}
export default memo(Group);
