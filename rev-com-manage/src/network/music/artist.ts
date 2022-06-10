import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum ArtistApi {
  allArtistCate = "/music/artist/cate/all",
  allArtistType = "/music/artist/type/all",
  allArtist = "/music/artist/all"
}
//获取所有歌手分类
export function getAllArtistCate<T = IResponseType<any>>() {
  return gbRequest.get<T>({
    url: ArtistApi.allArtistCate
  })
}
//获取所有歌手类型
export function getAllArtistType<T = IResponseType<any>>() {
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
) {
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
