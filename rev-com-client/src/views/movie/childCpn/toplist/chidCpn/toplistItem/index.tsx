import React,{memo,FC,ReactElement} from "react";
import {
  ToplistItemWrapper
} from "./style";
import {IMovie} from "../../../../../../types/movie/movie";
import {formatTime} from "../../../../../../utils/formatTime";
import {Rate} from "antd";
interface IProps{
  title:string,
  movie:IMovie[],
  onClick?:(id:string)=>void
}
const ToplistItem:FC<IProps>=(props):ReactElement=>{
  const {title,movie,onClick}=props;
  const movieClick=(item:IMovie)=>{
    if(onClick){
      onClick(item.id);
    }
  }
  return (
    <ToplistItemWrapper>
      <h2 className="toplist-name">{title}</h2>
      <ul className="movies">
        {
          movie&&movie.length!==0&&movie.map((item,index)=>{
            return (
              <li key={item.id}>
                <div className="img-container" onClick={e=>movieClick(item)}>
                  <img src={item.coverUrl} alt={item.name}/>
                </div>
                <div className="right-msg">
                  <div className="movie-name" onClick={e=>movieClick(item)}>
                    <span>{item.name}</span> /
                    <span>{item.alias}</span>
                  </div>
                  <div className="info">
                    <span>{formatTime(item.releaseTime,"yyyy-MM-dd")}</span>/
                    <span>{item.area.map(item=>item.name).join(" / ")}</span>
                    <span>{item.directors.map(item=>item.name).join(" / ")}</span> /
                    <span>{item.actors.map(item=>item.name).join(" / ")}</span>
                  </div>
                  <div className="rate">
                    <Rate value={item.score/10*5}
                          allowHalf={true}
                          className="rate-movie"
                          disabled={true}/>
                    <div className="score">{(item.score).toFixed(1)}</div>
                    <div className="comment-count">
                      ({item.comment}人评价)
                    </div>
                  </div>
                </div>
              </li>
            )
          })
        }
      </ul>
    </ToplistItemWrapper>
  )
}
export default memo(ToplistItem);
