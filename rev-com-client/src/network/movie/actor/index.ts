import gbRequest from "../../index";
import {IResponseType} from "../../../types/responseType";
enum ActorApi{
  allActor="/actor/all"
}
//获取所有演员
export function getAllActor<T=IResponseType<any>>(page:number,limit:number){
  return gbRequest.get<T>({
    url:ActorApi.allActor,
    params:{
      page,
      limit
    }
  })
}
