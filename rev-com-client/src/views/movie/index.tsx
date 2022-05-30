import React,{memo,FC,ReactElement} from "react";
import {Outlet} from "react-router-dom"
import {
  MovieWrapper
}from "./style";
import NavBar from "../../components/content/navBar";
import MovieRoutes from "../../constant/routes/movieRoutes";
const Movie:FC=():ReactElement=>{
  return (
    <MovieWrapper>
      <NavBar navList={MovieRoutes}/>
      <div className="movie-routes-content">
        <Outlet/>
      </div>
    </MovieWrapper>
  )
}
export default memo(Movie);
