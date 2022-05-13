import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"

enum DirectorApi {
  allDirector = "/director/all",
  addDirector = "/director/",
  uploadAvatar = "/director/avatar/upload/",
  updateDirector = "/director/update"
}
export function getAllDirector<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
) {
  return gbRequest.get<T>({
    url: DirectorApi.allDirector,
    params: {
      page: page,
      limit: limit,
      keyword
    }
  })
}
export function addDirectorRequest<T = IResponseType<any>>(
  name: string,
  alias: string,
  gender: string,
  birthPlace: string,
  description: string
) {
  return gbRequest.post<T>({
    url: DirectorApi.addDirector,
    method: "post",
    data: {
      name,
      alias,
      gender,
      birthPlace,
      description
    }
  })
}
//上传头像
export function uploadAvatar<T = IResponseType<any>>(
  formData: FormData,
  id: string
) {
  return gbRequest.post<T>({
    url: DirectorApi.uploadAvatar + `${id}`,
    method: "post",
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//更新导演信息
export function updateDirector<T = IResponseType<any>>(
  id: string,
  name: string,
  alias: string,
  gender: string,
  occupationList: string[],
  description: string,
  birthPlace: string
) {
  return gbRequest.post<T>({
    url: DirectorApi.updateDirector,
    data: {
      id,
      name,
      gender,
      alias,
      occupationList,
      description,
      birthPlace
    }
  })
}
