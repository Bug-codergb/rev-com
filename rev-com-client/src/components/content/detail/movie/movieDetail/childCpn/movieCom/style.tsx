import styled from "styled-components";
export const MovieComWrapper=styled.div`
  margin: 20px 0 25px 0;
  .comment-name{
    color: #55a532;
    font-size: 16px;
    display: flex;
    align-items: center;
    margin: 0 0 5px 0;
    .total-comment{
      color: #667ec4;
      cursor: pointer;
    }
    .line{
      letter-spacing: 14px;
      margin: 0 5px;
      vertical-align: middle;
      display: flex;
      align-items: center;
    }
  }
  .more{
    color: #666699;
    margin: 15px 0;
    cursor: pointer;
    font-size: 13px;
    display: flex;
    align-items: center;
    &>span{
      margin: 0 0 0 5px;
      font-size: 13px;
    }
  }
  .empty-status{
    padding: 5px 0;
    svg{
      height: 48px;
      width: 48px;
    }
    .ant-empty-description{
      font-size: 13px;
    }
  }
`
