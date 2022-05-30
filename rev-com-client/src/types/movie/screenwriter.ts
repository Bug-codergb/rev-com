import { IOccupation } from "./occupation"

interface IScreenwriter {
  id: string
  name: string
  avatarUrl: string
  alias: string
  family: string
  occupations: IOccupation[]
  gender: string
  birthPlace: string
  birth: string
  description: string
  createTime: string
  updateTime: string
}
export type { IScreenwriter }
