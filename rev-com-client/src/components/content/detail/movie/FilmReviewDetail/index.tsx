import React, {memo, FC, ReactElement, useEffect, useState,ChangeEvent} from "react";
import {useLocation} from "react-router-dom";
import {useSelector} from "react-redux";
import {Map} from 'immutable';
import {Rate,message} from "antd";
import {LikeOutlined,BookOutlined,BookFilled,LikeFilled} from "@ant-design/icons";
import {
  LeftContent,
  RightContent,
  FilmReviewDetailWrapper
} from "./style"
import {getAllCommentReply, getCommentDetail, replyComment} from "../../../../../network/comment";
import {IResponseType} from "../../../../../types/responseType";
import {IComment} from "../../../../../types/comment";

import {formatTime} from "../../../../../utils/formatTime";
import TextArea from "antd/es/input/TextArea";
import Comment from "../../../../common/comment";
import {IPageResult} from "../../../../../types/pageResult";
import {ILogin, IUserMsg} from "../../../../../types/login";

const FilmReviewDetail:FC=():ReactElement=>{
  const location=useLocation();
  const state=location.state as {id:string,name:string|undefined};
  const [id,setId]=useState<string>(state.id);
  const [movieName,setMovieName]=useState<string>(state.name? state.name:"");
  const [comment,setComment]=useState<IComment>();
  const [commentText,setCommentText]=useState<string>("");

  const [reply,setReply]=useState<IComment[]>([]);
  const [total,setTotal]=useState<number>(0);
  const login = useSelector<Map<string, ILogin>, ILogin>((state) => {
    return state.getIn(['loginReducer', 'login']) as ILogin
  });
  const getCommentReplyRequest=(id:string,page:number,limit:number)=>{
    getAllCommentReply<IResponseType<IPageResult<IComment[]>>>(id,page,limit).then((data)=>{
      if(data.status===200){
        setReply(data.data.data);
        setTotal(data.data.total);
      }
    })
  }
  useEffect(()=>{
    getCommentDetail<IResponseType<IComment>>(id).then((data)=>{
      if(data.status===200){
        setComment(data.data);
        getCommentReplyRequest(data.data.id,1,10);
      }
    })
  },[])
  const textChange=(e:ChangeEvent<HTMLTextAreaElement>)=>{
    setCommentText(e.currentTarget.value)
  }
  const publish=()=>{
    if(commentText.trim().length===0){
      message.warn({
        content:"回复内容不能为空",
        className:"global-tip",
        duration:1500
      })
    }else{
      replyComment(commentText,id).then((data)=>{
        if(data.status===200){
          message.success({
            content:"回复成功",
            className:"global-tip",
            duration:1500
          })
          setCommentText("");
          getCommentDetail<IResponseType<IComment>>(id).then((data)=>{
            if(data.status===200){
              setComment(data.data);
              getCommentReplyRequest(data.data.id,1,10);
            }
          })
        }
      })
    }
  }
  const pageClick=(e:number)=>{
    if(comment){
      getCommentReplyRequest(comment.id,e,10);
    }
  }
  return (
    <FilmReviewDetailWrapper className="center-auto">
      <LeftContent>
        <h1 className="comment-title">{comment?.title}</h1>
        <div className="comment-info">
          <div className="user-msg">
            <div className="img-container">
              <img src={comment?.user.avatarUrl}/>
            </div>
            <div className="user-name">{comment?.user.userName}</div>
          </div>
          <div className="movie-name">
            <span>评论</span>
            <span>{movieName}</span>
          </div>
          <div className="rate">
            <Rate value={comment?.score}
                  className="rate-style"
                  disabled={false}/>
          </div>
          {
            comment&&<div className="create-time">{formatTime(comment?.createTime,"yyyy-MM-dd hh:mm:ss")}</div>
          }
        </div>
        {
          comment&&<div className="comment-content" dangerouslySetInnerHTML={{__html:comment?.content}}></div>
        }
        <div className="control">
          <div className="thumb">
            <LikeOutlined />
            <LikeFilled />
            <span className="count">(45)</span>
          </div>
          <div className="sub">
            <BookOutlined />
            <BookFilled />
            <span className="count">(87)</span>
          </div>
        </div>
        {
          comment&&<div className="comment-publish-outer">
            <div className="img-container">
              <img src={login?.userMsg?.avatarUrl}/>
            </div>
            <div className="right-msg">
              <TextArea rows={3}
                        value={commentText}
                        maxLength={200}
                        placeholder="回复影评（200）"
                        onChange={(e)=>textChange(e)}/>
              <div className="publish-btn" onClick={e=>publish()}>
                回复
              </div>
            </div>
          </div>
        }
        {
          comment&&<div className="comment-list">
            <Comment isShowRate={false}
                     id={comment.id}
                     isShort={true}
                     comment={reply}
                     total={total}
                     count={10}
                     isPage={true}
                     pageClick={(e:number)=>pageClick(e)}
                     isControl={true}/>
          </div>
        }
      </LeftContent>
      <RightContent>

      </RightContent>
    </FilmReviewDetailWrapper>
  )
}
export default memo(FilmReviewDetail);
