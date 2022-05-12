import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum ScreenwriterApi {
  allScreenwriter = "/screenwriter/all"
}
//获取所有编剧
export function getAllScreenwriter<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
) {
  return gbRequest.get<T>({
    url: ScreenwriterApi.allScreenwriter,
    params: {
      page,
      limit,
      keyword
    }
  })
}
