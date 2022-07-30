import React, {memo, FC, ReactElement, useEffect, useState} from "react";
import { useNavigate } from "react-router-dom";
import {
  ActorWrapper,
  LeftContent,
  RightContent
}from "./style";
import {getAllActor} from "../../../../network/movie/actor";
import {IResponseType} from "../../../../types/responseType";
import {IActor} from "../../../../types/movie/actor";
import {IPageResult} from "../../../../types/pageResult";
import MsgItem from "../../../../components/common/msgItem";
import {Pagination} from "antd";
import {holder} from "../../../../utils/holder";

const Actor:FC=():ReactElement=>{
  const [actor,setActor]=useState<IActor[]>();
  const [total,setTotal]=useState<number>(0);
  const navigate=useNavigate();
  useEffect(()=>{
   getAllActor<IResponseType<IPageResult<IActor[]>>>(1,20).then((data)=>{
     if(data.status===200){
       setActor(data.data.data);
       setTotal(data.data.total);
     }
   })
  },[])
  const pageChange=(e:number)=>{
    getAllActor<IResponseType<IPageResult<IActor[]>>>(e,20).then((data)=>{
      if(data.status===200){
        setActor(data.data.data);
        setTotal(data.data.total);
      }
    })
  }
  const actorRouterHandle=(item:IActor)=>{
    console.log(item)
    navigate("/Home/Movie/ActorDetail",{
      replace:true,
      state:{
        actor:item
      }
    })
  }
  return (
    <ActorWrapper className="center-auto">
      <LeftContent>
        <h1>全部演员</h1>
        <ul className="actors">
          {
            actor&&actor.length!==0&&actor.map((item,index)=>{
              return (
                <li key={item.id} onClick={e=>actorRouterHandle(item)}>
                  <MsgItem img={<img src={item.avatarUrl} title={item.name}/>}
                           name={<span>{item.name}</span>}
                           itemWidth={120}
                           scale={1.4}
                           isFlex={false}
                           creator={<span> </span>}/>
                </li>
              )
            })
          }
          {
            actor&&actor.length!==0&&holder(actor.length,6).map((item)=>{
              return (
                <li> </li>
              )
            })
          }
        </ul>
        {total>20&&<div className="page">
          <Pagination total={total}
                      pageSize={20}
                      defaultCurrent={1}
                      onChange={e=>pageChange(e)}
                      showTitle={false}/>
        </div>}
      </LeftContent>
      <RightContent>

      </RightContent>
    </ActorWrapper>
  )
}
export default memo(Actor);
