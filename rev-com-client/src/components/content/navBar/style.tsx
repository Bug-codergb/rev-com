import styled from "styled-components";
export const NavBarWrapper=styled.div`
  background-color: #545652;
  height: 40px;
`
export const CenterContent=styled.div`
  width: 92%;
  margin: 0 auto;
  height: 100%;
  padding: 0 0 0 116px;//需要优化
  .movie-nav-list{
    display: flex;
    align-items: center;
    height: 100%;
    &>li{
      padding: 5px 15px;
      height: 100%;
      font-size: 13px;
      color: #fff;
      cursor: pointer;
      display: flex;
      align-items: center;
      &.active{
        background-color: #00aeec;
      }
    }
  }
`
