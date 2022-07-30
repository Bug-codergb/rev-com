import React,{memo,ReactElement} from "react";
import { Image } from "antd";
import holder from "../../../assets/img/holder/movie.png";
import {
  InfoItemWrapper,
  LeftContentWrapper,
  RightContentWrapper,
  Container
} from "./style";
interface IProps{
  name:string,
  english?:string,
  imgURL?:string,
  imgWidth?:number,
  scale?:number,
  info:any,
}
const InfoItem=memo(function InfoItem<T>(props:IProps):ReactElement{
  const {name="暂无名称",english="no foreign name",imgURL,imgWidth,scale,info}=props;
  return (
    <InfoItemWrapper>
      <div className="info-title">
        <div className="info-name">
          {name}
        </div>
        <div className="info-english-name">
          {english}
        </div>
      </div>
      <Container>
        <LeftContentWrapper>
          <div className="img-container" style={{height:scale?`${scale*(imgWidth??120)}px`:'150px'}}>
            <Image
              width={imgWidth??120}
              src={imgURL}
              preview={false}
              placeholder={
                <Image
                  preview={false}
                  src={holder}
                  width={imgWidth??120}
                />
              }
            />
          </div>
        </LeftContentWrapper>
        <RightContentWrapper>
          {
            Object.keys(info).map((item,index)=>{
              return (
                <div key={item}>
                  <span className="key">{item}：</span>
                  <span className="value">
                    {
                      Array.isArray(info[item])?
                        info[item].map((item:any)=>item.name).join(" / "):
                        info[item].toString()
                    }
                  </span>
                </div>
              )
            })
          }
        </RightContentWrapper>
      </Container>
    </InfoItemWrapper>
  )
})
export default InfoItem;
