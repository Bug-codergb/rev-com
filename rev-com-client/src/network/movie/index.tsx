import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum MovieApi{
  allMovie="/movie/all",
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
