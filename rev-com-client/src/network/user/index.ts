import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum UserApi{
  userDetail="/user/detail/"
}
//获取用户详情
export function getUserDetail<T=IResponseType<any>>(userId:string){
  return gbRequest.get<T>({
    url:UserApi.userDetail+userId
  })
}
