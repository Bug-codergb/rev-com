import styled from "styled-components";
export const HotReviewWrapper=styled.div`
  .review-title{
    display: flex;
    align-items: center;
    .title{
      font-size: 16px;
      margin: 0 15px 0 0;
    }
    .more{
      font-size: 13px;
      color: #666699;
      cursor: pointer;
    }
  }
  .review-list{
    &>li{
      display: flex;
      align-items: flex-start;
      padding: 20px 0;
      border-bottom: 1px solid #eaeaea;
      .img-container{
        width: 68px;
        height: 100px;
        position: relative;

        img{
          position: absolute;
          left: 50%;
          top: 50%;
          width: 100%;
          transform: translate(-50%,-50%);
        }
      }
      .right-msg{
        margin: 0 0 0 15px;
        width: 85%;
        .review-title{
          font-size: 14px;
          color: #3377AA;
          margin: 0 0 10px 0;
          cursor: pointer;
        }
        .user-creator{
          display: flex;
          align-items: center;
          .user{
            display: flex;
            align-items: center;
            &>span{
              font-size: 13px;
              color: #666666;
              &:nth-child(1){
                margin: 0 4px 0 0;
              }
              &:nth-child(2){
                margin: 0 5px 0 0;
              }
            }
          }
          .rate{
            margin: 0 0 0 5px;
            .rate-style{
              display: flex;
              align-items: center;
              &>li{
                margin: 0 4px 0 0;
              }
            }
          }
        }
        .review-content{
          width: 100%;
          margin: 5px 0 0 0;
          height: 63px;
          overflow-y: hidden;
          img{
            display: none;
          }
        }
      }
    }
  }
`
