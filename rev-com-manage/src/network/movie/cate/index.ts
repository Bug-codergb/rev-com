import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum MovieCate {
  allCate = "/movie/cate/all"
}
//获取所有分类
export function getAllCate<T = IResponseType<any>>() {
  return gbRequest.get<T>({
    url: MovieCate.allCate
  })
}
