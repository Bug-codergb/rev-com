import GBRequest from "./request/index";
import { HOST_NAME } from "@/constant/host";
import { ElMessage } from "element-plus";
import localCache from "../utils/cache";
const gbRequest = new GBRequest({
  baseURL: HOST_NAME,
  timeout: 20000,
  interceptors: {
    requestInterceptor: (config) => {
      try {
        const token = localCache.getCache("userMsg").token;
        if (localCache.getCache("userMsg") && token && config.headers) {
          config.headers.Authorization = token;
        }
      } catch (e) {
        console.log(e);
      }
      return config;
    },
    requestInterceptorCatch: (err) => {
      return err;
    },
    responseInterceptor: (res) => {
      return res;
    },
    responseInterceptorCatch: (err) => {
      ElMessage({
        message: err.response?.data?.message,
        type: "warning"
      });
      return err;
    }
  }
});
export default gbRequest;
