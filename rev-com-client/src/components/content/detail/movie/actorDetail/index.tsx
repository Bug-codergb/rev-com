import React,{memo,FC,ReactElement} from "react";
import { useLocation } from "react-router-dom";
import{
  ActorDetailWrapper,
  LeftContentWrapper,
  RightContentWraper
} from "./style"
import {IActor} from "../../../../../types/movie/actor";
import InfoItem from "../../../../common/infoItem";
import {formatTime} from "../../../../../utils/formatTime";
const ActorDetail:FC=():ReactElement=>{
  const {actor}=useLocation().state as {actor:IActor};
  const actorInfo={
    "星座":actor.constellation,
    "出生日期":formatTime(actor.birth,"yyyy-MM-dd"),
    "出生地":actor.birthPlace,
    "职业":actor.occupations,
    "外文名":actor.foreignName,
    "家庭成员":actor.family
  };
  return (
    <ActorDetailWrapper className="center-auto">
      <LeftContentWrapper>
        <InfoItem name={actor.name}
                  english={actor.foreignName}
                  info={actorInfo}
                  imgURL={actor.avatarUrl}
                  imgWidth={130}
                  scale={1.4}/>
        <button className="sub">收藏</button>
        <div className="line"> </div>
        <div className="desc">
          <div className="desc-title">影人简介</div>
          <p className="desc-content">
            {actor.description}
          </p>
        </div>
      </LeftContentWrapper>
      <RightContentWraper>

      </RightContentWraper>
    </ActorDetailWrapper>
  )
}
export default memo(ActorDetail)
