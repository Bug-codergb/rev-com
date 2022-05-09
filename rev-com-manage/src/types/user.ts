interface IUser {
  userId: string
  userName: string
  password: string
  token: string
  avatarUrl: string
  createTime: string
  updateTime: string
  auth: number
  manage: number
  expireTime: string
  originalname: string
  mimetype: string
  dest: string
  filename: string
  size: number
}
interface IUserMsg {
  userMsg: IUser
}
export { IUser, IUserMsg }
