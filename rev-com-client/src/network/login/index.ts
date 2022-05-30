import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum loginApi {
    login = '/login',
}
export function login<T=IResponseType<any>>(userName:string,password:string){
    return gbRequest.post<T>({
        url:loginApi.login,
        data:{
          userName,
          password
        }
    })
}
