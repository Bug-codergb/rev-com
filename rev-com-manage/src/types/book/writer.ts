import {IFileInfo} from "@/types/FileInfo";

interface IWriter extends IFileInfo{
  id:string,
  name:string,
  gender:string,
  birth:string,
  deadTime:string,
  birthPlace:string,
  area:string,
  foreignName:string,
  alias:string,
  description:string,
  originalName:string,
  createTime:string,
  updateTime:string,
}
export type{
  IWriter
}
