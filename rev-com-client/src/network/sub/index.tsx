import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum SubscriberApi{
  sub="/sub",
  cancelSub="/sub/cancel"
}
//点赞
export function sub<T=IResponseType<any>>(key:string,relateId:string){
  return gbRequest.post<T>({
    url:SubscriberApi.sub,
    params:{
      key,
      relateId
    }
  })
}
//取消点赞
export function cancelSub<T=IResponseType<any>>(key:string,relateId:string){
  return gbRequest.post<T>({
    url:SubscriberApi.cancelSub,
    params:{
      key,
      relateId
    }
  })
}
