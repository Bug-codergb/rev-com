import styled from "styled-components";
export const MovieCommentEditWrapper=styled.div`
  .movie-simple-info{
    width: 78%;
    margin: 0 auto;
    background-color: #f8f8f8;
    padding: 0 15px;
  }
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
  .publish-tip{
    width: 78%;
    margin: 20px auto;
    color: #00aeec;
    font-weight: bolder;
  }
`
