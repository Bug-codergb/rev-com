import React, {memo, FC, ReactElement, useEffect, useState} from "react";
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

const Actor:FC=():ReactElement=>{
  const [actor,setActor]=useState<IActor[]>();
  const [total,setTotal]=useState<number>(0);
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
  return (
    <ActorWrapper className="center-auto">
      <LeftContent>
        <h1>全部演员</h1>
        <ul className="actors">
          {
            actor&&actor.length!==0&&actor.map((item,index)=>{
              return (
                <li key={item.id}>
                  <MsgItem img={<img src={item.avatarUrl}/>}
                           name={<span>{item.name}</span>}
                           itemWidth={150}
                           scale={1.3}
                           isFlex={false}
                           creator={<span> </span>}/>
                </li>
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
