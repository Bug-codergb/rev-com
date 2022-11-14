import { combineReducers } from 'redux-immutable';
import {reducer as loginReducer} from "../views/login/store/index"
const reducer = combineReducers({
  loginReducer,
});
export default reducer;
import { configureStore } from "@reduxjs/toolkit";
import {reducer as counterSlice} from "../view/login/store/index";

// configureStore创建一个redux数据
const store = configureStore({
  // 合并多个Slice
  reducer: {
    counter: counterSlice
  },
});

export default store;
import {createAsyncThunk} from '@reduxjs/toolkit';
import { IUserMsg } from './reducer';
async function getMovieListApi(id:string):Promise<IUserMsg>{
  return new Promise((resolve,reject)=>{
    setTimeout(()=>{
      resolve({
        userId:"100001",
        userName:"coder"
      })
    },500)
  })
}
const getMovieData = createAsyncThunk( 'movie/getMovie',  async (id:string) => {
    const res= await getMovieListApi(id);
    return res;
  }
);
export {
  getMovieData
}

import {counterSlice} from "./reducer"
const reducer = counterSlice.reducer;
export {
  reducer
}

import { createSlice } from '@reduxjs/toolkit';
import {
  getMovieData
} from "./asyncThunk"
export interface IUserMsg{
  userId:string,
  userName:string
}
export interface CounterState {
  value: number;
  title: string;
  userMsg:IUserMsg
}
const initialState: CounterState = {
  value: 0,
  title: "redux toolkit pre",
  userMsg:{
    userId:"",
    userName:""
  }
};


// 创建一个 Slice 
const counterSlice = createSlice({
  name: 'counter',
  initialState,
  // 定义 reducers 并生成关联的操作
  reducers: {
    // 定义一个加的方法
    increment: (state) => {
      state.value += 1;
    },
    // 定义一个减的方法
    decrement: (state) => {
      state.value -= 1;
    },
  },
  extraReducers:(builder)=>{
    const {addCase} = builder;
    addCase(getMovieData.fulfilled,(state,{payload})=>{
      state.userMsg = payload;
    })
  }
});

export { counterSlice };
