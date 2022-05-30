interface IUserMsg{
  auth:number,
  avatarUrl:string,
  createTime:string,
  expireTime:string,
  filename:string,
  manage:number,
  mimetype:string,
  originalname:string,
  size:number,
  token:string,
  updateTime:string,
  userId:string,
  userName:string
}
interface IUserDetail{

}
interface ILogin{
 userMsg:IUserMsg,
 userDetail:IUserDetail,
 loginType:number
}
export type{
  IUserDetail,
  IUserMsg,
  ILogin
}
