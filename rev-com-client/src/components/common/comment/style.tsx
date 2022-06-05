import styled from "styled-components";

export const CommentWrapper = styled.div`
  width: 100%;
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
            align-items: center;
          }
          .right-info{
            .anticon{
              margin: 0 8px 0 0;
              cursor: pointer;
              color: #AAA;
            }
            svg{
              width: 16px;
              height: 16px;
              color: #AAA;
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
        .comment-from{
          margin: 10px 0 0 0;
          background-color: #f4f3f3;
          padding: 5px;
          &>span{
            font-size: 13px;
            color: #666666;
            &:nth-child(2){
              color: #008AC5;
              margin: 0 5px 0 4px;
            }
          }
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
          cursor: pointer;
        }
        .reply-control{
          display: flex;
          align-items: center;
          margin: 15px 0;
          .ant-input{
            height: 54px;
            width: 80%;
            resize: none;
          }
          .publish-btn{
            cursor: pointer;
            width: 52px;
            height:52px;
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
    }
  }
  .page{
    padding: 20px 0;
    display: flex;
    align-items: center;
    justify-content: center;
  }
`
