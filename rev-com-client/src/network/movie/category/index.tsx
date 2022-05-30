import gbRequest from "../../index";
import {IResponseType} from "../../../types/responseType";
enum MovieCateApi{
  allCate="/movie/cate/all"
}
//获取所有电影分类
export function getAllCate<T=IResponseType<any>>(){
  return gbRequest.get<T>({
    url:MovieCateApi.allCate
  })
}
