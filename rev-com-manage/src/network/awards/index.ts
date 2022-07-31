import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";
enum AwardsApi {
  allAwards = "/awards/all",
  createAwards = "/awards",
  updateAwards = "/awards/update"
}
//获取所有奖项
export function getAllAwards<T = IResponseType<any>>(
  page: number,
  limit: number,
  keyword: string
): Promise<T> {
  return gbRequest.get<T>({
    url: AwardsApi.allAwards,
    params: {
      page,
      limit,
      keyword
    }
  });
}
//添加奖项
export function createAwards<T = IResponseType<any>>(
  name: string,
  area: string,
  alias: string,
  description: string,
  established: string
): Promise<T> {
  return gbRequest.post<T>({
    url: AwardsApi.createAwards,
    data: {
      name,
      area,
      alias,
      description,
      established
    }
  });
}
//更新奖项信息
export function updateAwards<T = IResponseType<any>>(
  id: string,
  name: string,
  area: string,
  alias: string,
  description: string,
  established: string
): Promise<T> {
  return gbRequest.post<T>({
    url: AwardsApi.updateAwards,
    data: {
      id,
      name,
      area,
      alias,
      description,
      established
    }
  });
}
