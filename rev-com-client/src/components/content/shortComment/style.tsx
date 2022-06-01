import styled from "styled-components";
export const ShortCommentWrapper=styled.div`
  .score{
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
  .comment-content{
    margin: 20px 0 0 0;
  }
`
