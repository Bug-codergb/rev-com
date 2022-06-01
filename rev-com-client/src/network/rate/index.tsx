import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum RateApi{
  movieRate="/rate/movie"
}
//获取电影评分信息
export function getMovieRate<T=IResponseType<any>>(id:string){
  return gbRequest.post<T>({
    url:RateApi.movieRate+"/"+id
  })
}
