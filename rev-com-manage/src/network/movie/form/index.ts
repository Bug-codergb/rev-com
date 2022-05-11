import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum MovieForm {
  allForm = "/movie/form/all"
}
//获取所有形式
export function getAllForm<T = IResponseType<any>>() {
  return gbRequest.get<T>({
    url: MovieForm.allForm
  })
}
