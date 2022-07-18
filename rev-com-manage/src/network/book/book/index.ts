import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";
enum BookApi {
  allBook = "/book/all",
  createBook = "/book",
  deleteBook = "/book/delete/",
  uploadCover = "/book/cover/upload/",
  updateBook = "/book/update",
  updateCover = "/book/cover/update/"
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
//创建书籍
export function createBook<T = IResponseType<any>>(
  name: string,
  writerId: string,
  publishTime: string,
  publishId: string,
  description: string,
  price: string,
  pageCount: string
): Promise<T> {
  return gbRequest.post<T>({
    url: BookApi.createBook,
    data: {
      name,
      writerId,
      publishTime,
      publishId,
      description,
      price,
      pageCount
    }
  });
}
//删除书记信息
export function deleteBook<T = IResponseType<any>>(id: string): Promise<T> {
  return gbRequest.post<T>({
    url: BookApi.deleteBook + id
  });
}
//上传书籍封面
export function uploadCover<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: BookApi.uploadCover + id,
    data: formData
  });
}
//更新书籍信息
export function updateBook<T = IResponseType<any>>(
  id: string,
  name: string,
  writerId: string,
  publishTime: string,
  publishId: string,
  description: string,
  price: string,
  pageCount: string
): Promise<T> {
  return gbRequest.post<T>({
    url: BookApi.updateBook,
    data: {
      id,
      name,
      writerId,
      publishTime,
      publishId,
      description,
      price,
      pageCount
    }
  });
}
//更新书籍信息
export function updateCover<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: BookApi.updateCover + id,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  });
}
