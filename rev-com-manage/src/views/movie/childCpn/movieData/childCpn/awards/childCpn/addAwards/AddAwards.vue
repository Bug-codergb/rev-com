<template>
  <add-info
    v-model="formData.awards"
    :form-shape="formShape"
    :rules="rules"
    ref="addAwardsRef"
    file-name="cover"
    :prev-u-r-l="prevURL"
  />
</template>

<script lang="ts" setup>
import { reactive, defineProps, defineEmits, ref, toRefs } from "vue";
import emitter from "@/utils/evenBus";

import { formShape, rules } from "./config";
import AddInfo from "@/components/content/addInfo/AddInfo.vue";
import { debounce } from "@/utils/debounce";
import { createAwards, updateAwards, updateCover, uploadCover } from "@/network/awards";
import { ElMessage } from "element-plus";
import { useUpload } from "@/hook/uploadHook";

const props = defineProps({
  awards: {
    type: Object,
    default() {
      return {
        item: {}
      };
    }
  }
});
const emit = defineEmits(["closeDrawer"]);

const addAwardsRef = ref<InstanceType<typeof AddInfo>>();
const isUpdate = ref<boolean>(false);
const prevURL = ref("");

const formData = reactive({
  awards: {
    name: "",
    area: "",
    established: "",
    alias: "",
    description: ""
  }
});

if (props.awards && props.awards.item && Object.keys(props.awards.item).length !== 0) {
  const awards = toRefs(props.awards.item);
  formData.awards.name = awards.name.value;
  formData.awards.area = awards.area.value;
  formData.awards.established = awards.established.value;
  formData.awards.alias = awards.alias.value;
  formData.awards.description = awards.description.value;
  if (awards.coverUrl.value) {
    prevURL.value = awards.coverUrl.value;
  }
  isUpdate.value = true;
}
emitter.on(
  "drawerDefine",
  debounce(
    () => {
      if (addAwardsRef.value && addAwardsRef.value.ruleFormRef) {
        addAwardsRef.value.ruleFormRef.validate(async (e: boolean) => {
          if (e) {
            const { name, area, established, alias, description } = formData.awards;
            if (!isUpdate.value) {
              const data = await createAwards(name, area, alias, description, established);
              if (data.status === 200) {
                const { id } = data.data;
                if (addAwardsRef.value) {
                  const { avatar } = addAwardsRef.value;
                  useUpload(id, addAwardsRef, uploadCover);
                }
                emit("closeDrawer");
                ElMessage.success({
                  message: "奖项添加成功",
                  duration: 1500
                });
              }
            } else {
              if (Object.keys(props.awards.item).length !== 0 && props.awards.item.id) {
                const data = await updateAwards(
                  props.awards.item.id,
                  name,
                  area,
                  alias,
                  description,
                  established
                );
                if (data.status === 200) {
                  if (props.awards.item && props.awards.item.id && addAwardsRef.value) {
                    useUpload(props.awards.item.id, addAwardsRef, updateCover);
                  }
                  emit("closeDrawer");
                  ElMessage.success({
                    message: "奖项更新成功",
                    duration: 1500
                  });
                }
              }
            }
          }
        });
      }
    },
    500,
    false
  )
);
</script>

<style scoped></style>
