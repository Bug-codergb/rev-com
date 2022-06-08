import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {
  MovieTopWrapper,
  LeftContent,
  RightContent
} from "./style"
import {getMovieTop} from "../../../network/movie";
import {IResponseType} from "../../../types/responseType";
import {IPageResult} from "../../../types/pageResult";
import {IMovie} from "../../../types/movie/movie";
import ToplistItem from "../../../views/movie/childCpn/toplist/chidCpn/toplistItem";
import {Pagination} from "antd";
const MovieTop:FC=():ReactElement=>{
  const [movie,setMovie]=useState<IMovie[]>();
  const [total,setTotal]=useState<number>(0);
  const navigate=useNavigate();
  useEffect(()=>{
    getMovieTop<IResponseType<IPageResult<IMovie[]>>>(1,10).then((data)=>{
      if(data.status===200){
        setMovie(data.data.data);
        setTotal(data.data.total);
      }
    })
  },[])
  const changePage=(e:number)=>{
    getMovieTop<IResponseType<IPageResult<IMovie[]>>>(e,10).then((data)=>{
      if(data.status===200){
        setMovie(data.data.data);
        setTotal(data.data.total);
      }
    })
  }
  const movieClick=(id:string)=>{
    navigate("/Home/Movie/MovieDetail",{
      replace:true,
      state:{
        id:id
      }
    })
  }
  return (
    <MovieTopWrapper className="center-auto">
      <LeftContent>
        {
          movie&&<ToplistItem title={"电影TOP200"} movie={movie} onClick={(id:string)=>movieClick(id)}/>
        }
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
    </MovieTopWrapper>
  )
}
export default memo(MovieTop);
