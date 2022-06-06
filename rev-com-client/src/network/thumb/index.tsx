import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum ThumbApi{
  thumb="/thumb",
  cancelThumb="/thumb/cancel"
}
//点赞
export function thumb<T=IResponseType<any>>(key:string,relateId:string){
  return gbRequest.post<T>({
    url:ThumbApi.thumb,
    params:{
      key,
      relateId
    }
  })
}
//取消点赞
export function cancelThumb<T=IResponseType<any>>(key:string,relateId:string){
  return gbRequest.post<T>({
    url:ThumbApi.cancelThumb,
    params:{
      key,
      relateId
    }
  })
}
