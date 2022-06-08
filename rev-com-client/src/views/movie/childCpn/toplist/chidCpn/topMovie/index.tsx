import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {
  TopMovieWrapper
} from "./style";
import {getMovieTop} from "../../../../../../network/movie";
import {IResponseType} from "../../../../../../types/responseType";
import {IPageResult} from "../../../../../../types/pageResult";
import {IMovie} from "../../../../../../types/movie/movie";
import MsgItem from "../../../../../../components/common/msgItem";

const TopMovie:FC=():ReactElement=>{
  const [movie,setMovie]=useState<IMovie[]>();
  const navigate=useNavigate();
  useEffect(()=>{
    getMovieTop<IResponseType<IPageResult<IMovie[]>>>(1,12).then((data)=>{
      setMovie(data.data.data);
    })
  },[])
  const topMovieRouter=()=>{
    navigate("/Home/Movie/TopMovie200",{
      replace:true
    })
  }
  return (
    <TopMovieWrapper>
      <div className="top-tip">
        <div className="top-tip-200">电影TOP200</div>
        <div className="more" onClick={e=>topMovieRouter()}>全部</div>
      </div>
      <ul className="top-movie-list">
        {
          movie&&movie.length!==0&&movie.map((item,index)=>{
            return (
              <li key={item.id}>
                <MsgItem creator={<div> </div>}
                         name={<span className="movie-name-state text-nowrap" title={item.name}>{item.name}</span>}
                         isFlex={true}
                         itemWidth={65}
                         scale={1.46}
                         img={<img src={item.coverUrl}/>}/>
              </li>
            )
          })
        }
      </ul>
    </TopMovieWrapper>
  )
}
export default memo(TopMovie);
