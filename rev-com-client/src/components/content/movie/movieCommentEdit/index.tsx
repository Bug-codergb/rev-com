import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {useLocation} from "react-router-dom";
import {message} from "antd";
import {
  MovieCommentEditWrapper
}from "./style";
import {IMovie} from "../../../../types/movie/movie";
import {getMovieDetail} from "../../../../network/movie";
import {IResponseType} from "../../../../types/responseType";
import {IScreenwriter} from "../../../../types/movie/screenwriter";
import CommentEdit from "./childCpn/commentEdit";

const MovieCommentEdit:FC=():ReactElement=>{
  const location=useLocation();
  const state=location.state as {id:string}
  const [id,setId]=useState(state.id);
  const [movie,setMovie]=useState<IMovie>();
  useEffect(()=>{
    getMovieDetail<IResponseType<IMovie>>(id).then((data)=>{
      if(data.status===200){
        setMovie(data.data)
      }
    })
  },[id])
  return (
    <MovieCommentEditWrapper className="center-auto">
      <div className="movie-simple-info">
        <div className="movie-title">
          <span className="movie-name">{movie?.name}</span>
          <span className="movie-alias">{movie?.alias}</span>
          <span className="movie-time">({movie?.releaseTime.substring(0,4)})</span>
        </div>
        <div className="movie-info">
          <div className="left">
            <div className="img-container">
              <img src={movie?.coverUrl}/>
            </div>
          </div>
          <div className="center">
            <ul className="info-list">
              <li className="item">
                <div className="key">导演:</div>
                <div className="value link">
                  {
                    movie?.directors.map((item,index)=>{
                      return (
                        <span key={item.id}>{item.name}</span>
                      )
                    })
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">编剧</div>
                <div className="value link">
                  {
                    movie?.screenwriters.map((item:IScreenwriter,index:number)=>{
                      return <span key={item.id}>{item.name}</span>
                    })
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">主演:</div>
                <div className="value link">
                  {
                    movie?.actors.map((item,index)=>{
                      return <span key={item.id}>{item.name} / </span>
                    })
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">类型:</div>
                <div className="value">
                  {
                    movie?.categories.map((item)=>item.name).join(" / ")
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">制片国家:</div>
                <div className="value">
                  {movie?.area.map(item=>item.name).join(" / ")}
                </div>
              </li>
              <li className="item">
                <div className="key">语言:</div>
                <div className="value">{movie?.language}</div>
              </li>
              <li className="item">
                <div className="key">上映日期:</div>
                <div className="value">{movie?.releaseTime}</div>
              </li>
              <li className="item">
                <div className="key">片长:</div>
                <div className="value">{movie?.duration}</div>
              </li>
            </ul>
          </div>
          <div className="right"></div>
        </div>
      </div>
      <h3 className="publish-tip" >发表影评</h3>

      <CommentEdit id={id}/>
    </MovieCommentEditWrapper>
  )
}
export default memo(MovieCommentEdit);
