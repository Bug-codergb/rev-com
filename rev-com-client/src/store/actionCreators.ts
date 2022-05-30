import store from "./index";
import localCache from "../utils/cache"
import {changeUserMsg} from "../views/login/store/actionCreators";
store.dispatch(changeUserMsg(localCache.getCache("userMsg")))
export {}
