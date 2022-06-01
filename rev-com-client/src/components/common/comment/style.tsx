import styled from "styled-components";

export const CommentWrapper = styled.div`
  .comment-list{
    &>li{
      display: flex;
      align-items: flex-start;
      padding: 10px 0;
      border-bottom: 1px solid #efefef;
      .left-content{
        width: 35px;
        height: 35px;
        position: relative;
        border-radius: 50%;
        overflow: hidden;
        background-color: #656565;
        img{
          position: absolute;
          transform: translate(-50%,-50%);
          left: 50%;
          top: 50%;
          width: 100%;
        }
      }
      .right-content{
        width: 94%;
        margin: 0 0 0 10px;
        .info{
          display: flex;
          align-items: center;
          margin: 0 0 10px 0;
          justify-content: space-between;
          width: 100%;
          .left-info{
            display: flex;
          }
          .right-info{
            svg{
              width: 16px;
              height: 16px;
              color: #666666;
            }
          }
          &>span{
           font-size: 13px;
           margin: 0 5px 0 0;
         }
         .rate{
           margin: 0 10px;
         }
         .rate-style{
           display: flex;
           align-items: center;
           &>li{
             margin-right: 4px;
           }
           svg{
             height: 14px;
             width: 14px;
           }
         }
        }
        .user-name{
          color: #3377AA;
          font-size: 13px;
        }
        .create-time{
          color: #aaaaaa;
          font-size: 13px;
        }
        .comment-content{
          line-height: 22px;
          font-size: 13px;
          color: #666;
          img{
            display: none;
          }
        }
        .comment-title{
          color: #666699;
          margin: 5px 0 15px 0;
        }
      }
    }
  }
`
