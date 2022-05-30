import React,{memo,FC,ReactElement} from "react";
import {
  FooterWrapper
}from "./style";
const Footer:FC=():ReactElement=>{
  return (
    <FooterWrapper>
      &copy;Rev-Com
    </FooterWrapper>
  )
}
export default memo(Footer);
