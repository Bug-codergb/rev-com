import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";
enum BookCateApi {
  allCate = "/book/cate/detail/all",
  deleteCateCh = "/book/cate/ch/delete/"
}
//获取所有分类（包含子分类）
export function getAllCate<T = IResponseType<any>>(): Promise<T> {
  return gbRequest.get<T>({
    url: BookCateApi.allCate
  });
}
//删除书籍子分类
export function deleteCateCh<T = IResponseType<any>>(id: string): Promise<T> {
  return gbRequest.post({
    url: BookCateApi.deleteCateCh + id
  });
}
