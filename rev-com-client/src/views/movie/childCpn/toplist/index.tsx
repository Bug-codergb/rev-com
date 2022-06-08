import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {
  ToplistWrapper,
  LeftContent,
  RightContent
}from "./style";
import {IMovie} from "../../../../types/movie/movie";
import {getNewToplist} from "../../../../network/movie";
import {IResponseType} from "../../../../types/responseType";
import ToplistItem from "./chidCpn/toplistItem";
import TopMovie from "./chidCpn/topMovie";
const Toplist:FC=():ReactElement=>{
  const [movie,setMovie]=useState<IMovie[]>([]);
  const navigate=useNavigate();
  useEffect(()=>{
    getNewToplist<IResponseType<IMovie[]>>().then((data)=>{
      if(data.status===200){
        setMovie(data.data);
      }
    })
  },[])
  const movieClick=(id:string)=>{
    navigate("/Home/Movie/movieDetail",{
      replace:true,
      state:{
        id:id
      }
    })
  }
  return (
    <ToplistWrapper className="center-auto">
      <LeftContent>
        {
          movie&&<ToplistItem title={"新片排行榜"}
                              movie={movie}
                              onClick={(id:string)=>movieClick(id)}/>
        }
      </LeftContent>
      <RightContent>
        <TopMovie/>
      </RightContent>
    </ToplistWrapper>
  )
}
export default memo(Toplist);
