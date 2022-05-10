import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum OccupationApi {
  allOccupation = "/occupation/all",
  setOccupation = `/occupation`
}
export function getAllOccupation<T = IResponseType<any>>() {
  return gbRequest.get<T>({
    url: OccupationApi.allOccupation
  })
}
export function setOccupation<T = IResponseType<any>>(
  key: string,
  id: string,
  oId: string
) {
  return gbRequest.post<T>({
    url: OccupationApi.setOccupation + "/" + key + "/" + id + "/" + oId
  })
}
