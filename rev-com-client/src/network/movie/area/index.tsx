import gbRequest from "../../index";
import {IResponseType} from "../../../types/responseType";
enum MovieAreaApi{
  allArea="/movie/area/all"
}
//获取所有电影形式
export function getAllMovieArea<T=IResponseType<any>>(){
  return gbRequest.get<T>({
    url:MovieAreaApi.allArea
  })
}
