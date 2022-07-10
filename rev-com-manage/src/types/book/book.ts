import { IWriter } from "@/types/book/writer"
import { IPublish } from "@/types/book/publish"

interface IBook {
  id: string
  name: string
  writer: IWriter
  publish: IPublish
  publishTime: string
  coverUrl: string
  price: number
  description: string
  pageCount: number
  score: number
}
export type { IBook }
