import { IOccupation } from "./occupation"
import { IFileInfo } from "../fileInfo"

interface IActor extends IFileInfo {
  id: string
  name: string
  avatarUrl: string
  foreignName: string
  alias: string
  constellation: string
  occupations: IOccupation[]
  birth: string
  birthPlace: string
  family: string
  description: string
  createTime: string
  updateTime: string
}
export type { IActor }
