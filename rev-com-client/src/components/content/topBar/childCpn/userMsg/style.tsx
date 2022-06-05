import styled from "styled-components";
export const UserMsgWrapper=styled.div`
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  .avatar-container{
    width: 45px;
    height: 45px;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #dcdfe6;
    border-radius: 50%;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    i{
      font-size: 20px;
      font-weight: bolder;
    }
    img{
      width: 100%;
      position: absolute;
      left: 50%;
      top: 50%;
      transform: translate(-50%,-50%);
    }
  }

`

