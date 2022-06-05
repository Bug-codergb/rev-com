import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import {
  HotMovieWrapper
} from "./style"
import Hot from "../hot";
import {getAllMovieArea} from "../../../../../../network/movie/area";
import {IResponseType} from "../../../../../../types/responseType";
import IArea from "../../../../../../types/movie/IArea";
import {ICategory} from "../../../../../../types/movie/ICategory";
import {IForm} from "../../../../../../types/movie/IForm";
import {getAllMovieForm} from "../../../../../../network/movie/form";
import {getRecentMovie} from "../../../../../../network/movie";
import {IMovie} from "../../../../../../types/movie/movie";
const HotMovie:FC=():ReactElement=>{
  const [area,setArea]=useState<ICategory[]>([]);
  const [form,setForm]=useState<IForm[]>([]);
  const [formId,setFormId]=useState<string>("");
  const [movie,setMovie]=useState<IMovie[]>()
  useEffect(()=>{
    getAllMovieForm<IResponseType<IForm[]>>().then((data)=>{
      if(data.status===200){
        setForm(data.data);
        getAllMovieArea<IResponseType<IArea[]>>().then((data)=>{
          if(data.status===200){
            setArea(data.data.slice(0,8))
          }
        })
      }
    })
  },[])
  useEffect(()=>{
    for(let item of form){
      if(item.name==="电影"){
        setFormId(item.id);
        if(area[0]){
          getRecentMovie(area[0].id,item.id).then((data)=>{
            if(data.status===200){
              setMovie(data.data);
            }
          })
        }
      }
    }
  },[form,area])
  const cateClick=(id:string)=>{
    getRecentMovie(id,formId).then((data)=>{
      if(data.status===200){
        setMovie(data.data);
      }
    })
  }
  return (
    <HotMovieWrapper>
      {
        movie&&<Hot title={"最近热门电影"}
             cateList={area}
             onClick={(id)=>cateClick(id)}
             movies={movie}
        />
      }
    </HotMovieWrapper>
  )
}
export default memo(HotMovie);
