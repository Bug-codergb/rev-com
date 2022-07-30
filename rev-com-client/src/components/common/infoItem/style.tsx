import styled from "styled-components";
export const InfoItemWrapper=styled.div`
  .info-title{
    color: #494949;
    font-size: 25px;
    display: flex;
    align-items: center;
    .info-name ,.info-english-name{
      color: #494949;
      font-size: 25px;
      font-weight: bolder;
      margin: 0 15px 0 0;
    }
  }
`
export const LeftContentWrapper=styled.div`
  margin: 0 1rem 0 0;
  .img-container{
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #f0f2f5;
  }
`
export const RightContentWrapper=styled.div`
  .key,.value{
    margin: 0 0.5rem 0 0;
    font-size: 13px;
    color: #666;
  }
  .value{
    color: #111;
  }
`
export const Container=styled.div`
  display: flex;
  align-items: flex-start;
  margin: 1.2rem 0 0 0;
`
