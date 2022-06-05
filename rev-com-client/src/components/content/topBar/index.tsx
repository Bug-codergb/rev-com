import React, {FC, memo, ReactElement, useState} from "react";
import {useNavigate} from "react-router-dom"
import {
  TopBarWrapper,
  CenterContent
} from "./style"
import HomeRoutes from "../../../constant/routes/HomeRoutes";
import UserMsg from "./childCpn/userMsg";
import logo from "../../../assets/img/logo.png"
import Notice from "./childCpn/notice";

const TopBar:FC=():ReactElement=>{
  const [currentIndex,setCurrentIndex]=useState<number>(0);
  const navigate=useNavigate();
  const liClick=(item:{name:string,path:string},index:number)=>{
    setCurrentIndex(index);
    navigate(item.path,{
      replace:false
    })
  }
  return (
    <TopBarWrapper>
      <CenterContent>
        <div className="left-content">
          <div className="logo">
            <img src={logo}/>
          </div>
          <ul className="nav">
            {
              HomeRoutes.map((item,index)=>{
                return(
                  <li key={item.name} className={currentIndex===index?`active`:''} onClick={e=>liClick(item,index)}>
                    {item.name}
                  </li>
                )
              })
            }
          </ul>
          <div className="search-outer">
            <input type="text" placeholder="搜索电影 / 书籍 / 音乐 / 小组" maxLength={40}/>
            <i className="iconfont icon-search"> </i>
          </div>
        </div>
        <div className="right-content">
          <UserMsg/>
          <Notice/>
        </div>
      </CenterContent>
    </TopBarWrapper>
  )
}
export default memo(TopBar)
