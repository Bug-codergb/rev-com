import React,{memo,FC,ReactElement} from "react";
import {
  ActorWrapper
}from "./style";
import {IActor} from "../../../../../../../types/movie/actor";
import {IDirector} from "../../../../../../../types/movie/director";
import MsgItem from "../../../../../../common/msgItem";
import {holder} from "../../../../../../../utils/holder";
interface IProps{
  actors?:IActor[],
  directors?:IDirector[]
}
const Actor:FC<IProps>=(props):ReactElement=>{
  const {actors,directors}=props;
  return (
    <ActorWrapper>
      <ul className="actor-list">
        {
          directors&&directors.length!==0 && directors.map((item,index)=>{
            return (
              <li key={item.id}>
                <MsgItem img={<img src={item.avatarUrl}/>}
                         name={<div className="a-name" title={item.name}>{item.name}</div>}
                         creator={<div className="tip">导演</div>}
                         itemWidth={115}
                         scale={1.4}
                         isFlex={false} />
              </li>
            )
          })
        }
        {
          actors&&actors.length!==0 && actors.map((item,index)=>{
            return (
              <li key={item.id}>
                <MsgItem img={<img src={item.avatarUrl}/>}
                         name={<div className="a-name" title={item.name}>{item.name}</div>}
                         creator={<div className="tip">演员</div>}
                         itemWidth={115}
                         scale={1.4}
                         isFlex={false} />
              </li>
            )
          })
        }
        {
          holder((directors?directors.length:0) + (actors?actors.length:0),6).map((item)=>{
            return (
              <li> </li>
            )
          })
        }
      </ul>
    </ActorWrapper>
  )
}
export default memo(Actor);
