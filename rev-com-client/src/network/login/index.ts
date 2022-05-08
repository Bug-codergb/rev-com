import gbRequest from "../index";
enum loginApi {
    login = '/login',
}
export function login(userName:string,password:string){
    return gbRequest.post({
        url:loginApi.login,
        data:{

        }
    })
}