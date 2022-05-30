import styled from "styled-components";
export const FilterWrapper=styled.div`
.form-list,.cate-list,.area-list{
    display: flex;
    align-items: center;
    margin: 0 0 15px 0;
    flex-wrap: wrap;
    &>li{
      margin: 0 10px 0 0;
      padding: 4px 10px;
      font-size: 13px;
      cursor: pointer;
      &:nth-child(1){
        font-weight: bold;
        font-size: 14px;
        color: #656565;
        padding: 4px 10px 4px 0;
      }
      &.active{
        background-color: #00aeec;
        color: #fff;
        border-radius: 4px;
      }
    }
  }
`
