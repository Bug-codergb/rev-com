import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum MovieApi {
  allMovie = "/movie/all"
}
//获取所有电影
export function getAllMovie<T = IResponseType<any>>(
  page: number,
  limit: number
) {
  return gbRequest.get<T>({
    url: MovieApi.allMovie,
    params: {
      page,
      limit
    }
  })
}
