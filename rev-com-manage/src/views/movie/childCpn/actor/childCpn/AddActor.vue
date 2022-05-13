<template>
  <div>
    <el-form
      ref="ruleFormRef"
      :model="actor"
      :rules="rules"
      label-width="80px"
      class="demo-ruleForm"
      label-position="top"
    >
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="演员名称" prop="name">
            <el-input
              v-model="actor.name"
              style="width: 100%"
              placeholder="请输入演员名称"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="演员别名" prop="alias">
            <el-input
              v-model="actor.alias"
              style="width: 100%"
              placeholder="请输入演员别名"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="演员星座" prop="constellation">
            <el-select
              v-model="actor.constellation"
              style="width: 100%"
              placeholder="请输入演员名称"
            >
              <template v-for="item in constellation" :key="item">
                <el-option :label="item" :value="item"></el-option>
              </template>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="演员生日" prop="birth">
            <el-date-picker
              v-model="actor.releaseTime"
              type="date"
              style="width: 100%"
              placeholder="选择演员生日"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="演员出生地" prop="birthPlace">
            <el-input
              v-model="actor.birthPlace"
              style="width: 100%"
              placeholder="请输入演员出生地"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="演员家庭" prop="family">
            <el-input
              v-model="actor.family"
              style="width: 100%"
              placeholder="请输入演员家庭"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item label="演员外文名" prop="foreignName">
            <el-input
              v-model="actor.foreignName"
              style="width: 100%"
              placeholder="请输入演员外文名"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col>
          <el-form-item label="演员简介" prop="description">
            <el-input
              type="textarea"
              v-model="actor.description"
              style="width: 100%"
              placeholder="请输入演员简介"
              :autosize="{ minRows: 4, maxRows: 6 }"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col>
          <el-form-item label="职业" prop="occupations">
            <el-select
              v-model="actor.occupations"
              multiple
              :multiple-limit="4"
              placeholder="请选择职业"
              style="width: 100%"
            >
              <el-option
                v-for="item in occupation.list"
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
import { defineComponent, onMounted, reactive, ref, toRefs } from "vue"
import { IOccupation } from "@/types/occupation"
import { getAllOccupation } from "@/network/occupation"
import { IResponseType } from "@/types/responseType"
import type { FormInstance, FormRules } from "element-plus"
import constellation from "../../../../../constant/constellation"
export default defineComponent({
  name: "AddActor",
  props: {
    directorItem: {
      type: Object
    }
  },
  setup(props, context) {
    const ruleFormRef = ref<FormInstance>()
    const actor = reactive({
      name: "",
      alias: "",
      birth: "0",
      birthPlace: "",
      description: "",
      family: "",
      foreignName: "",
      occupations: [],
      constellation: ""
    })
    const isUpdate = ref<boolean>(false)
    const avatar = reactive<{ source: FormData | null }>({
      source: null
    })
    const occupation = reactive<{ list: IOccupation[] }>({
      list: []
    })
    /* if (props.directorItem) {
      if (
        props.directorItem.item &&
        Object.keys(props.directorItem.item).length !== 0 &&
        props.directorItem.item.id !== ""
      ) {
        let directorTmp = toRefs(props.directorItem.item)
        console.log(directorTmp)
        director.name = directorTmp.name.value
        director.alias = directorTmp.alias.value
        director.gender = directorTmp.gender.value
        director.birthPlace = directorTmp.birthPlace.value
        director.description = directorTmp.description.value
        director.occupation = directorTmp.occupations.value.map(
          (item: IOccupation) => item.id
        )
        isUpdate.value = true
      }
    }*/
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入演员名称",
          trigger: "blur"
        }
      ],
      alias: [
        {
          required: true,
          message: "请输入演员其他名称",
          trigger: "blur"
        }
      ],
      constellation: [
        {
          required: true,
          message: "请选择星座",
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
          message: "请输入人演员简介",
          trigger: "blur"
        }
      ],
      foreignName: [
        {
          required: true,
          message: "请输入演员外文名",
          trigger: "blur"
        }
      ],
      birth: [
        {
          required: true,
          message: "请选择演员生日",
          trigger: "change"
        }
      ],
      family: [
        {
          required: true,
          message: "请选择演员家庭成员",
          trigger: "change"
        }
      ],
      occupations: [
        {
          required: true,
          message: "请选择演员职业",
          trigger: "change"
        }
      ]
    })

    onMounted(async () => {
      const data = await getAllOccupation<IResponseType<IOccupation[]>>()
      if (data.status === 200) {
        occupation.list = data.data
      }
    })
    const cancel = () => {
      avatar.source = null
    }
    const fileChange = (file: File) => {
      let formData = new FormData()
      formData.append("avatar", file)
      avatar.source = formData
    }
    return {
      actor,
      rules,
      ruleFormRef,
      occupation,
      cancel,
      fileChange,
      avatar,
      isUpdate,
      constellation
    }
  }
})
</script>

<style scoped lang="less"></style>
