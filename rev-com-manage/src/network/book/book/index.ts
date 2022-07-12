import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";
enum BookApi {
  allBook = "/book/all"
}
//获取所有书籍
export function getAllBook<T = IResponseType<any>>(page: number, limit: number): Promise<T> {
  return gbRequest.get<T>({
    url: BookApi.allBook,
    params: {
      page,
      limit
    }
  });
}
