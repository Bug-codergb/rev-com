import React,{memo,FC,ReactElement} from "react";
import {
  MsgItemWrapper
}from "./style";
interface IProps{
  img:ReactElement,
  name:ReactElement,
  creator:ReactElement
  itemWidth:number,
  scale:number,
  isFlex:boolean
}
const MsgItem:FC<IProps>=(props):ReactElement=>{
  const {img,name,creator,itemWidth,scale,isFlex}=props;
  return (
    <MsgItemWrapper widthProps={itemWidth} scale={scale}>
      <div className="img-container">
        {img}
      </div>
      <div className={`state ${isFlex?'is-flex':''}`}>
        {name}
        {creator}
      </div>
    </MsgItemWrapper>
  )
}
export default memo(MsgItem);
