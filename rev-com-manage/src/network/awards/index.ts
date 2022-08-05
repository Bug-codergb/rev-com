import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";
enum AwardsApi {
  allAwards = "/awards/all",
  createAwards = "/awards",
  updateAwards = "/awards/update/",
  uploadCover = "/awards/cover/upload/",
  updateCover = "/awards/cover/update/"
}
//获取所有奖项
export function getAllAwards<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
): Promise<T> {
  return gbRequest.get<T>({
    url: AwardsApi.allAwards,
    params: {
      page,
      limit,
      keyword
    }
  });
}
//添加奖项
export function createAwards<T = IResponseType<any>>(
  name: string,
  area: string,
  alias: string,
  description: string,
  established: string
): Promise<T> {
  return gbRequest.post<T>({
    url: AwardsApi.createAwards,
    data: {
      name,
      area,
      alias,
      description,
      established
    }
  });
}
//更新奖项信息
export function updateAwards<T = IResponseType<any>>(
  id: string,
  name: string,
  area: string,
  alias: string,
  description: string,
  established: string
): Promise<T> {
  return gbRequest.post<T>({
    url: AwardsApi.updateAwards,
    data: {
      id,
      name,
      area,
      alias,
      description,
      established
    }
  });
}
//上传奖项封面信息
export function uploadCover<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: AwardsApi.uploadCover + id,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  });
}
//更新封面信息
export function updateCover<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: AwardsApi.updateCover + id,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  });
}
