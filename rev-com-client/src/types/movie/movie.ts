import {IActor} from "./actor";
import {ICategory} from "./ICategory";
import {IDirector} from "./director";
import IArea from "./IArea";
import {IForm} from "./IForm";
import {IScreenwriter} from "./screenwriter";

interface IMovie{
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
export type{
  IMovie
}
