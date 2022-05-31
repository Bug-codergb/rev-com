import styled from "styled-components";
export const VideoWrapper=styled.div`
  .movie-list{
    width: 100%;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    margin: 20px 0 0 0;
    &>li{
      margin: 0 0 20px 0;
      width: 150px;
      .score{
        color: #e09015;
      }
    }
  }
`
