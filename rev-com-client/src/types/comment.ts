import {IUserMsg} from "./login";
import {IMovie} from "./movie/movie";

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
  movie:IMovie
}

export type {
  IComment
}
