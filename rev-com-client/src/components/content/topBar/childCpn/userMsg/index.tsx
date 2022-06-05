import React,{memo,FC,ReactElement} from "react";
import {useSelector} from "react-redux";
import {Map} from "immutable";
import {Menu,Dropdown } from 'antd';
import {
  UserMsgWrapper,
}from "./style";

import {ILogin} from "../../../../../types/login";
const menu=(
    <Menu
      items={[
        {
          key: '1',
          label: (
            <div className="profile">
              个人中心
            </div>
          ),
        },
        {
          key: '2',
          label: (
            <div className="exit">
              退出登录
            </div>
          ),
        },
      ]}
    />
);

const UserMsg:FC=():ReactElement=>{
  const login=useSelector<Map<string,ILogin>,ILogin>((state)=>{
    return state.getIn(['loginReducer','login']) as ILogin
  })
  return (
    <UserMsgWrapper>
      <Dropdown overlay={menu} placement="bottomRight" arrow>
        <div className="avatar-container">
          {
            !login.userMsg.avatarUrl&&<i className="iconfont icon-user"> </i>
          }
          {
            login.userMsg.avatarUrl&&<img src={login.userMsg.avatarUrl} alt={login.userMsg.userName}/>
          }
        </div>
      </Dropdown>
    </UserMsgWrapper>
  )
}
export default memo(UserMsg);
