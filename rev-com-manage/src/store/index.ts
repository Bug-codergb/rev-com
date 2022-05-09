import { createStore } from "vuex"
import { IRootState } from "@/types/store/root"
import loginModule from "@/store/login"
const store = createStore<IRootState>({
  state() {
    return {
      name: ""
    }
  },
  mutations: {},
  actions: {},
  modules: {
    login: loginModule
  }
})
store.dispatch({
  type: "login/setupStoreAction"
})
export default store
