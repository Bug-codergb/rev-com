import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum ActorApi {
  allActor = "/actor/all",
  addActor = "/actor/",
  updateActor = "/actor/update",
  deleteActor = "/actor/delete"
}
//获取所有演员
export function getAllActor<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
) {
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
