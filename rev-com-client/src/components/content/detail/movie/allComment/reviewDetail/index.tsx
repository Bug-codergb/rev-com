import React,{memo,FC,ReactElement} from "react";
import {
  ReviewDetailWrapper
} from "./style"
const ReviewDetail:FC=():ReactElement=>{
  return (
    <ReviewDetailWrapper>
      影评
    </ReviewDetailWrapper>
  )
}
export default memo(ReviewDetail);
