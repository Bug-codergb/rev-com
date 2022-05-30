import React,{memo,FC,ReactElement} from "react";
import {Menu,Dropdown } from 'antd';
import {
  UserMsgWrapper,
}from "./style";
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

  return (
    <UserMsgWrapper>
      <Dropdown overlay={menu} placement="bottomRight" arrow>
        <div className="avatar-container">
          <i className="iconfont icon-user"> </i>
        </div>
      </Dropdown>
    </UserMsgWrapper>
  )
}
export default memo(UserMsg);
