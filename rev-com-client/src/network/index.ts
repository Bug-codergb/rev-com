import GBRequest from './request/index'
import {HOST_NAME} from "../constant/host";
import localCache from "../utils/cache"
const gbRequest = new GBRequest({
    baseURL:HOST_NAME,
    timeout: 10000,
    interceptors: {
        requestInterceptor: (config) => {
            const token = localCache.getCache("userMsg").token;
            if (localCache.getCache("userMsg")&&token && config.headers) {
                config.headers.Authorization = token
            }
            return config
        },
        requestInterceptorCatch: (err) => {
            return err
        },
        responseInterceptor: (res) => {
            return res
        },
        responseInterceptorCatch: (err) => {
            console.log(err)
            return err
        }
    }
})
export default gbRequest
