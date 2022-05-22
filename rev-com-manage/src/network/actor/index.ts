import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum ActorApi {
  allActor = "/actor/all",
  addActor = "/actor/",
  updateActor = "/actor/update",
  deleteActor = "/actor/delete",
  uploadAvatar = "/actor/avatar/upload",
  updateAvatar = "/actor/avatar/update",
  directorActor = "/actor/director/cooperate",
  actorCooperate = "/actor/cooperate"
}
//获取所有演员
export function getAllActor<T = IResponseType<any>>(page: number, limit: number, keyword: string) {
  return gbRequest.get<T>({
    url: ActorApi.allActor,
    params: {
      page,
      limit,
      keyword
    }
  })
}
//添加演员
export function addActor<T = IResponseType<any>>(
  name: string,
  foreignName: string,
  constellation: string,
  birth: string,
  birthPlace: string,
  family: string,
  description: string,
  alias: string,
  occupationList: string[]
) {
  return gbRequest.post<T>({
    url: ActorApi.addActor,
    data: {
      name,
      foreignName,
      constellation,
      birth,
      birthPlace,
      family,
      description,
      alias,
      occupationList
    }
  })
}
//更新演员信息
export function updateActor<T = IResponseType<any>>(
  id: string,
  name: string,
  foreignName: string,
  constellation: string,
  birth: string,
  birthPlace: string,
  family: string,
  description: string,
  alias: string,
  occupationList: string[]
) {
  return gbRequest.post<T>({
    url: ActorApi.updateActor,
    data: {
      id,
      name,
      foreignName,
      constellation,
      birth,
      birthPlace,
      family,
      description,
      alias,
      occupationList
    }
  })
}
//删除演员
export function deleteActor<T = IResponseType<any>>(id: string) {
  return gbRequest.post<T>({
    url: ActorApi.deleteActor,
    params: {
      id
    }
  })
}
//上传演员头像
export function uploadAvatar<T = IResponseType<any>>(id: string, formData: FormData) {
  return gbRequest.post<T>({
    url: ActorApi.uploadAvatar + `/${id}`,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//更新演员头像
export function updateAvatar<T = IResponseType<any>>(id: string, formData: FormData) {
  return gbRequest.post<T>({
    url: ActorApi.updateAvatar + `/${id}`,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//获取导演合作演员
export function getDirectorActor<T = IResponseType<any>>(id: string, page: number, limit: number) {
  return gbRequest.get<T>({
    url: ActorApi.directorActor,
    params: {
      id,
      page,
      limit
    }
  })
}
//获取演员合作演员
export function getActorCooperate<T = IResponseType<any>>(id: string, page: number, limit: number) {
  return gbRequest.get<T>({
    url: ActorApi.actorCooperate,
    params: {
      id,
      page,
      limit
    }
  })
}
