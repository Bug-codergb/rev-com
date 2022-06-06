import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {useLocation} from "react-router-dom";
import {
  ShortComDetailWrapper,
  LeftContent,
  RightContent
} from "./style"
import {getAllShortCom} from "../../../../../../network/comment";
import {IResponseType} from "../../../../../../types/responseType";
import {IPageResult} from "../../../../../../types/pageResult";
import {IComment} from "../../../../../../types/comment";
import Comment from "../../../../../common/comment";
import {getMovieDetail} from "../../../../../../network/movie";
import {IMovie} from "../../../../../../types/movie/movie";
import {formatTime} from "../../../../../../utils/formatTime";
const ShortComDetail:FC=():ReactElement=>{
  const location=useLocation();
  const state=location.state as {id:string};
  const [id,setId]=useState<string>(state.id);
  const [total,setTotal]=useState<number>(0);
  const [comment,setComment]=useState<IComment[]>([]);
  const [movie,setMovie]=useState<IMovie>();
  useEffect(()=>{
    if(id){
      getAllShortCom<IResponseType<IPageResult<IComment[]>>>(1,10,"movieId",id).then((data)=>{
        if(data.status===200){
          setTotal(data.data.total);
          setComment(data.data.data);
        }
      })
    }
  },[id])
  useEffect(()=>{
    getMovieDetail<IResponseType<IMovie>>(id).then((data)=>{
      if(data.status===200){
        setMovie(data.data)
      }
    })
  },[])
  const pageClick=(e:number)=>{
    getAllShortCom<IResponseType<IPageResult<IComment[]>>>(e,10,"movieId",id).then((data)=>{
      if(data.status===200){
        setTotal(data.data.total);
        setComment(data.data.data);
      }
    })
  }
  return (
    <ShortComDetailWrapper className="center-auto">
      <LeftContent>
        <h2 className="movie-name">{movie?.name}短评</h2>
        {
          comment&&comment.length!==0&&<Comment isShort={true}
                                                isPage={true}
                                                comment={comment}
                                                pageClick={(e)=>pageClick(e)}
                                                total={total}
                                                count={10}
                                                isControl={true}
                                                isShowRate={true}/>
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
    </ShortComDetailWrapper>
  )
}
export default memo(ShortComDetail);
