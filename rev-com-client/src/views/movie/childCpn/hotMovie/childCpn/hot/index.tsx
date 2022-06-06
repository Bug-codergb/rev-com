import React, {memo, FC, ReactElement, useState} from "react";
import {useNavigate} from "react-router-dom";
import {
  HotWrapper
} from "./style"
import {ICategory} from "../../../../../../types/movie/ICategory";
import {IMovie} from "../../../../../../types/movie/movie";
import MsgItem from "../../../../../../components/common/msgItem";
import {holder} from "../../../../../../utils/holder";
interface IProps{
  title:string,
  cateList:ICategory[],
  onClick:(id:string)=>void,
  movies:IMovie[]
}
const Hot:FC<IProps>=(props):ReactElement=>{
  const navigate=useNavigate();
  const {cateList,title,onClick,movies}=props;
  const [currentIndex,setCurrentIndex]=useState<number>(0);
  const liClick=(item:ICategory,index:number)=>{
    setCurrentIndex(index);
    onClick(item.id);
  }
  const movieRouter=(item:IMovie)=>{
    navigate("/Home/Movie/movieDetail",{
      replace:true,
      state:{
        id:item.id,
      }
    })
  }
  return (
    <HotWrapper>
      <div className="header">
        <div className="left-header">
          <div className="header-name">{title}</div>
          <ul className="cate-list">
            {
              cateList&&cateList.length!==0&&cateList.map((item,index)=>{
                return (
                  <li key={item.id}
                      className={currentIndex===index?"active":""}
                      onClick={e=>liClick(item,index)}>{item.name}</li>
                )
              })
            }
          </ul>
        </div>
        <div className="right-header">
          更多
        </div>
      </div>
      <ul className="movie-list">
        {
          movies&&movies.length!==0&&movies.map((item,index)=>{
            return (
              <li key={item.id}>
                <MsgItem itemWidth={122}
                         name={<span className="movie-name-state text-nowrap">{item.name}</span>}
                         img={<img src={item.coverUrl} onClick={e=>movieRouter(item)}/>}
                         scale={1.45}
                         isFlex={true}
                         creator={<span className="movie-score">{(item.score).toFixed(1)}</span>} />
              </li>
            )
          })
        }
        {
          holder(movies.length,6).map((item)=>{
            return <li key={item}> </li>
          })
        }
      </ul>
    </HotWrapper>
  )
}
export default memo(Hot);
