import React, {memo, FC, ReactElement, useState, ChangeEvent,MouseEvent, useEffect} from "react";
import {
  CommentWrapper
}from "./style";
import {IComment} from "../../../types/comment";
import {Empty, Rate, message, Pagination} from "antd";
import {LikeOutlined, FormOutlined, DeleteOutlined, LikeFilled} from "@ant-design/icons"
import {formatTime} from "../../../utils/formatTime";
import TextArea from "antd/es/input/TextArea";
import {replyComment} from "../../../network/comment";
import {useThumb} from "../../../hooks/useThumb";
import {cancelThumb, thumb} from "../../../network/thumb";
import {useDispatch, useSelector} from "react-redux";
import {Dispatch} from "redux";
import {changeUserDetailAction} from "../../../views/login/store/actionCreators";
import {Map} from "immutable";
import {ILogin} from "../../../types/login";
interface IProps{
  isShowRate:boolean,
  comment:IComment[],
  isShort:boolean,
  isControl:boolean,
  commentClick?:(id:string)=>void,
  id?:string , //当前影评id
  isPage:boolean,
  total:number,
  count:number,
  pageClick?:(e:number)=>void,
  isWangEdit:boolean
}
const Comment:FC<IProps>=(props):ReactElement=>{
  const {comment,isShort,commentClick,isShowRate,isControl,id,isPage,total,count,pageClick,isWangEdit}=props;
  const isThumbs=useThumb;
  const [commentText,setCommentText]=useState<string>("");
  const [currentIndex,setCurrentIndex]=useState<number>(-1);
  const dispatch=useDispatch<Dispatch<any>>();
  const login = useSelector<Map<string, ILogin>, ILogin>((state) => {
    return state.getIn(['loginReducer', 'login']) as ILogin
  });
  useEffect(()=>{
    document.addEventListener("click",replyFn)
  },[])
  useEffect(()=>{
    return ()=>{
      document.removeEventListener("click",replyFn);
    }
  },[])
  const replyFn=()=>{
    setCurrentIndex(-1);
  }
  const commentClickHandle=(item:IComment)=>{
    if(commentClick){
      commentClick(item.id);
    }
  }
  const textChange=(e:ChangeEvent<HTMLTextAreaElement>)=>{
    setCommentText(e.currentTarget.value);
  }
  const publish=(item:IComment,index:number)=>{
    if(commentText.trim().length===0){
      message.warn({
        content:"回复内容不能为空",
        className:"global-tip"
      })
    }else{
      replyComment(commentText,item.id).then((data)=>{
        if(data.status===200){
          message.success({
            content:"回复成功",
            className:"global-tip",
            duration:1500
          })
          setCommentText("");
        }
      })
    }
  }
  const showReply=(e:MouseEvent<HTMLSpanElement>,item:IComment,index:number)=>{
    e.stopPropagation();
    setCurrentIndex(index);
  }
  const changePage=(e:number)=>{
    if(pageClick){
      pageClick(e)
    }
  }
  const thumbClick=(isThumbs:boolean,id:string)=>{
    if(isThumbs){
      cancelThumb("cId",id).then(data=>{
        if(data.status===200){
          dispatch(changeUserDetailAction(login.userMsg.userId));
        }
      })
    }else {
      thumb("cId",id).then((data)=>{
        if(data.status===200){
          dispatch(changeUserDetailAction(login.userMsg.userId))
        }
      })
    }
  }
  return (
    <CommentWrapper isWangEdit={isWangEdit}>
      <ul className="comment-list">
        {
          comment&&comment.length!==0&&comment.map((item,index)=>{
            return (
              <li key={item.id}>
                <div className="left-content">
                  <img src={item.user.avatarUrl} alt={item.user.userName}/>
                </div>
                <div className="right-content">
                  <div className="info">
                    <div className="left-info">
                      <div className="user-name">{item.user.userName}</div>
                      <div className="rate">
                        {
                          isShowRate&&<Rate className="rate-style"
                                disabled={true}
                                value={item.score}
                                allowClear={false}/>
                        }
                      </div>
                      <div className="create-time">{formatTime(item.createTime,"yyyy-MM-dd hh:mm:ss")}</div>
                    </div>
                    {
                      isControl&&<div className="right-info">
                        {(!isThumbs(item.id))&&<LikeOutlined onClick={e=>thumbClick(false,item.id)}/>}
                        {isThumbs(item.id)&&<LikeFilled onClick={e=>thumbClick(true,item.id)}/>}
                        <FormOutlined onClick={(e)=>showReply(e,item,index)}/>
                        <DeleteOutlined />
                      </div>
                    }
                  </div>
                  {
                    !isShort && <div className="comment-title" onClick={e=>commentClickHandle(item)}>
                      {item.title}
                    </div>
                  }
                  <div className="comment-content text-num-nowrap" style={{color:"#666666"}} dangerouslySetInnerHTML={{__html:item.content}}></div>
                  {
                    item.reply&&item.reply.id!==id&&<div className="comment-from">
                      <span>回复</span>
                      <span>@{item.reply?.user.userName}</span>
                      <span>
                        {item.reply?.content}
                      </span>
                    </div>
                  }
                  {
                    currentIndex===index&&<div className="reply-control">
                      <TextArea rows={3}
                                value={commentText}
                                maxLength={200}
                                placeholder="回复影评（200）"
                                onClick={e=>e.stopPropagation()}
                                onChange={(e)=>textChange(e)}/>
                      <div className="publish-btn" onClick={e=>publish(item,index)}>
                        回复
                      </div>
                    </div>
                  }
                </div>
              </li>
            )
          })
        }
      </ul>
      {
        comment&&comment.length<1&&<div className="empty-status">
          <Empty image={Empty.PRESENTED_IMAGE_SIMPLE}/>
        </div>
      }
      {isPage&&total > count && (
        <div className="page">
          <Pagination
            defaultCurrent={1}
            total={total}
            pageSize={count}
            showTitle={false}
            onChange={(val: number) => changePage(val)}
          />
        </div>
      )}
    </CommentWrapper>
  )
}
export default memo(Comment);
