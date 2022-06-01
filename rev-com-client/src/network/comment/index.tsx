import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum CommentApi{
  publishCom="/comment/publish",
  allShortCom="/comment/short/all",
  allComment="/comment/all"
}
//发布评论
/*
* id 由于富文本编辑器，评论id由前端生成，
* relateId 评论项的id如电影id，书籍id
* */
export function publishComment<T=IResponseType<any>>(id:string,content:string,key:string,
                                                     relateId:string,isShort:number,title?:string,score?:number){
  return gbRequest.post<T>({
    url:CommentApi.publishCom,
    params:{
      key,
    },
    data:{
      id,
      content,
      relateId,
      title,
      score,
      isShort
    }
  })
}
//获取所有短评
export function getAllShortCom<T=IResponseType<any>>(page:number,limit:number,key:string,relateId:string){
  return gbRequest.get<T>({
    url:CommentApi.allShortCom,
    params:{
      page,
      limit,
      key,
      relateId
    }
  })
}
//获取所有影评
export function getAllComment<T=IResponseType<any>>(page:number,limit:number,key:string,relateId:string){
  return gbRequest.get<T>({
    url:CommentApi.allComment,
    params:{
      page,
      limit,
      key,
      relateId
    }
  })
}
