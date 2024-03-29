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
  screenwriters: IScreenwriter[]
  coverUrl: string,
  score:number,
  area: IArea[]
  language: string
  releaseTime: string
  duration: number
  alias: string
  form: IForm,
  comment:number,
  actors: IActor[]
  categories: ICategory[]
  description: string
}
export type{
  IMovie
}
