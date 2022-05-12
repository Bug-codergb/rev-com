<template>
  <div class="add-director">
    <el-form
      ref="ruleFormRef"
      :model="director"
      :rules="rules"
      label-width="80px"
      class="demo-ruleForm"
    >
      <el-form-item label="名称" prop="name">
        <el-input v-model="director.name" placeholder="请输入导演名称" />
      </el-form-item>
      <el-form-item label="别名" prop="alias">
        <el-input v-model="director.alias" placeholder="请输入导演名称" />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-radio-group v-model="director.gender">
          <el-radio label="0">男</el-radio>
          <el-radio label="1">女</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="出生地" prop="birthPlace">
        <el-input v-model="director.birthPlace" placeholder="请输入导演名称" />
      </el-form-item>

      <el-form-item label="职业" prop="occupation">
        <el-select
          v-model="director.occupation"
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
      <el-form-item label="简介" prop="description">
        <el-input
          type="textarea"
          placeholder="请输入导演名称"
          v-model="director.description"
          :autosize="{ minRows: 4, maxRows: 6 }"
        />
      </el-form-item>
      <el-form-item label="头像">
        <div class="director-avatar" style="height: 100px; width: 100%">
          <img-prev @onCancel="cancel" @onFileChange="fileChange" />
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, onMounted } from "vue"
import type { FormInstance, FormRules } from "element-plus"
import { getAllOccupation } from "@/network/occupation"
import { IResponseType } from "@/types/responseType"
import { IOccupation } from "@/types/occupation"
import ImgPrev from "@/components/common/imgPrev/ImgPrev.vue"
import { uploadAvatar } from "@/network/director"
export default defineComponent({
  name: "AddDirector",
  components: {
    ImgPrev
  },
  setup() {
    const ruleFormRef = ref<FormInstance>()
    const director = reactive({
      name: "",
      alias: "",
      gender: "0",
      birthPlace: "",
      description: "",
      occupation: []
    })
    const avatar = reactive<{ source: FormData | null }>({
      source: null
    })
    const occupation = reactive<{ list: IOccupation[] }>({
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
      director,
      rules,
      ruleFormRef,
      occupation,
      cancel,
      fileChange,
      avatar
    }
  }
})
</script>

<style scoped lang="less">
.add-director {
  padding: 0 15px;
}
</style>
