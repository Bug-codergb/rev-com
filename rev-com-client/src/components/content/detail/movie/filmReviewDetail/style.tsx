import styled from "styled-components";
export const FilmReviewDetailWrapper=styled.div`
  display: flex;
  align-items: flex-start;
  .comment-title{
    font-size: 26px;
    font-weight: bolder;
    color: #494949;
  }
  .comment-info{
    display: flex;
    align-items: center;
    margin: 0 0 20px 0;
    .user-msg{
      display: flex;
      align-items: center;
      .img-container{
        width: 40px;
        height: 40px;
        position: relative;
        background-color: #656565;
        overflow: hidden;
        border-radius: 50%;
        img{
          position: absolute;
          left: 50%;
          top: 50%;
          transform: translate(-50%,-50%);
          width: 100%;
        }
      }
      .user-name{
        font-size: 13px;
        color: #3377aa;
        margin: 0 5px;
      }
    }
    .rate{
      display: flex;
      align-items: center;
      margin: 0 0 0 10px;
      .ant-rate-star:not(:last-child) {
        margin-right: 4px;
      }
      .rate-style{
        display: flex;
        align-items: center;
      }
    }
    .create-time{
      font-size: 13px;
      color: #999999;
      margin: 0 0 0 50px;
    }
  }
`
export const LeftContent=styled.div`
  width: 68%;
  .movie-name{
    &>span{
      font-size: 13px;
      color: #9b9b9b;
      &:nth-child(2){
        color: #666699;
        margin: 0 0 0 5px;
      }
    }
  }
  .comment-content{
    img{
      max-width: 92%;
    }
  }
  .control{
    display: flex;
    align-items: center;
    .thumb,.sub{
      margin: 0 15px 0 0;
      border: 1px solid #00aeec;
      padding: 3px 15px;
      display: flex;
      align-items: center;
      cursor: pointer;
      border-radius: 3px;
      svg{
        width: 18px;
        height: 18px;
        color: #00aeec;
      }
      .count{
        margin: 0 0 0 4px;
        color: #00aeec;
      }
    }
  }
  .comment-publish-outer{
    display: flex;
    align-items: flex-start;
    margin: 30px 0 20px;
    .img-container{
      width: 60px;
      height: 60px;
      background-color: #404040;
      position: relative;
      overflow: hidden;
      margin: 0 20px 0 0;
      border-radius: 4px;
      img{
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
        width: 100%;
      }
    }
    .right-msg{
      flex: 1;
      display: flex;
      align-items: center;
      .ant-input{
        height: 80px;
        width: 80%;
        resize: none;
      }
      .publish-btn{
        cursor: pointer;
        width: 65px;
        height:65px;
        background-color: #00aeec;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #fff;
        margin: 0 0 0 10px;
        border-radius: 4px;
      }
    }
  }
`
export const RightContent=styled.div`
  width: 29%;
  padding: 0 0 0 20px;
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
