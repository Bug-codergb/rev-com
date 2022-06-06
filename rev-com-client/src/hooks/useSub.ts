import {useSelector} from "react-redux";
import {Map} from "immutable";
import {ILogin} from "../types/login";
export function useSub(id:string):boolean{
  const login=useSelector<Map<string,ILogin>,ILogin>((state)=>{
    return state.getIn(['loginReducer','login']) as ILogin
  })
  const isExists=login.userDetail.subList.findIndex((item,index)=>{
    return item.comment?.id===id;
  })
  return isExists !== -1;
}
