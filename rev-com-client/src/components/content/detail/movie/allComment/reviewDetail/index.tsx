import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {useNavigate,useLocation} from "react-router-dom";
import {
  ReviewDetailWrapper,
  LeftContent,
  RightContent
} from "./style"
import {IComment} from "../../../../../../types/comment";
import {getAllComment} from "../../../../../../network/comment";
import {IResponseType} from "../../../../../../types/responseType";
import {IPageResult} from "../../../../../../types/pageResult";
import Comment from "../../../../../common/comment";
import {IMovie} from "../../../../../../types/movie/movie";
import {getMovieDetail} from "../../../../../../network/movie";
import {formatTime} from "../../../../../../utils/formatTime";
const ReviewDetail:FC=():ReactElement=>{
  const navigate=useNavigate();
  const location=useLocation();
  const state=location.state as {id:string};
  const [id,setId]=useState<string>(state.id);
  const [review,setReview]=useState<IComment[]>();
  const [total,setTotal]=useState<number>(0);
  const [movie,setMovie]=useState<IMovie>();
  useEffect(()=>{
    getAllComment<IResponseType<IPageResult<IComment[]>>>(1,10,"movieId",id).then((data)=>{
      if(data.status===200){
        setReview(data.data.data);
        setTotal(data.data.total)
      }
    })
  },[id])
  useEffect(()=>{
    getMovieDetail<IResponseType<IMovie>>(id).then((data)=>{
      if(data.status===200){
        setMovie(data.data);
      }
    })
  },[id])
  const pageClick=(e:number)=>{

  }
  const commentClick=(cId:string)=>{
    navigate("/Home/Movie/MovieReview",{
      replace:true,
      state:{
        cId:cId,
        mId:id,
      }
    })
  }
  return (
    <ReviewDetailWrapper className="center-auto">
      <LeftContent>
        <div className="movie-name">{movie?.name}的影评（{total}）</div>
        {
          review&&review.length!==0&&<Comment comment={review}
                                              total={total}
                                              commentClick={(id:string)=>commentClick(id)}
                                              count={10}
                                              isPage={true}
                                              isShowRate={true}
                                              isShort={false}
                                              isWangEdit={false}
                                              pageClick={e=>pageClick(e)}
                                              isControl={true}/>
        }
      </LeftContent>
      <RightContent>
        <div className="movie-cover">
          <img src={movie?.coverUrl} alt={movie?.name}/>
        </div>
        <div className="directors">
          <span>导演</span>
          {
            movie?.directors.map((item)=>item.name).join(" / ")
          }
        </div>
        <div className="actors">
          <span>演员:</span>
          {
            movie?.actors.map(item=>item.name).join(" / ")
          }
        </div>
        <div className="cate">
          <span>类型:</span>
          {
            movie?.categories.map(item=>item.name).join(" / ")
          }
        </div>
        <div className="area">
          <span>地区:</span>
          {
            movie?.area.map(item=>item.name).join(" / ")
          }
        </div>
        <div className="dt">
          <span>片长:</span>
          {
            movie?.duration
          }
        </div>
        <div className="releaseTime">
          <span>上映时间:</span>
          {
            formatTime(movie?movie.releaseTime:0,"yyyy-MM-dd")
          }
        </div>
      </RightContent>
    </ReviewDetailWrapper>
  )
}
export default memo(ReviewDetail);
