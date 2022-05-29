import { ElMessage, ElMessageBox } from "element-plus/lib/components"
import { IResponseType } from "@/types/responseType"
export function useDeleteHook(
  id: string,
  page: number,
  limit: number,
  keyword: string,
  deleteFn: <T = IResponseType<any>>(id: string) => Promise<T>,
  getAll: (page: number, limit: number, keyword: string) => void
) {
  ElMessageBox.confirm("确定要删除吗?", "警告", {
    confirmButtonText: "确定",
    cancelButtonText: "取消",
    type: "warning"
  })
    .then(async () => {
      const data = await deleteFn(id)
      if (data.status === 200) {
        getAll(page, limit, keyword)
        ElMessage({
          type: "success",
          message: "删除成功"
        })
      }
    })
    .catch(() => {})
}
