import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {useLocation,useNavigate} from "react-router-dom";
import { Rate } from 'antd';
import {PlusOutlined,FormOutlined} from "@ant-design/icons";
import {
  MovieDetailWrapper,
  LeftContent,
  RightContent
}from "./style";
import {getMovieDetail} from "../../../../../network/movie";
import {IResponseType} from "../../../../../types/responseType";
import {IMovie} from "../../../../../types/movie/movie";
import {IScreenwriter} from "../../../../../types/movie/screenwriter";
import Actor from "./childCpn/actor";
const MovieDetail:FC=():ReactElement=>{
  const location=useLocation();
  const navigate=useNavigate();
  const state=location.state as {id:string}
  const rateText=["很差","较差","还行","推荐","力荐"];
  const [rateStatus,setStatus]=useState("");
  const [id,setId]=useState(state.id);
  const [movie,setMovie]=useState<IMovie>();
  useEffect(()=>{
    getMovieDetail<IResponseType<IMovie>>(id).then((data)=>{
      if(data.status===200){
        setMovie(data.data)
      }
    })
  },[id])
  const rateChange=(e:number)=>{
    setStatus(rateText[e-1]);
  }
  const movieComRouter=()=>{
    navigate("/Home/Movie/MovieComment",{
      replace:true,
      state:{
        id:id
      }
    })
  }
  return (
    <MovieDetailWrapper className="center-auto">
      <LeftContent>
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
                        <span>{item.name}</span>
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
                      return <span>{item.name}</span>
                    })
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">主演:</div>
                <div className="value link">
                  {
                    movie?.actors.map((item,index)=>{
                      return <span>{item.name} / </span>
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
        <div className="operator">
          <div className="want-see">想看</div>
          <div className="saw">看过</div>
          <div className="rate">
            <span>评价:</span>
            <Rate className="rate-style" onHoverChange={e=>rateChange(e)}/>
            <div className='rate-status'>{rateStatus}</div>
          </div>
        </div>
        <div className="write-comment">
          <div className="comment" onClick={e=>movieComRouter()}>
            <FormOutlined />
            <div className="tip">写影评</div>
          </div>
          <div className="add">
            <PlusOutlined />
            <div className="tip">添加到片单</div>
          </div>
        </div>
        <div className="movie-desc">
          <h3 className="desc-title">{movie?.name}简介</h3>
          <p>{movie?.description}</p>
        </div>
        <div className="movie-actors">
          {
            movie&&movie.directors&&<Actor actors={movie?.actors} directors={movie?.directors}/>
          }
        </div>
      </LeftContent>
      <RightContent>
        ss
      </RightContent>
    </MovieDetailWrapper>
  )
}
export default memo(MovieDetail);
