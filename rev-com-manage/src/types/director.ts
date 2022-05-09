import { IFileInfo } from "@/types/FileInfo"
import {IOccupation} from "@/types/occupation";

interface IDirector extends IFileInfo {
  id: string
  name: string
  alias: string
  avatarUrl: string
  gender: string
  birthPlace: string
  occupations: IOccupation[]
  description: string
  createTime: string
  updateTime: string
}
export type { IDirector }
