import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import {Empty, Image} from "antd"
import {
  VideoWrapper
}from "./style";
import Filter from "./childCpn/filter";
import {IMovie} from "../../../../types/movie/movie";
import {getAllMovie} from "../../../../network/movie";
import {IResponseType} from "../../../../types/responseType";
import {IPageResult} from "../../../../types/pageResult";
import MsgItem from "../../../../components/common/msgItem";
import {holder} from "../../../../utils/holder";
import movieHolder from "../../../../assets/img/holder/movie.png"
const Video:FC=():ReactElement=>{
  const [movies,setMovies]=useState<IMovie[]>([]);
  const [total,setTotal]=useState<number>(0)
  const [form,setForm]=useState<string>("");
  const [cate,setCate]=useState<string>("");
  const [area,setArea]=useState<string>("");
  const getAllMovieRequest=(form:string,cate:string,area:string,page:number,limit:number)=>{
    getAllMovie<IResponseType<IPageResult<IMovie[]>>>(form,cate,area,page,limit).then((data)=>{
      if(data.status===200){
        setMovies(data.data.data);
        setTotal(data.data.total);
      }
    })
  }
  useEffect(()=>{
    getAllMovieRequest(form,cate,area,1,24);
  },[])
  useEffect(()=>{
    getAllMovieRequest(form,cate,area,1,24);
  },[cate,form,area])
  const formClick=(id:string)=>{
    setForm(id);
  }
  const cateClick=(id:string)=>{
    setCate(id);
  }
  const areaClick=(id:string)=>{
    setArea(id);
  }
  return (
    <VideoWrapper className="center-auto">
      <Filter areaClick={(id:string)=>areaClick(id)}
              cateClick={(id:string)=>cateClick(id)}
              formClick={(id:string)=>formClick(id)}/>
      <ul className="movie-list">
        {
          movies && movies.length!==0 && movies.map((item,index)=>{
            return (
              <li key={item.id}>
                <MsgItem img={<Image width={150}

                                     preview={false}
                                     src={item.coverUrl}
                                     placeholder={<Image width={150}
                                                         height={200}
                                                         src={movieHolder}
                                                         preview={false}/>} />}
                         name={<span>{item.name}</span>}
                         itemWidth={150}
                         scale={1.3}
                         isFlex={true}
                         creator={<span> </span>}/>
              </li>
            )
          })
        }
        {
          total<1&&<div className="empty-status">
            <Empty description="暂无影视"/>
          </div>
        }
        {
          holder(total,8).map((item)=>{
            return (<li> </li>)
          })
        }
      </ul>
    </VideoWrapper>
  )
}
export default memo(Video);
