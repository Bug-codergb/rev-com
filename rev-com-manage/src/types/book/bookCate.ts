interface IBookCateCh {
  id: string;
  name: string;
  createTime: string;
  updateTime: string;
}
interface IBookCate {
  id: string;
  name: string;
  bookCateChList: IBookCateCh[];
  createTime: string;
  updateTime: string;
}
export type { IBookCateCh, IBookCate };
