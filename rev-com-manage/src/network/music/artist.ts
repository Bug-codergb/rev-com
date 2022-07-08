import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum ArtistApi {
  allArtistCate = "/music/artist/cate/all",
  allArtistType = "/music/artist/type/all",
  allArtist = "/music/artist/all",
  createArtist = "/music/artist",
  uploadAvatar = "/music/artist/avatar/upload/",
  updateArtist = "/music/artist/update",
  updateAvatar = "/music/artist/avatar/update/",
  deleteArtist = "/music/artist/delete/"
}
//获取所有歌手分类
export function getAllArtistCate<T = IResponseType<any>>(): Promise<T> {
  return gbRequest.get<T>({
    url: ArtistApi.allArtistCate
  })
}
//获取所有歌手类型
export function getAllArtistType<T = IResponseType<any>>(): Promise<T> {
  return gbRequest.get<T>({
    url: ArtistApi.allArtistType
  })
}
//获取所有歌手
export function getAllArtist<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string,
  area: string,
  type: string
): Promise<T> {
  return gbRequest.get<T>({
    url: ArtistApi.allArtist,
    params: {
      page,
      limit,
      keyword,
      area,
      type
    }
  })
}
//创建歌手
export function createArtist<T = IResponseType<any>>(
  name: string,
  description: string,
  typeId: string,
  cateId: string
): Promise<T> {
  return gbRequest.post<T>({
    url: ArtistApi.createArtist,
    data: {
      name,
      description,
      typeId,
      cateId
    }
  })
}
//上传歌手头像2
export function uploadAvatar<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: ArtistApi.uploadAvatar + id,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//更新歌手信息
export function updateArtist<T = IResponseType<any>>(
  id: string,
  name: string,
  description: string,
  typeId: string,
  cateId: string
): Promise<T> {
  return gbRequest.post<T>({
    url: ArtistApi.updateArtist,
    data: {
      id,
      name,
      description,
      typeId,
      cateId
    }
  })
}
//更新歌手头像
export function updateAvatar<T = IResponseType<any>>(id: string, formData: FormData): Promise<T> {
  return gbRequest.post<T>({
    url: ArtistApi.updateAvatar + id,
    data: formData,
    headers: {
      "Content-type": "multipart/form-data"
    }
  })
}
//删除歌手信息
export function deleteArtist<T = IResponseType<any>>(id: string): Promise<T> {
  return gbRequest.post<T>({
    url: ArtistApi.deleteArtist + id
  })
}
