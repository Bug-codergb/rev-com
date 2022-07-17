import { Ref } from "vue";
import { IResponseType } from "@/types/responseType";
import AddInfo from "@/components/content/addInfo/AddInfo.vue";
interface IAvatar {
  source: FormData | null;
}
interface ICpn {
  avatar: IAvatar;
}
export async function useUpload(
  id: string,
  uploadRef: Ref<any>,
  fn: (id: string, formData: FormData) => Promise<IResponseType<any>>
): Promise<void> {
  if (uploadRef && uploadRef.value) {
    const { avatar } = uploadRef.value as ICpn;
    if (avatar.source instanceof FormData) {
      const data = await fn(id, avatar.source);
    }
  }
}
