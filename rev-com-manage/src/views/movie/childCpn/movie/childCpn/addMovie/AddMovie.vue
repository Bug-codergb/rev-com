<template>
  <div>
    <el-form
      ref="ruleFormRef"
      :model="director"
      :rules="rules"
      label-width="80px"
      label-position="top"
      class="demo-ruleForm"
    >
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="名称" prop="name">
            <el-input v-model="director.name" placeholder="请输入电影名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="语言" prop="alias">
            <el-input v-model="director.alias" placeholder="请输入语言" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="上映时间" prop="releaseTime">
            <el-date-picker
              v-model="director.releaseTime"
              type="date"
              style="width: 100%"
              placeholder="选择上映时间"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="别名" prop="alias">
            <el-input
              v-model="director.birthPlace"
              placeholder="请输入电影别名"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="形式" prop="occupation">
            <el-select
              v-model="director.form"
              style="width: 100%"
              filterable
              placeholder="请选择电影形式"
            >
              <el-option
                v-for="item in formList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地区" prop="area">
            <el-select
              v-model="director.area"
              style="width: 100%"
              filterable
              placeholder="请选择电影地区"
              multiple
              multiple-limit="4"
            >
              <el-option
                v-for="item in areaList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue"
import { FormInstance, FormRules } from "element-plus"
import { IOccupation } from "@/types/occupation"
import { getAllOccupation } from "@/network/occupation"
import { IResponseType } from "@/types/responseType"
import { IForm } from "@/types/form"
import { getAllForm } from "@/network/movie/form"
import { IArea } from "@/types/area"
import { getAllArea } from "@/network/movie/area"
export default defineComponent({
  name: "AddMovie",
  setup() {
    const ruleFormRef = ref<FormInstance>()
    const director = reactive({
      name: "",
      alias: "",
      gender: "0",
      releaseTime: "",
      birthPlace: "",
      description: "",
      occupation: [],
      form: [],
      area: []
    })
    const formList = reactive<{ list: IForm[] }>({
      list: []
    })
    const areaList = reactive<{ list: IArea[] }>({
      list: []
    })
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入导演名称",
          trigger: "blur"
        }
      ],
      alias: [
        {
          required: true,
          message: "请输入导演其他名称",
          trigger: "blur"
        }
      ],
      gender: [
        {
          required: true,
          message: "请选择性别",
          trigger: "change"
        }
      ],
      birthPlace: [
        {
          required: true,
          message: "请输入出生地",
          trigger: "blur"
        }
      ],
      description: [
        {
          required: true,
          message: "请输入人导演简介",
          trigger: "blur"
        }
      ]
    })

    onMounted(async () => {
      getAllForm<IResponseType<IForm[]>>().then((data) => {
        if (data.status === 200) {
          formList.list = data.data
        }
      })
      getAllArea<IResponseType<IArea[]>>().then((data) => {
        if (data.status === 200) {
          areaList.list = data.data
        }
      })
    })
    return {
      director,
      rules,
      ruleFormRef,
      formList,
      areaList
    }
  }
})
</script>

<style scoped lang="less"></style>
