import gbRequest from "../../index";
import {IResponseType} from "../../../types/responseType";
enum MovieFormApi{
  allForm="/movie/form/all"
}
//获取所有形式
export function getAllMovieForm<T=IResponseType<any>>(){
  return gbRequest.get<T>({
    url:MovieFormApi.allForm
  })
}
