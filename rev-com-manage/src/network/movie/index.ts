import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum MovieApi {
  allMovie = "/movie/all",
  addMovie = "/movie/",
  updateMovie = "/movie/update"
}
//获取所有电影
export function getAllMovie<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string,
  form: string,
  cate: string,
  area: string
) {
  return gbRequest.get<T>({
    url: MovieApi.allMovie,
    params: {
      page,
      limit,
      keyword,
      form,
      cate,
      area
    }
  })
}
//添加电影
export function addMovie<T = IResponseType<any>>(
  name: string,
  directorList: string[],
  screenwriterList: string[],
  areaList: string[],
  actorList: string[],
  language: string,
  releaseTime: string,
  duration: number,
  alias: string,
  form: string,
  cateList: string[],
  description: string
) {
  return gbRequest.post<T>({
    url: MovieApi.addMovie,
    data: {
      name,
      directorList,
      screenwriterList,
      areaList,
      actorList,
      language,
      releaseTime,
      duration,
      alias,
      formItem: form,
      cateList,
      description
    }
  })
}
//更新电影信息
export function updateMovie<T = IResponseType<any>>(
  id: string,
  name: string,
  directorList: string[],
  screenwriterList: string[],
  areaList: string[],
  actorList: string[],
  language: string,
  releaseTime: string,
  duration: string,
  alias: string,
  formItem: string,
  cateList: string[],
  description: string
) {
  return gbRequest.post<T>({
    url: MovieApi.updateMovie,
    data: {
      id,
      name,
      directorList,
      screenwriterList,
      areaList,
      actorList,
      language,
      releaseTime,
      duration,
      alias,
      formItem,
      cateList,
      description
    }
  })
}
