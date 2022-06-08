import styled from "styled-components";
export const ReviewDetailWrapper=styled.div`
  display: flex;
  align-items: flex-start;
`
export const LeftContent=styled.div`
  width: 70%;
  .movie-name{
    font-size: 26px;
    font-weight: bolder;
    color: #494949;
  }
`
export const RightContent=styled.div`
  width: 29%;
  padding: 0 0 0 25px;
  .movie-cover{
    width: 100px;
    height: 150px;
    overflow: hidden;
    position: relative;
    margin: 0 0 15px 0;
    img{
      width: 100%;
      position: absolute;
      left: 50%;
      top: 50%;
      transform: translate(-50%,-50%);
    }
  }
  .directors,.actors,.dt,.releaseTime,.cate,.area{
    font-size: 13px;
    color: #111;
    display: flex;
    align-items: flex-start;
    margin: 0 0 4px 0;
    &>span{
      font-size: 13px;
      color: #111;
      margin: 0 5px 0 0;
    }
  }
`
