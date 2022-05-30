interface IPageResult<T> {
  pageNum: number
  pages: number
  total: number
  data: T
}
export type { IPageResult }
