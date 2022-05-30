import {login} from "../../../network/login";
import {IResponseType} from "../../../types/responseType";
import {IUserMsg} from "../../../types/login";
import localCache from "../../../utils/cache"
import {NavigateFunction} from "react-router/lib/hooks";
export function changeUserMsg(userMsg:IUserMsg){
  return {
    type:"changeUserMsg",
    userMsg:userMsg
  }
}
export function changeLoginType(loginType:number){
  return{
    type:"changeLoginType",
    loginType:loginType
  }
}
export function loginAction(userName:string,password:string,navigate:NavigateFunction){
  return async(dispatch:any)=>{
    try{
      const data:IResponseType<any>=await login(userName,password);
      if(data.status===200){
        await dispatch(changeUserMsg(data.data));
        localCache.setCache("userMsg",data.data);
        localCache.setCache("loginType",1)
        navigate("/Home",{
          replace:true,
        })
      }
    }catch (e) {

    }
  }
}
