import { Ref, toRefs } from "vue";
import { ToRefs } from "@vue/reactivity";
export function useUpdate(
  source: any,
  target: any,
  isUpdate: Ref<boolean>,
  prevURL: Ref<string>,
  imgType: string
): void {
  if (source && source.item && Reflect.ownKeys(source.item).length !== 0 && source.item.id) {
    const newItem: ToRefs<any> = toRefs(source.item);
    const keys = Object.keys(newItem);
    if (newItem[imgType].value) {
      prevURL.value = newItem[imgType].value;
    }
    for (const item of keys) {
      if (typeof item === "object") {
      }
      target[item] = newItem[item].value;
    }
    isUpdate.value = true;
  }
}
