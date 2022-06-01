import React,{memo,FC,ReactElement} from "react";
import {
  CommentWrapper
}from "./style";
import {IComment} from "../../../types/comment";
import {Empty, Rate} from "antd";
import {LikeOutlined} from "@ant-design/icons"
import {formatTime} from "../../../utils/formatTime";
interface IProps{
  comment:IComment[],
  isShort:boolean
}
const Comment:FC<IProps>=(props):ReactElement=>{
  const {comment,isShort}=props;
  return (
    <CommentWrapper>
      <ul className="comment-list">
        {
          comment&&comment.length!==0&&comment.map((item,index)=>{
            return (
              <li key={item.id}>
                <div className="left-content">
                  <img src={item.user.avatarUrl}/>
                </div>
                <div className="right-content">
                  <div className="info">
                    <div className="left-info">
                      <div className="user-name">{item.user.userName}</div>
                      <div className="rate">
                        <Rate className="rate-style"
                              disabled={true}
                              value={item.score}
                              allowClear={false}/>
                      </div>
                      <div className="create-time">{formatTime(item.createTime,"yyyy-MM-dd hh:mm:ss")}</div>
                    </div>
                    <div className="right-info">
                      <LikeOutlined />
                    </div>
                  </div>
                  {
                    !isShort && <div className="comment-title">
                      {item.title}
                    </div>
                  }
                  <div className="comment-content text-num-nowrap" style={{color:"#666666"}} dangerouslySetInnerHTML={{__html:item.content}}></div>
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
    </CommentWrapper>
  )
}
export default memo(Comment);
