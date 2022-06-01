import {IUserMsg} from "./login";

interface IComment {
  id: string,
  content: string,
  title: string,
  user: IUserMsg,
  score: number,
  isShort: number,
  reply: IComment,
  createTime: string,
  updateTime: string,
}

export type {
  IComment
}
