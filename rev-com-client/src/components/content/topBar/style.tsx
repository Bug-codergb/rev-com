import styled from "styled-components";
export const TopBarWrapper=styled.div`
  height:68px;
  background-color: #f0f3f5;
`
export const CenterContent=styled.div`
  width: 92%;
  margin: 0 auto;
  height: 100%;
  /*border-left:1px solid pink ;
  border-right:1px solid pink ;*/
  display: flex;
  justify-content: space-between;
  .left-content{
    height: 100%;
    display: flex;
    align-items: center;
    width: 100%;
    .logo{
      width: 7%;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100%;
      img{
        width: 50%;
        vertical-align: center;
        border-radius: 5px;
      }
    }
    .nav{
      display: flex;
      height: 100%;
      &>li{
        height: 100%;
        padding: 0 20px;
        font-size: 18px;
        display: flex;
        align-items: center;
        color: #656565;
        font-weight:550;
        cursor: pointer;
        &.active{
          color: #00aeec;
        }
      }
    }
    .search-outer{
      background-color: #00aeec;
      border: 1px solid #00aeec;
      margin: 0 0 0 80px;
      width: 32%;
      display: flex;
      align-items: center;
      border-radius: 4px;
      overflow: hidden;
      background-clip: content-box;
      input{
        width: 86%;
        padding:7px 10px;
      }
      i{
        margin: 0 0 0 18px;
        color: #fff;
        font-size:20px;
        font-weight: bolder;
        cursor: pointer;
        flex: 1;
      }
    }
  }
  .right-content{
    display: flex;
    align-items: center;
  }
`
