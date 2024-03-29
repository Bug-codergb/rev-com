import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum MovieApi{
  allMovie="/movie/all",
  movieDetail="/movie/detail",
  recentHot="/movie/hot/recent",
  newToplist="/movie/new/toplist",
  movieTop="/movie/top/200",
  weekToplist="/movie/week"
}
export function getAllMovie<T=IResponseType<any>>(form:string,cate:string,area:string,page:number,limit:number){
  return gbRequest.get<T>({
    url:MovieApi.allMovie,
    params:{
      form,
      cate,
      area,
      page,
      limit
    }
  })
}
export function getMovieDetail<T=IResponseType<any>>(id:string){
  return gbRequest.get<T>({
    url:MovieApi.movieDetail+"/"+id
  })
}
//获取近期热门
export function getRecentMovie<T=IResponseType<any>>(areaId:string,form:string){
  return gbRequest.get<T>({
    url:MovieApi.recentHot,
    params:{
      areaId,
      form
    }
  })
}
//获取新片榜单
export function getNewToplist<T=IResponseType<any>>(){
  return gbRequest.get<T>({
    url:MovieApi.newToplist
  })
}
export function getMovieTop<T=IResponseType<any>>(page:number,limit:number){
  return gbRequest.get<T>({
    url:MovieApi.movieTop,
    params:{
      page,
      limit
    }
  })
}
//获取一周榜单
export function getWeekToplist<T=IResponseType<any>>():Promise<T>{
  return gbRequest.get<T>({
    url:MovieApi.weekToplist
  })
}
