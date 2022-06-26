import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {
  AllHotReviewWrapper,
  LeftContent,
  RightContent
} from "./style"
import {IComment} from "../../../../types/comment";
import {useNavigate} from "react-router-dom";
import {getHotReview} from "../../../../network/comment";
import {IResponseType} from "../../../../types/responseType";
import {IPageResult} from "../../../../types/pageResult";
import {Pagination, Rate} from "antd";
import {getMovieTop} from "../../../../network/movie";
import {IMovie} from "../../../../types/movie/movie";
const AllHotReview:FC=():ReactElement=>{
  const [review,setReview]=useState<IComment[]>([]);
  const [total,setTotal]=useState<number>(0);
  const navigate=useNavigate();
  useEffect(()=>{
    getHotReview<IResponseType<IPageResult<IComment[]>>>(1,10).then((data)=>{
      if(data.status===200){
        setReview(data.data.data);
        setTotal(data.data.total)
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
  const changePage=(e:number)=>{
    getHotReview<IResponseType<IPageResult<IComment[]>>>(e,10).then((data)=>{
      if(data.status===200){
        setReview(data.data.data);
        setTotal(data.data.total)
      }
    })
  }
  return (
    <AllHotReviewWrapper className="center-auto">
      <LeftContent>
        <div className="review-title">
          <div className="title">最受欢迎的影评</div>
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
        {
          total>10&&<div className="page">
            <Pagination
              defaultCurrent={1}
              total={total}
              pageSize={10}
              showTitle={false}
              onChange={(val: number) => changePage(val)}/>
          </div>
        }
      </LeftContent>
      <RightContent>

      </RightContent>
    </AllHotReviewWrapper>
  )
}
export default memo(AllHotReview);
