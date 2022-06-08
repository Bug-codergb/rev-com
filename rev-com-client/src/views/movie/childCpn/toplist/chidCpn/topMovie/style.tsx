import styled from "styled-components";
export const TopMovieWrapper=styled.div`
  .top-tip{
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 60%;
    margin: 0 0 10px 0 ;
    .top-tip-200{
      color: #007722;
      font-size: 16px;
    }
    .more{
      color:#666699;
      font-size: 12px;
      cursor: pointer;
    }
  }
  .top-movie-list{
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    &>li{
      width: 68px;
      margin: 0 0 20px 0;
      .movie-name-state{
        font-size: 13px;
        color:#3377AA;
        cursor: pointer;
      }
    }
  }
`
