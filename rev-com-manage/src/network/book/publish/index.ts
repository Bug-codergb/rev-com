import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum PublishApi {
  createPublish = "/publish",
  allPublish = "/publish/all"
}
//创建出版社
export function createPublish<T = IResponseType<any>>(
  name: string,
  foreignName: string,
  representative: string,
  industry: string,
  establish: string,
  online: string,
  organizer: string,
  description: string,
  type: string
) {
  return gbRequest.post<T>({
    url: PublishApi.createPublish,
    data: {
      name,
      foreignName,
      representative,
      industry,
      establish,
      online,
      organizer,
      description,
      type
    }
  })
}
export function getAllPublish<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
) {
  return gbRequest.get<T>({
    url: PublishApi.allPublish,
    params: {
      page,
      limit,
      keyword
    }
  })
}
