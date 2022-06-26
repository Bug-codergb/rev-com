import styled from "styled-components";
export const VideoWrapper=styled.div`
  display: flex;
  align-items: flex-start;
  .movie-list{
    width: 100%;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    margin: 20px 0 0 0;
    &>li{
      margin: 0 4px 20px 0;
      width: 120px;
      .score{
        color: #e09015;
      }
      .movie-name{
        display: block;
        width: 80%;
      }
    }
  }
`
export const LeftContent=styled.div`
  width: 70%;
`
export const RightContent=styled.div`
  width: 30%;
`
