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
              </el-form-item>
            </el-col>
          </template>
        </el-row>
      </template>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, watch } from "vue"
import { FormInstance } from "element-plus"
export default defineComponent({
  name: "AddInfo",
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
    }
  },
  emits: ["update:modelValue"],
  setup(props, context) {
    const ruleFormRef = ref<FormInstance>()
    const newFormData = ref(JSON.parse(JSON.stringify(props.modelValue)))
    watch(
      newFormData,
      (newVal) => {
        console.log(newVal)
        context.emit("update:modelValue", newVal)
      },
      { deep: true }
    )
    return {
      newFormData,
      ruleFormRef
    }
  }
})
</script>

<style scoped lang="less"></style>
