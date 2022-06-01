import styled from "styled-components";
export const CommentEditWrapper=styled.div`
  .score{
    width: 78%;
    margin: 0 auto;
    display: flex;
    align-items: center;
    &>span{
      font-size: 13px;
      margin: 0 5px 0 0;
    }
    .rate-style{
      display: flex;
      align-items: center;
      svg{
        height: 22px;
        width: 22px;
      }
    }
    .rate-status{
      font-size: 13px;
      margin: 0 0 0 8px;
      color: #656565;
    }
  }
  .comment-pub{
    display: flex;
    align-items:center;
    width:76%;
    justify-content: space-between;
    margin: 30px auto;
  }
  .comment-title{
    border-bottom: 1px solid #cccccc;
    font-weight: bolder;
    font-size: 20px;
    width: 100%;
    margin: 0 0 20px 0;
    display: block;
    padding: 0 0 10px 20px;
    text-align: center;
  }
  .control-btn{
    display: flex;
    justify-content: flex-end;
    width: 76%;
    margin:20px auto;
    &>button{
    background-color: #00aeec;
    color: #fff;
    padding: 5px 15px;
    border-radius: 4px;
    cursor: pointer;
    }
  }
`
