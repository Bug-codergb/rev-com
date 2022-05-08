import GBRequest from './request/index'
import {HOST_NAME} from "../constant/host";
const gbRequest = new GBRequest({
    baseURL:HOST_NAME,
    timeout: 10000,
    interceptors: {
        requestInterceptor: (config) => {
            /*const token = localCache.getCache('token')
            if (token && config.headers) {
                config.headers.Authorization = token
            }*/
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
