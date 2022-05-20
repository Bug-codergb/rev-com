import {IFileInfo} from "@/types/FileInfo";
interface IPublish extends IFileInfo{
  id:string,
  name:string,
  foreignName:string,
  logoUrl:string,
  representative:string,
  industry:string,
  establish:string,
  online:string,
  organizer:string,
  description:string,
  type:string,
}
export type{
  IPublish
}
