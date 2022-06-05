import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {
  HotTVWrapper
} from "./style"
import {ICategory} from "../../../../../../types/movie/ICategory";
import {IForm} from "../../../../../../types/movie/IForm";
import {IMovie} from "../../../../../../types/movie/movie";
import {getAllMovieForm} from "../../../../../../network/movie/form";
import {IResponseType} from "../../../../../../types/responseType";
import {getAllMovieArea} from "../../../../../../network/movie/area";
import IArea from "../../../../../../types/movie/IArea";
import {getRecentMovie} from "../../../../../../network/movie";
import Hot from "../hot";
const HotTV:FC=():ReactElement=>{
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
      if(item.name==="电视剧"){
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
    <HotTVWrapper>
      {
        movie&&<Hot title={"最近热门电视剧"}
                    cateList={area}
                    onClick={(id)=>cateClick(id)}
                    movies={movie}
        />
      }
    </HotTVWrapper>
  )
}
export default memo(HotTV);
