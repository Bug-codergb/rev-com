interface ISelect<T = any> {
  id: number
  select: string
  placeholder: string
  list: T[]
}
export type { ISelect }
