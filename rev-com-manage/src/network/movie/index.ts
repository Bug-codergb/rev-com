import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum MovieApi {
  allMovie = "/movie/all",
  addMovie = "/movie/",
  updateMovie = "/movie/update",
  uploadCover = "/movie/cover/upload",
  updateCover = "/movie/cover/update",
  deleteMovie = "/movie/delete/",
  movieByDirector = "/movie/director",
  movieByActor = "/movie/actor",
  movieDetail = "/movie/detail"
}
//获取所有电影
export function getAllMovie<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string,
  form: string,
  cate: string,
  area: string
): Promise<T> {
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
): Promise<T> {
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
  duration: number,
  alias: string,
  formItem: string,
  cateList: string[],
  description: string
): Promise<T> {
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
//上传电影封面
export function uploadCover<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: MovieApi.uploadCover + "/" + id,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//更新电影封面
export function updateCover<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: MovieApi.updateCover + `/${id}`,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//删除电影
export function deleteMovie<T = IResponseType<any>>(id: string): Promise<T> {
  return gbRequest.post<T>({
    url: MovieApi.deleteMovie + `${id}`
  })
}
//获取电影根据导演
export function getMovieByDid<T = IResponseType<any>>(
  id: string,
  page: number,
  limit: number
): Promise<T> {
  return gbRequest.get<T>({
    url: MovieApi.movieByDirector + `/${id}`,
    params: {
      page,
      limit
    }
  })
}
//获取电影根据演员
export function getMovieByAid<T = IResponseType<any>>(
  id: string,
  page: number,
  limit: number
): Promise<T> {
  return gbRequest.get<T>({
    url: MovieApi.movieByActor + `/${id}`,
    params: {
      page,
      limit
    }
  })
}
//获取电影详情
export function getMovieDetail<T = IResponseType<any>>(id: string): Promise<T> {
  return gbRequest.get<T>({
    url: MovieApi.movieDetail + `/${id}`
  })
}
