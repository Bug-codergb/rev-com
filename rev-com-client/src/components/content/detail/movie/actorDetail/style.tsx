import styled from "styled-components";
export const ActorDetailWrapper=styled.div`
  display: flex;
  align-items: flex-start;
`
export const LeftContentWrapper=styled.div`
  width: 70%;
  .sub{
    background-color: #fff3e7;
    font-size: 13px;
    padding: 4px 15px;
    margin: 0.8rem 0 0 0;
    border-radius: 4px;
    border: 1px solid #e7d7ca;
    cursor: pointer;
  }
  .line{
    border-top: 1px dotted #dddddd;
    margin: 1rem 0;
  }
  .desc{
    .desc-title{
      margin: 0 0 0.5rem;
    }
    .desc-content{
      color: #111111;
      font-size: 13px;
      text-indent: 2em;
      text-align: justify;
    }
  }
`
export const RightContentWraper=styled.div`
  width: 29%;
`
