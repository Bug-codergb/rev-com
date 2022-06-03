import React, {memo, FC, ReactElement, useState, useEffect,useRef} from "react";
import {useLocation,useNavigate} from "react-router-dom";
import { Rate,Modal,message,Progress  } from 'antd';
import {PlusOutlined,FormOutlined} from "@ant-design/icons";
import {
  MovieDetailWrapper,
  LeftContent,
  RightContent
}from './style';
import {getMovieDetail} from "../../../../../network/movie";
import {IResponseType} from "../../../../../types/responseType";
import {IMovie} from "../../../../../types/movie/movie";
import {IScreenwriter} from "../../../../../types/movie/screenwriter";
import Actor from "./childCpn/actor";
import ShortComment from "../../../shortComment";
import {publishComment} from "../../../../../network/comment";
import MovieCom from "./childCpn/movieCom";
import {getMovieRate} from "../../../../../network/rate";
import {IRate} from "../../../../../types/rate";
const MovieDetail:FC=():ReactElement=>{
  const location=useLocation();
  const navigate=useNavigate();
  const state=location.state as {id:string}
  const rateText=["很差","较差","还行","推荐","力荐"];
  const [rateStatus,setStatus]=useState("");
  const [rate,setRate]=useState(0);
  const [id,setId]=useState(state.id);
  const [movie,setMovie]=useState<IMovie>();
  const [isModalVisible,setIsModalVisible]=useState<boolean>(false);
  const [keyIndex,setKeyIndex]=useState<number>(1);
  const [rateInfo,setRateInfo]=useState<IRate>();
  const commentRef = useRef<any>();
  useEffect(()=>{
    getMovieDetail<IResponseType<IMovie>>(id).then((data)=>{
      if(data.status===200){
        setMovie(data.data);
      }
    })
  },[id])
  useEffect(()=>{
    getMovieRate<IResponseType<IRate>>(id).then((data)=>{
      if(data.status===200){
        setRateInfo(data.data);
      }
    })
  },[id])
  const rateChange=(e:number)=>{
    setStatus(rateText[e-1]);
  }
  const movieComRouter=()=>{
    navigate("/Home/Movie/MovieComment",{
      replace:true,
      state:{
        id:id
      }
    })
  }
  const publishRate=(e:number)=>{
    setIsModalVisible(true)
    setRate(e);
  }
  const handleOk=async ()=>{
    if(!commentRef.current.score){
      message.warn({
        content:"评分不能为空",
        className:"global-tip"
      })
    }else if(commentRef.current.content.trim().length===0){
      message.warn({
        content:"影评内容不能为空",
        className:"global-tip"
      })
    }else{
      const data=await publishComment(`${new Date().getTime()}`,commentRef.current.content,"movieId",
                         id,0,undefined,commentRef.current.score);
      if(data.status===200){
        setIsModalVisible(false);
        setKeyIndex(keyIndex+1)
        message.success({
          content:"影评发表成功",
          className:"global-tip"
        })
      }
    }
  }
  const handleCancel=()=>{
    setIsModalVisible(false)
  }
  return (
    <MovieDetailWrapper className="center-auto">
      <LeftContent>
        <div className="movie-title">
          <span className="movie-name">{movie?.name}</span>
          <span className="movie-alias">{movie?.alias}</span>
          <span className="movie-time">({movie?.releaseTime.substring(0,4)})</span>
        </div>
        <div className="movie-info">
          <div className="left">
            <div className="img-container">
              <img src={movie?.coverUrl}/>
            </div>
          </div>
          <div className="center">
            <ul className="info-list">
              <li className="item">
                <div className="key">导演:</div>
                <div className="value link">
                  {
                    movie?.directors.map((item,index)=>{
                      return (
                        <span>{item.name}</span>
                      )
                    })
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">编剧</div>
                <div className="value link">
                  {
                    movie?.screenwriters.map((item:IScreenwriter,index:number)=>{
                      return <span>{item.name}</span>
                    })
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">主演:</div>
                <div className="value link">
                  {
                    movie?.actors.map((item,index)=>{
                      return <span>{item.name} / </span>
                    })
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">类型:</div>
                <div className="value">
                  {
                    movie?.categories.map((item)=>item.name).join(" / ")
                  }
                </div>
              </li>
              <li className="item">
                <div className="key">制片国家:</div>
                <div className="value">
                  {movie?.area.map(item=>item.name).join(" / ")}
                </div>
              </li>
              <li className="item">
                <div className="key">语言:</div>
                <div className="value">{movie?.language}</div>
              </li>
              <li className="item">
                <div className="key">上映日期:</div>
                <div className="value">{movie?.releaseTime}</div>
              </li>
              <li className="item">
                <div className="key">片长:</div>
                <div className="value">{movie?.duration}</div>
              </li>
            </ul>
          </div>
          <div className="right">
            <div className="tip">电影评分</div>
            <div className="score-info">
              <div className="score">{rateInfo?(rateInfo.score*1.0).toFixed(1):0}</div>
              <div className="score-star">
                <Rate className="score-star-movie-detail"
                      disabled={true}
                      value={rateInfo?(rateInfo.score/10*5.0):0}
                      allowHalf={true}/>
                <div className="person-count">{rateInfo?.person}人评价</div>
              </div>
            </div>
            <ul className="rate-percentage">
              <li className="one">
                <div className="start-name">5星</div>
                <div className="start-value">
                  <Progress strokeColor="#ffd596"
                            strokeWidth={10}
                            percent={parseFloat(((rateInfo?rateInfo.five:0)/(rateInfo?rateInfo.person:1)*100).toFixed(1))}
                            />
                </div>
              </li>
              <li className="two">
                <div className="start-name">4星</div>
                <div className="start-value">
                  <Progress strokeColor="#ffd596"
                            strokeWidth={10}
                            percent={parseFloat(((rateInfo?rateInfo.four:0)/(rateInfo?rateInfo.person:1)*100).toFixed(1))}
                             />
                </div>
              </li>
              <li className="three">
                <div className="start-name">3星</div>
                <div className="start-value">
                  <Progress strokeColor="#ffd596"
                            strokeWidth={10}
                            percent={parseFloat(((rateInfo?rateInfo.three:0)/(rateInfo?rateInfo.person:1)*100).toFixed(1))}
                           />
                </div>
              </li>
              <li className="four">
                <div className="start-name">2星</div>
                <div className="start-value">
                  <Progress strokeColor="#ffd596"
                            strokeWidth={10}
                            percent={parseFloat(((rateInfo?rateInfo.two:0)/(rateInfo?rateInfo.person:1)*100).toFixed(1))}
                            />
                </div>
              </li>
              <li className="one">
                <div className="start-name">1星</div>
                <div className="start-value">
                  <Progress strokeColor="#ffd596"
                            strokeWidth={10}
                            percent={parseFloat(((rateInfo?rateInfo.one:0)/(rateInfo?rateInfo.person:1)*100).toFixed(1))}
                            />
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div className="operator">
          <div className="want-see">想看</div>
          <div className="saw">看过</div>
          <div className="rate">
            <span>评价:</span>
            <Rate className="rate-style"
                  allowClear={false}
                  onHoverChange={e=>rateChange(e)}
                  onChange={e=>publishRate(e)}/>
            <div className='rate-status'>{rateStatus}</div>
            <Modal title="发表简短评论"
                   visible={isModalVisible}
                   width={"56%"}
                   destroyOnClose={true}
                   onOk={handleOk}
                   onCancel={handleCancel}
                   cancelText={"取消"}
                   okText={"确定"}>
              <ShortComment rate={rate}
                            //@ts-ignore
                            ref={commentRef}/>
            </Modal>
          </div>
        </div>
        <div className="write-comment">
          <div className="comment" onClick={e=>movieComRouter()}>
            <FormOutlined />
            <div className="tip">写影评</div>
          </div>
          <div className="add">
            <PlusOutlined />
            <div className="tip">添加到片单</div>
          </div>
        </div>
        <div className="movie-desc">
          <h3 className="desc-title">{movie?.name}简介</h3>
          <p>{movie?.description}</p>
        </div>
        <div className="movie-actors">
          {
            movie&&movie.directors&&<Actor actors={movie?.actors} directors={movie?.directors}/>
          }
        </div>
        <div className="movie-comment">
          {
            movie&&movie.id&&<MovieCom isShort={true} id={movie?.id} name={movie?.name} key={keyIndex}/>
          }
        </div>
        <div className="movie-comment">
          {
            movie&&movie.id&&<MovieCom isShort={false} id={movie?.id} name={movie?.name} key={keyIndex}/>
          }
        </div>
      </LeftContent>
      <RightContent>
        ss
      </RightContent>
    </MovieDetailWrapper>
  )
}
export default memo(MovieDetail);
