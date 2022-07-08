import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum ScreenwriterApi {
  addScreenwriter = "/screenwriter/",
  allScreenwriter = "/screenwriter/all",
  uploadAvatar = "/screenwriter/avatar/upload",
  updateScreenwriter = "/screenwriter/update",
  updateAvatar = "/screenwriter/avatar/update",
  deleteScreenwriter = "/screenwriter/delete"
}
//添加编剧
export function addScreenwriter<T = IResponseType<any>>(
  name: string,
  alias: string,
  family: string,
  gender: string,
  birthPlace: string,
  birth: string,
  description: string,
  occupationList: string[]
): Promise<T> {
  return gbRequest.post<T>({
    url: ScreenwriterApi.addScreenwriter,
    data: {
      name,
      alias,
      family,
      gender,
      birthPlace,
      birth,
      description,
      occupationList
    }
  })
}
//上传编剧头像
export function uploadAvatar<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: ScreenwriterApi.uploadAvatar + "/" + id,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//获取所有编剧
export function getAllScreenwriter<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
): Promise<T> {
  return gbRequest.get<T>({
    url: ScreenwriterApi.allScreenwriter,
    params: {
      page,
      limit,
      keyword
    }
  })
}
export function updateScreenwriter<T = IResponseType<any>>(
  id: string,
  name: string,
  alias: string,
  family: string,
  gender: string,
  birthPlace: string,
  birth: string,
  description: string,
  occupationList: string[]
): Promise<T> {
  return gbRequest.post<T>({
    url: ScreenwriterApi.updateScreenwriter,
    data: {
      id,
      name,
      alias,
      family,
      gender,
      birthPlace,
      birth,
      description,
      occupationList
    }
  })
}
export function updateAvatar<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: ScreenwriterApi.updateAvatar + "/" + id,
    data: formData
  })
}
//删除编剧
export function deleteScreenwriter<T = IResponseType<any>>(id: string): Promise<T> {
  return gbRequest.post<T>({
    url: ScreenwriterApi.deleteScreenwriter + "/" + id
  })
}
