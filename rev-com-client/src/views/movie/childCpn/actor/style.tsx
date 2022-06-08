import styled from "styled-components";
export const ActorWrapper=styled.div`
  display: flex;
  align-items: flex-start;
`
export const LeftContent=styled.div`
  width: 70%;
  .actors{
    display: flex;
    justify-content: space-between ;
    flex-wrap: wrap;
    &>li{
      width: 150px;
      margin: 0 0 20px 0;
    }
  }
  .page{
    display: flex;
    justify-content: center;
    padding: 20px 0;
  }
`
export const RightContent=styled.div`
  width: 30%;
`
