import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {
  HotReviewWrapper
} from "./style"
import {getHotReview} from "../../../../../../network/comment";
import {IResponseType} from "../../../../../../types/responseType";
import {IPageResult} from "../../../../../../types/pageResult";
import {IComment} from "../../../../../../types/comment";
import {Rate} from "antd";
const HotReview:FC=():ReactElement=>{
  const [review,setReview]=useState<IComment[]>([]);
  const navigate=useNavigate();
  useEffect(()=>{
   getHotReview<IResponseType<IPageResult<IComment[]>>>(1,5).then((data)=>{
     if(data.status===200){
       setReview(data.data.data);
     }
   })
  },[])
  const reviewClick=(item:IComment)=>{
    navigate("/Home/Movie/MovieReview",{
      replace:true,
      state:{
        cId:item.id,
        mId:item.movie.id
      }
    })
  }
  const allReviewClick=()=>{
    navigate("/Home/Movie/AllHotReview",{
      replace:true,
    })
  }
  return (
    <HotReviewWrapper>
      <div className="review-title">
        <div className="title">最受欢迎的影评</div>
        <div className="more" onClick={e=>allReviewClick()}>更多热门影评 》</div>
      </div>
      <ul className="review-list">
        {
          review&&review.length!==0&&review.map((item,index)=>{
            return (
              <li key={item.id}>
                <div className="img-container">
                  <img src={item.movie.coverUrl} alt={item.movie.name}/>
                </div>
                <div className="right-msg">
                  <div className="review-title" onClick={e=>reviewClick(item)}>{item.title}</div>
                  <div className="user-creator">
                    <div className="user">
                      <span>{item.user.userName}</span>
                      <span>评论</span>
                      <span>《{item.movie.name}》</span>
                    </div>
                    <div className="rate">
                      <Rate disabled={true}
                            value={item.movie.score}
                            className="rate-style"/>
                    </div>
                  </div>
                  <div className="review-content" dangerouslySetInnerHTML={{__html:item.content}}></div>
                </div>
              </li>
            )
          })
        }
      </ul>
    </HotReviewWrapper>
  )
}
export default memo(HotReview)
