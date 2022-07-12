import gbRequest from "@/network";
import { IResponseType } from "@/types/responseType";

enum LoginApi {
  login = "/login"
}
export function login<T = IResponseType<any>>(userName: string, password: string): Promise<T> {
  return gbRequest.post<T>({
    url: LoginApi.login,
    method: "post",
    data: {
      userName,
      password
    }
  });
}
