import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum ActorApi {
  allActor = "/actor/all",
  addActor = "/director/"
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
