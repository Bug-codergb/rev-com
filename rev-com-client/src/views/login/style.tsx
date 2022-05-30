import styled from "styled-components";
export const LoginWrapper=styled.div`
 width:100%;
 height:100%;
 position:relative;
 .login-outer{
   position: absolute;
   left: 60%;
   top: 15%;
   width: 28%;
   height: 60%;
   box-shadow: 0 0 20px rgba(0,0,0,.2);
   display: flex;
   align-items: center;
   justify-content: flex-end;
   flex-direction: column-reverse;
   border-radius:2% ;
   .password-outer,.userName-outer{
     margin: 0 0 26px 0;
     width: 70%;
     input{
       border: 1px solid #00aeec;
       font-size: 14px;
       padding:13px 15px;
       width: 100%;
       border-radius: 3px;
     }
   }
   .login-btn{
     width: 70%;
     margin: 20px 0 0 0;
     button{
       display: block;
       width: 100%;
       background-color: #00aeec;
       color: #fff;
       font-size: 14px;
       padding: 12px 0;
       cursor: pointer;
       border-radius: 4px;
     }
   }
   .system-title{
     font-size: 26px;
     font-weight: bold;
     color: #656565;
     margin: 40px 0 ;
   }
   .no-account{
     width: 70%;
     margin: 20px 0 0 0;
     display: flex;
     justify-content: flex-end;
     span{
       color: #656565;
       font-size: 15px;
       &:nth-child(2){
         color: #00aeec;
         margin: 0 0 0 4px;
         cursor: pointer;
       }
     }
   }
 }
`
