import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum WriterApi {
  createWriter = "/writer",
  allWriter = "/writer/all"
}
//创建作家
export function createWriter<T = IResponseType<any>>(
  name: string,
  gender: string,
  birth: string,
  birthPlace: string,
  area: string,
  foreignName: string,
  alias: string,
  description: string
) {
  return gbRequest.post<T>({
    url: WriterApi.createWriter,
    data: {
      name,
      gender,
      birth,
      birthPlace,
      area,
      foreignName,
      alias,
      description
    }
  })
}
//获取所有作家
export function getAllWriter<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
) {
  return gbRequest.get<T>({
    url: WriterApi.allWriter,
    params: {
      page,
      limit,
      keyword
    }
  })
}
