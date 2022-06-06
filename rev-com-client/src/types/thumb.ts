import {IUserMsg} from "./login";
import {IComment} from "./comment";

interface IThumb{
  id:string,
  user:IUserMsg,
  comment:IComment,
  createTime:string,
  updateTime:string
}
export type{
  IThumb
}
