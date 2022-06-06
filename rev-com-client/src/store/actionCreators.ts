import store from "./index";
import localCache from "../utils/cache"
import {changeUserDetail, changeUserMsg} from "../views/login/store/actionCreators";
store.dispatch(changeUserMsg(localCache.getCache("userMsg")))
store.dispatch(changeUserDetail(localCache.getCache("userDetail")));
export {}
