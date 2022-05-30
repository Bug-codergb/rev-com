import React,{memo,FC,ReactElement} from "react";
import {Outlet} from "react-router-dom"
import {
  HomeWrapper
} from "./style";
import TopBar from "../../components/content/topBar";
import Footer from "../../components/content/footer";
const Home:FC=():ReactElement=>{
  return (
    <HomeWrapper>
      <TopBar/>
      <div className="home-routes-content">
        <Outlet/>
      </div>
      <Footer/>
    </HomeWrapper>
  )
}
export default memo(Home);
