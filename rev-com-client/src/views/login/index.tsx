import React, {FC, memo, ReactElement, FormEvent, useState} from "react";
import {useNavigate} from "react-router-dom"
import {useDispatch} from "react-redux";
import { message } from 'antd';
import {
  LoginWrapper
} from "./style"
import {loginAction} from "./store/actionCreators";
import {Dispatch} from "redux";

const Login:FC=():ReactElement=>{
  const [userName,setUserName]=useState<string>("");
  const [password,setPass]=useState<string>("");

  const dispatch=useDispatch<Dispatch<any>>();
  const navigate=useNavigate();
  const userNameInp=(e:FormEvent<HTMLInputElement>)=>{
    setUserName(e.currentTarget.value);
  }
  const passwordInp=(e:FormEvent<HTMLInputElement>)=>{
    setPass(e.currentTarget.value);
  }
  const loginClick=()=>{
    if(userName.trim().length===0){
      message.warn({
        content:"用户名不能为空",
        className:"global-tip",
      })
    }else if(password.trim().length===0){
      message.warn({
        content:"密码不能为空",
        className:"global-tip",
      })
    }else{
      dispatch(loginAction(userName,password,navigate));
    }
  }
  return (
    <LoginWrapper>
      <div className="login-outer">
        <div className="no-account">
          <span>还没有账号?</span>
          <span>注册</span>
        </div>
        <div className="login-btn">
          <button onClick={e=>loginClick()}>登录</button>
        </div>
        <div className="password-outer">
          <input type="text" placeholder="请输入密码" onInput={(e)=>passwordInp(e)}/>
        </div>
        <div className="userName-outer">
          <input type="text" placeholder="请输入用户名" onInput={(e)=>userNameInp(e)}/>
        </div>
        <div className="system-title">
          Rec-Com账号登录
        </div>
      </div>
    </LoginWrapper>
  )
}
export default memo(Login);
