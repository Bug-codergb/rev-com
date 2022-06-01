import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {RightOutlined} from "@ant-design/icons"
import {
  MovieComWrapper
}from "./style";
import Comment from "../../../../../../common/comment";
import {IComment} from "../../../../../../../types/comment";
import {getAllComment, getAllShortCom} from "../../../../../../../network/comment";
import {IResponseType} from "../../../../../../../types/responseType";
import {IPageResult} from "../../../../../../../types/pageResult";
import {Empty} from "antd";
interface IProps{
  id?:string,
  name?:string,
  isShort:boolean
}
const MovieCom:FC<IProps>=(props):ReactElement=>{
  const {id,name,isShort}=props;
  const [comment,setComment]=useState<IComment[]>([]);
  const [total,setTotal]=useState<number>(0);
  useEffect(()=>{
    if(id && isShort){
      getAllShortCom<IResponseType<IPageResult<IComment[]>>>(1,6,"movieId",id).then((data)=>{
        if(data.status===200){
          setComment(data.data.data);
          setTotal(data.data.total);
        }
      })
    }else if(id && !isShort){
      getAllComment<IResponseType<IPageResult<IComment[]>>>(1,6,"movieId",id).then((data)=>{
        if(data.status===200){
          setComment(data.data.data);
          setTotal(data.data.total);
        }
      })
    }
  },[])
  return (
    <MovieComWrapper>
      <div className="comment-name">
        <span>{name}的{isShort?'短评':'影评'}</span>
        <span className="line">....</span>
        <span className="total-comment">( {total}条评论 )</span>
      </div>
      {
        comment.length>0&&<Comment isShort={isShort} comment={comment}/>
      }
      {
        comment&&comment.length<1&&<div className="empty-status">
          <Empty image={Empty.PRESENTED_IMAGE_SIMPLE} description={'暂无评论'}/>
        </div>
      }
      {
        total>0&&<div className="more">
          <RightOutlined />
          <span>查看所有{isShort?'短评':'影评'} ( {total}条评论 )</span>
        </div>
      }
    </MovieComWrapper>
  )
}
export default memo(MovieCom);
