import { Module } from "vuex"
import { IRootState } from "@/types/store/root"
import { IUser, IUserMsg } from "@/types/user"
import { login } from "@/network/login"
import { IResponseType } from "@/types/responseType"
import localCache from "../../utils/cache"
const loginModule: Module<IUserMsg, IRootState> = {
  namespaced: true,
  state: () => {
    return {
      userMsg: {
        userId: "",
        userName: "",
        password: "",
        token: "",
        avatarUrl: "",
        createTime: "",
        updateTime: "",
        auth: 0,
        manage: 0,
        expireTime: "",
        originalname: "",
        mimetype: "",
        dest: "",
        filename: "",
        size: 0
      }
    }
  },
  mutations: {
    changeUserMsg(state, payload) {
      state.userMsg = payload.userMsg
    }
  },
  actions: {
    loginAction(context, payload) {
      const { userName, password } = payload
      return new Promise((resolve, reject) => {
        login<IResponseType<IUser>>(userName, password)
          .then((data) => {
            if (data && Object.keys(data).length !== 0) {
              if (data.status === 200) {
                context.dispatch({
                  type: "changeUerMsgAction",
                  userMsg: data.data
                })
                resolve(data.data)
              }
            }
          })
          .catch((err) => {
            console.log(err)
            reject(err)
          })
      })
    },
    changeUerMsgAction(context, payload) {
      context.commit({
        type: "changeUserMsg",
        userMsg: payload.userMsg
      })
      localCache.setCache("userMsg", payload.userMsg)
    },
    setupStoreAction({ commit }) {
      const userMsg = localCache.getCache("userMsg")
      commit({
        type: "changeUserMsg",
        userMsg: userMsg
      })
    }
  }
}
export default loginModule
