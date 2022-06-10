import { ICategory } from "@/types/music/artist/category"
import { IType } from "@/types/music/artist/type"
import { IFileInfo } from "@/types/FileInfo"

interface IArtist extends IFileInfo {
  id: string
  name: string
  description: string
  avatarUrl: string
  area: ICategory
  type: IType
  createTime: string
  updateTime: string
}
export type { IArtist }
