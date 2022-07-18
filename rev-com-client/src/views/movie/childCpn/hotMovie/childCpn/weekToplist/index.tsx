//一周口碑榜单
import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {
  WeekToplistWrapper
} from "./style";
import {getWeekToplist} from "../../../../../../network/movie";
import {IMovie} from "../../../../../../types/movie/movie";
import {IResponseType} from "../../../../../../types/responseType";
const WeekToplist:FC=():ReactElement=>{
  const [movie,setMovie]=useState<IMovie[]>([]);
  const navigate=useNavigate();
  useEffect(()=>{
    getWeekToplist<IResponseType<IMovie[]>>().then((data)=>{
      if(data.status===200){
        setMovie(data.data);
      }
    })
  },[])
  const movieRouterHandle=(item:IMovie)=>{
    navigate("/Home/Movie/movieDetail",{
      replace:true,
      state:{
        id:item.id
      }
    })
  }
  return (
    <WeekToplistWrapper>
      <h2 className="week-title">一周口碑榜</h2>
      <ul className="movie-list">
        {
          movie&&movie.length!==0&&movie.map((item,index)=>{
            return (
              <li key={item.id}>
                <div className="week-movie-index">{index+1}</div>
                <div className="week-movie-name" onClick={e=>movieRouterHandle(item)}>{item.name}</div>
              </li>
            )
          })
        }
      </ul>
    </WeekToplistWrapper>
  )
}
export default memo(WeekToplist)
