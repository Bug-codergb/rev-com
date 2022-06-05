import styled from "styled-components";
export const HotWrapper=styled.div`
  .header{
    display: flex;
    align-items: flex-end;
    justify-content: space-between;
    border-bottom: 1px solid #eaeaea;
    padding: 0 0 10px 0;
    .left-header{
      display: flex;
      align-items:center;
      .header-name{
        color: #111;
        font-size: 16px;
        margin: 0 20px 0 0;
      }
      .cate-list{
        display: flex;
        align-items: center;
        &>li{
          cursor: pointer;
          color: #9b9b9b;
          font-size: 13px;
          margin: 0 12px 0 0;
          &.active{
           color: #00aeec;
          }
        }
      }
    }
    .right-header{
      color: #666699;
      font-size: 13px;
    }
  }
  .movie-list{
    display: flex;
    justify-content: space-between;
    margin:15px 0 0 0;
    flex-wrap:wrap ;
    &>li{
      width: 124px;
      margin: 0 0 20px 0;
      .movie-name-state{
        color: #3377AA;
        font-size: 13px;
      }
      .movie-score{
        color: #e09015;
      }
    }
  }
`
