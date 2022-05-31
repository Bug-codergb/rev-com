import styled from "styled-components";
export const MovieDetailWrapper=styled.div`
  display: flex;
  align-items: flex-start;
`
export const LeftContent=styled.div`
  border-right: 1px solid pink;
  padding: 0 15px 0 0;
  width: 70%;
  .movie-title{
    .movie-name,.movie-alias{
      font-size: 26px;
      color: #494949;
      font-weight: bolder;
      margin: 0 8px 0 0;
    }
    .movie-time{
      color: #888;
      font-size: 26px;
      margin: 0 0 0 5px;
      font-weight: bolder;
    }
  }
  .movie-info{
    margin: 15px 0 0 0;
    display: flex;
    align-items: flex-start;
    .left{
      .img-container{
        width: 135px;
        height: 200px;
        position: relative;
        background-color: #f0f2f5;
        img{
          position: absolute;
          left: 50%;
          top: 50%;
          transform: translate(-50%,-50%);
          width: 100%;
       }
     }
   }
   .center{
     margin: 0 0 0 15px;
     .info-list{
       .item{
         margin: 0 0 7px 0;
         display: flex;
         align-items: center;
         .key{
           font-size: 13px;
           color: #666;
           margin: 0 4px 0 0;
         }
         .value{
           color: #111;
           font-size: 13px;
           &>span{
             font-size: 13px;
           }
           &.link{
             color: #3377aa;
             font-size: 13px;
           }
         }
       }
     }
   }
  }
  .operator{
      display: flex;
      align-items: center;
      margin: 10px 0 20px 0;
     .want-see{
       padding: 3px 15px;
       background-color: rgba(0, 174, 236,.2);
       color: rgb(0, 174, 236);
       font-size: 13px;
       border-radius: 5px;
     }
     .saw{
       padding: 3px 15px;
       font-size: 13px;
       background-color: rgba(0, 174, 236,.2);
       color: rgb(0, 174, 236);
       margin: 0 10px;
       border-radius: 5px;
      }
     .rate{
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
           height: 20px;
           width: 20px;
         }
       }
       .rate-status{
         font-size: 13px;
         margin: 0 0 0 8px;
         color: #656565;
       }
     }
   }
   .write-comment{
     margin: 0 0 20px 0;
     display: flex;
     align-items: center;
     .comment,.add{
       margin: 0 10px 0 0;
       display: flex;
       align-items: center;
       cursor: pointer;
       .tip{
         margin: 0 5px 0 5px;
         color: #3377aa;
       }
     }
   }
`
export const  RightContent= styled.div`
  width: 29%;
`
