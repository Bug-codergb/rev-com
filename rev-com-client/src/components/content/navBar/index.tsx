import React, {memo, FC, ReactElement, useState} from "react";
import {useNavigate} from "react-router"
import {
  NavBarWrapper,
  CenterContent
}from "./style";
interface IProps{
  navList:{name:string,path:string}[]
}
const NavBar:FC<IProps>=(props):ReactElement=>{
  const {navList}=props;
  const [currentIndex,setCurrentIndex]=useState<number>(0);
  const navigate=useNavigate();
  const liClick=(item:{name:string,path:string},index:number)=>{
    setCurrentIndex(index);
    navigate(item.path,{
      replace:true
    })
  }
  return (
    <NavBarWrapper>
      <CenterContent>
        <ul className="movie-nav-list">
          {
            navList.map((item,index)=>{
              return (
                <li key={item.name} className={currentIndex===index?"active":""} onClick={e=>liClick(item,index)}>
                  {item.name}
                </li>
              )
            })
          }
        </ul>
      </CenterContent>
    </NavBarWrapper>
  )
}
export default memo(NavBar);
