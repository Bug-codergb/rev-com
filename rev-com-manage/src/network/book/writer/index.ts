import gbRequest from "@/network"
import { IResponseType } from "@/types/responseType"
enum WriterApi {
  createWriter = "/writer"
}
//创建作家
export function createWriter<T = IResponseType<any>>(
  name: string,
  gender: string,
  birth: string,
  birthPlace: string,
  area: string,
  foreignName: string,
  alias: string,
  description: string
) {
  return gbRequest.post<T>({
    url: WriterApi.createWriter,
    data: {
      name,
      gender,
      birth,
      birthPlace,
      area,
      foreignName,
      alias,
      description
    }
  })
}
