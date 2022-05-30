import styled from "styled-components";
export const MsgItemWrapper:any=styled.div`
  position: relative;
  width: ${(props)=>(props as any).withProps+"px"};
  .img-container{
    width: ${(props)=>(props as any).withProps+"px"};
    height: ${(props) =>(props as any).widthProps * (props as any).scale + 'px'};
    overflow: hidden;
    border-radius: 3px;
    background-color: #f0f2f5;
    position: relative;
    .ant-image{
      height:${(props) =>(props as any).widthProps * (props as any).scale + 'px'} ;
    }
    img{
      width: 100%;
      position: absolute;
      left: 50%;
      top: 50%;
      transform: translate(-50%,-50%);
    }
  }
  .is-flex{
    display: flex;
    justify-content: space-between;
  }
  .state{
    margin: 10px 0 0 0;
  }
`
