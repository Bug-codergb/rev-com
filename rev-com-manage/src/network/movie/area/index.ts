import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";
enum MovieArea {
  allArea = "/movie/area/all"
}
//获取所有形式
export function getAllArea<T = IResponseType<any>>(): Promise<T> {
  return gbRequest.get<T>({
    url: MovieArea.allArea
  });
}
