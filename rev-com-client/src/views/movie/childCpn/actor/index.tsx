import React,{memo,FC,ReactElement} from "react";
import {
  ActorWrapper
}from "./style";
const Actor:FC=():ReactElement=>{
  return (
    <ActorWrapper className="center-auto">
      发现演员
    </ActorWrapper>
  )
}
export default memo(Actor);
