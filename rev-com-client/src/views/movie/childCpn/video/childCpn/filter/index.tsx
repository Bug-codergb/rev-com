import React, {memo, FC, ReactElement, useState, useEffect} from "react";
import {
  FilterWrapper
}from "./style";
import {IForm} from "../../../../../../types/movie/IForm";
import {ICategory} from "../../../../../../types/movie/ICategory";
import IArea from "../../../../../../types/movie/IArea";
import {getAllMovieForm} from "../../../../../../network/movie/form";
import {IResponseType} from "../../../../../../types/responseType";
import {getAllCate} from "../../../../../../network/movie/category";
import {getAllMovieArea} from "../../../../../../network/movie/area";
interface IProps{
  formClick:(id:string)=>void
  cateClick:(id:string)=>void
  areaClick:(id:string)=>void
}
const Filter:FC<IProps>=(props):ReactElement=>{
  const {formClick,cateClick,areaClick}=props;
  const [movieForm,setMovieForm]=useState<IForm[]>([]);
  const [movieCate,setMovieCate]=useState<ICategory[]>([]);
  const [movieArea,setMovieArea]=useState<IArea[]>([]);
  const [currentIndex,setCurrentIndex]=useState<number>(-1);
  const [liveIndex,setLiveIndex]=useState<number>(-1);
  const [activeIndex,setActiveIndex]=useState<number>(-1);
  useEffect( ()=>{
    getAllMovieForm<IResponseType<IForm[]>>().then((data)=>{
      if(data.status===200){
        setMovieForm(data.data);
      }
    })
    getAllCate<IResponseType<ICategory[]>>().then((data)=>{
      if(data.status===200){
        setMovieCate(data.data)
      }
    })
    getAllMovieArea<IResponseType<IArea[]>>().then((data)=>{
      if(data.status===200){
        setMovieArea(data.data)
      }
    })
  },[])
  const curClick=(id:string,index:number)=>{
    setCurrentIndex(index);
    formClick(id);
  }
  const liveClick=(id:string,index:number)=>{
    setLiveIndex(index);
    cateClick(id);
  }
  const activeClick=(id:string,index:number)=>{
    setActiveIndex(index);
    areaClick(id);
  }
  return (
    <FilterWrapper>
      <ul className="form-list">
        <li>形式:</li>
        <li className={currentIndex===-1?"active":""} onClick={e=>curClick("",-1)}>全部</li>
        {
          movieForm.length!==0&&movieForm.map((item,index)=>{
            return (
              <li key={item.id} className={currentIndex===index?"active":""} onClick={e=>curClick(item.id,index)}>{item.name}</li>
            )
          })
        }
      </ul>
      <ul className="cate-list">
        <li>分类:</li>
        <li className={liveIndex===-1?"active":""} onClick={e=>liveClick("",-1)}>全部</li>
        {
          movieCate.length!==0&&movieCate.map((item,index)=>{
            return (
              <li key={item.id} className={liveIndex===index?"active":""} onClick={e=>liveClick(item.id,index)}>{item.name}</li>
            )
          })
        }
      </ul>
      <ul className="area-list">
        <li>地区:</li>
        <li className={activeIndex===-1?"active":""} onClick={e=>activeClick("",-1)}>全部</li>
        {
          movieArea.length!==0&&movieArea.map((item,index)=>{
            return (
              <li key={item.id} className={activeIndex===index?"active":""} onClick={e=>activeClick(item.id,index)}>{item.name}</li>
            )
          })
        }
      </ul>
    </FilterWrapper>
  )
}
export default memo(Filter);
