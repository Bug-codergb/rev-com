import { IDirector } from "@/types/director"
import { IActor } from "@/types/actor"
import { ICategory } from "@/types/category"
import { IScreenwriter } from "@/types/screenwriter"
import { IArea } from "@/types/area"
import { IForm } from "@/types/form"

interface IMovie {
  id: string
  name: string
  directors: IDirector[]
  screenwriters: IScreenwriter
  coverUrl: string
  area: IArea
  language: string
  releaseTime: string
  duration: number
  alias: string
  form: IForm
  actors: IActor[]
  categories: ICategory
  description: string
}
export type { IMovie }
