import styled from "styled-components";
export const ActorWrapper=styled.div`
  .actor-list{
    display: flex;
    justify-content: space-between;
    &>li{
      width: 115px;
      .tip{
        font-size: 13px;
        color:#9b9b9b;
        text-align: center;
      }
      .a-name{
        text-align: center;
      }
    }
  }
`
