import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"

enum directorApi {
  allDirector = "/director/all",
  addDirector = "/director/"
}
export function getAllDirector<T = IResponseType<any>>(
  page: number,
  limit: number
) {
  return gbRequest.get<T>({
    url: directorApi.allDirector,
    params: {
      page: page,
      limit: limit
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
    url: directorApi.addDirector,
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
