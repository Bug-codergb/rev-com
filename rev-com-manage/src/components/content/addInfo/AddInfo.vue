<template>
  <div class="add-info">
    <el-form ref="ruleFormRef" :model="newFormData" :rules="rules" label-position="top">
      <template v-for="(item, index) in formShape.row" :key="index">
        <el-row :gutter="24">
          <template v-for="(it, i) in item" :key="i">
            <el-col :span="it.span">
              <el-form-item :label="it.name" :prop="it.field">
                <template v-if="it.shape === 'input'">
                  <el-input
                    :placeholder="it.placeholder"
                    clearable
                    style="width: 100%"
                    :type="it.type"
                    :rows="3"
                    v-model="newFormData[it.field]"
                  />
                </template>
                <template v-else-if="it.shape === 'select'">
                  <el-select
                    :placeholder="it.placeholder"
                    v-model="newFormData[it.field]"
                    clearable
                    filterable
                    style="width: 100%"
                  >
                    <el-option
                      v-for="item in it.selectList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                    ></el-option>
                  </el-select>
                </template>
                <template v-else-if="it.shape === 'radio'">
                  <el-radio-group v-model="newFormData[it.field]" style="width: 100%">
                    <el-radio v-for="item in it.radioList" :key="item.value" :label="item.value">{{
                      item.label
                    }}</el-radio>
                  </el-radio-group>
                </template>
                <template v-else-if="it.shape === 'upload'">
                  <div class="img-prev-container">
                    <img-prev @onCancel="cancel" @onFileChange="fileChange" :prev-u-r-l="prevURL" />
                  </div>
                </template>
              </el-form-item>
            </el-col>
          </template>
        </el-row>
      </template>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, watch } from "vue"
import { FormInstance } from "element-plus"
import ImgPrev from "@/components/common/imgPrev/ImgPrev.vue"
export default defineComponent({
  name: "AddInfo",
  components: { ImgPrev },
  props: {
    modelValue: {
      type: Object,
      required: true
    },
    rules: {
      type: Object,
      required: true
    },
    formShape: {
      type: Object,
      required: true
    },
    prevURL: {
      type: String,
      default: ""
    }
  },
  emits: ["update:modelValue"],
  setup(props, context) {
    const ruleFormRef = ref<FormInstance>()
    const newFormData = ref(JSON.parse(JSON.stringify(props.modelValue)))
    const avatar = reactive<{ source: FormData | null }>({
      source: null
    })
    watch(
      newFormData,
      (newVal) => {
        context.emit("update:modelValue", newVal)
      },
      { deep: true }
    )
    const fileChange = (file: File) => {
      let formData = new FormData()
      formData.append("avatar", file)
      avatar.source = formData
    }
    const cancel = () => {
      avatar.source = null
    }
    return {
      newFormData,
      ruleFormRef,
      fileChange,
      cancel,
      avatar
    }
  }
})
</script>

<style scoped lang="less">
.add-info {
  .img-prev-container {
    height: 120px;
    width: 100%;
  }
}
</style>
