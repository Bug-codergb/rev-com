import styled from "styled-components";
export const WeekToplistWrapper=styled.div`
  .week-title{
    font-weight: bolder;
    font-size: 20px;
    color: #656565;
  }
  .movie-list{
    &>li{
      display: flex;
      align-items: center;
      border-bottom: 1px solid #eaeaea;
      padding: 10px 0;
      .week-movie-index{
        width: 30px;
      }
      .week-movie-name{
        color: #666699;
        cursor: pointer;
      }
    }
  }
`
