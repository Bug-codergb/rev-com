import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";

enum DirectorApi {
  allDirector = "/director/all",
  addDirector = "/director/",
  uploadAvatar = "/director/avatar/upload/",
  updateDirector = "/director/update",
  deleteDirector = "/director/delete",
  updateAvatar = "/director/avatar/update",
  directorCooperate = "/director/cooperate",
  directorActor = "/director/actor/cooperate"
}
export function getAllDirector<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
): Promise<T> {
  return gbRequest.get<T>({
    url: DirectorApi.allDirector,
    params: {
      page: page,
      limit: limit,
      keyword
    }
  });
}
export function addDirectorRequest<T = IResponseType<any>>(
  name: string,
  alias: string,
  gender: string,
  birthPlace: string,
  description: string
): Promise<T> {
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
  });
}
//上传头像
export function uploadAvatar<T = IResponseType<any>>(formData: FormData, id: string): Promise<T> {
  return gbRequest.post<T>({
    url: DirectorApi.uploadAvatar + `${id}`,
    method: "post",
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  });
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
): Promise<T> {
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
  });
}
//删除导演信息
export function deleteDirector<T = IResponseType<any>>(id: string): Promise<T> {
  return gbRequest.post<T>({
    url: DirectorApi.deleteDirector,
    params: {
      id
    }
  });
}
//更新头像信息
export function updateAvatar<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: DirectorApi.updateAvatar + `/${id}`,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  });
}
//获取导演合作导演
export function getDirectorCooperate<T = IResponseType<any>>(
  id: string,
  page: number,
  limit: number
): Promise<T> {
  return gbRequest.get<T>({
    url: DirectorApi.directorCooperate,
    params: {
      id,
      page,
      limit
    }
  });
}
//获取演员合作导演
export function getDirectorActor<T = IResponseType<any>>(
  id: string,
  page: number,
  limit: number
): Promise<T> {
  return gbRequest.get<T>({
    url: DirectorApi.directorActor,
    params: {
      id,
      page,
      limit
    }
  });
}
