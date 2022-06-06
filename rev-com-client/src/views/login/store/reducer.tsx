import {Map} from "immutable";
import {ILogin} from "../../../types/login";
const defaultState=Map<ILogin>({
  login:{
    userMsg:{
      auth:0,
      avatarUrl:"",
      createTime:"",
      expireTime:"",
      filename:"",
      manage:0,
      mimetype:"",
      originalname:"",
      size:0,
      token:"",
      updateTime:"",
      userId:"",
      userName:""
    },
    userDetail:{
      auth:0,
      avatarUrl:"",
      createTime:"",
      expireTime:"",
      filename:"",
      manage:0,
      mimetype:"",
      originalname:"",
      size:0,
      token:"",
      updateTime:"",
      userId:"",
      userName:"",
      thumbList:[],
      subList:[]
    },
    loginType:0
  }
})
const reducer=(state=defaultState,action:any)=>{
  switch (action.type){
    case "changeUserMsg":
      return state.setIn(['login','userMsg'],action.userMsg);
    case "changeLoginType":
      return state.setIn(['login','loginType'],action.loginType);
    case "changeUserDetail":
      return state.setIn(['login','userDetail'],action.userDetail);
    default:
      return state;
  }
}
export default reducer;
