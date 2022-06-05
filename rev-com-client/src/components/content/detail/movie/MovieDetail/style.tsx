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
     width: 50%;
     border-right: 1px solid #eaeaea;
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
   .right{
     padding: 0 0 0 15px;
     .tip{
       color: #9b9b9b;
       font-size: 13px;
     }
     .score-info{
       display: flex;
       align-items: center;
       .score{
         font-size: 28px;
         color: #494949;
         margin: 0 15px 0 0;
       }
       .score-star{
         .score-star-movie-detail{
           display: flex;
           align-items: center;
           .ant-rate-star{
             margin: 0 4px 0 0;
           }
           svg{
             width: 16px;
             height: 16px;

           }
         }
         .person-count{
           color: #3377AA;
           font-size: 12px;
         }
       }
     }
     .rate-percentage{
       margin: 15px 0 0 0;
       .one,.two,.three,.four,.five{
         display: flex;
         align-content: center;
         height: 18px;
         .start-name{
           font-size: 12px;
           color: #9b9b9b;
           width: 30px;
           height: 12px;
           line-height: 12px;
         }
         .start-value{
           width: 160px;
           display: flex;
           align-items: center;
           justify-content: space-between;
           height: 12px;
           .ant-progress{
             width: 115px;
           }
           .start-num-tip{
             font-size: 12px!important;
             color: #9b9b9b;
             margin: 0 0 0 2px;
             display: block;
             width: 40px!important;
           }
         }
         .ant-progress-bg{
           border-radius: 0;
         }
         .ant-progress-inner{
           border-radius: 0;
         }
         .ant-progress-outer{
           padding:0 5px!important;
           height: 12px;
           display: flex;
           align-items: center;
         }
         .ant-progress{
           display: flex;
           align-items: center;
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
