import gbRequest from "../index";
import {IResponseType} from "../../types/responseType";
enum CommentApi{
  publishCom="/comment/publish",
  allShortCom="/comment/short/all",
  allComment="/comment/all",
  commentDetail="/comment/detail/",
  replyComment="/comment/reply",
  allReply="/comment/reply/all/",
  hotReview="/comment/movie/review/hot" //受欢迎的影评（电影首页）
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
//获取评论详情(影评)
export function getCommentDetail<T=IResponseType<any>>(id:string){
  return gbRequest.get<T>({
    url:CommentApi.commentDetail+id,
  })
}
//回复评论
export function replyComment<T=IResponseType<any>>(content:string,replyId:string){
  return gbRequest.post<T>({
    url:CommentApi.replyComment,
    data:{
      content,
      replyId
    }
  })
}
//获取影评回复
export function getAllCommentReply<T=IResponseType<any>>(id:string,page:number,limit:number){
  return gbRequest.get<T>({
    url:CommentApi.allReply+id,
    params:{
      page,
      limit
    }
  })
}
//获取受欢迎的影评
export function getHotReview<T=IResponseType<any>>(page:number,limit:number){
  return gbRequest.get<T>({
    url:CommentApi.hotReview,
    params:{
      page,
      limit
    }
  })
}
