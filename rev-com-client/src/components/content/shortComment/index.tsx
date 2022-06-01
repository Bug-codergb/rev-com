import React, {memo, FC, ReactElement, useState,useImperativeHandle,forwardRef,ChangeEvent} from "react";
import { Input } from 'antd';
import {
  ShortCommentWrapper
}from "./style";
import {Rate} from "antd";
interface IProps{
  rate:number
}
const { TextArea } = Input;
const ShortComment:FC<IProps>=forwardRef((props,propsRef):ReactElement=>{
  const {rate}=props;
  const [score,setScore]=useState<number>(rate);
  const [content,setContent]=useState<string>("")
  const publishRate=(e:number)=>{
    setScore(e)
  }
  const contentChange=(e:ChangeEvent<HTMLTextAreaElement>)=>{
    setContent(e.currentTarget.value)
  }
  useImperativeHandle(propsRef,()=>{
    return {
      score:score,
      content:content
    }
  })
  return (
    <ShortCommentWrapper>
      <div className="score">
        <Rate className="rate-style"
              allowClear={false}
              value={score}
              onChange={e=>publishRate(e)}/>
      </div>
      <div className="comment-content">
        <TextArea rows={4} showCount={true}
                  placeholder="请输入您的评论"
                  maxLength={200}
                  onChange={(e)=>contentChange(e)}/>
      </div>
    </ShortCommentWrapper>
  )
})
export default memo(ShortComment);
