<template>
  <div class="add-screenwriter">
    <el-form
      ref="ruleFormRef"
      :model="screenwriter"
      :rules="rules"
      label-width="80px"
      class="demo-ruleForm"
      label-position="top"
    >
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="编剧名称" prop="name">
            <el-input
              v-model="screenwriter.name"
              style="width: 100%"
              placeholder="请输入演员名称"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="编剧别名" prop="alias">
            <el-input
              v-model="screenwriter.alias"
              style="width: 100%"
              placeholder="请输入演员别名"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="编剧职业" prop="occupations">
            <el-select
              v-model="screenwriter.occupations"
              multiple
              :multiple-limit="4"
              placeholder="请选择编剧职业"
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
        <el-col :span="12">
          <el-form-item label="编剧生日" prop="birth">
            <el-date-picker
              v-model="screenwriter.birth"
              type="date"
              style="width: 100%"
              placeholder="选择编剧生日"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="编剧出生地" prop="birthPlace">
            <el-input
              v-model="screenwriter.birthPlace"
              style="width: 100%"
              placeholder="请输入编剧出生地"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="编剧家庭" prop="family">
            <el-input
              v-model="screenwriter.family"
              style="width: 100%"
              placeholder="请输入编剧家庭"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item label="性别" prop="gender">
            <el-radio-group v-model="screenwriter.gender">
              <el-radio label="0">男</el-radio>
              <el-radio label="1">女</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col>
          <el-form-item label="编剧简介" prop="description">
            <el-input
              type="textarea"
              v-model="screenwriter.description"
              style="width: 100%"
              placeholder="请输入编剧简介"
              :autosize="{ minRows: 4, maxRows: 6 }"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item label="编剧头像" prop="avatar">
            <div class="screenwriter-avatar">
              <img-prev @onCancel="cancel" @onFileChange="fileChange" :prevURL="prevURL" />
            </div>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref, toRefs } from "vue"
import { FormInstance, FormRules } from "element-plus"
import { IOccupation } from "@/types/occupation"
import { getAllOccupation } from "@/network/occupation"
import { IResponseType } from "@/types/responseType"
import ImgPrev from "@/components/common/imgPrev/ImgPrev.vue"

export default defineComponent({
  name: "AddScreenwriter",
  components: {
    ImgPrev
  },
  props: {
    screenItem: {
      type: Object
    }
  },
  setup(props, context) {
    const ruleFormRef = ref<FormInstance>()
    const screenwriter = reactive({
      name: "",
      alias: "",
      gender: "0",
      birthPlace: "",
      birth: "",
      description: "",
      family: "",
      occupations: []
    })
    const isUpdate = ref<boolean>(false)
    const prevURL = ref("")
    const avatar = reactive<{ source: FormData | null }>({
      source: null
    })
    const occupation = reactive<{ list: IOccupation[] }>({
      list: []
    })
    if (props.screenItem) {
      if (
        props.screenItem.item &&
        Object.keys(props.screenItem.item).length !== 0 &&
        props.screenItem.item.id !== ""
      ) {
        let screenwriterTmp = toRefs(props.screenItem.item)
        if (screenwriterTmp.avatarUrl.value) {
          prevURL.value = screenwriterTmp.avatarUrl.value
        }
        screenwriter.name = screenwriterTmp.name.value
        screenwriter.alias = screenwriterTmp.alias.value
        screenwriter.birth = screenwriterTmp.birth.value
        screenwriter.birthPlace = screenwriterTmp.birthPlace.value
        screenwriter.description = screenwriterTmp.description.value
        screenwriter.occupations = screenwriterTmp.occupations.value.map(
          (item: IOccupation) => item.id
        )
        screenwriter.family = screenwriterTmp.family.value

        isUpdate.value = true
      }
    }
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入编剧名称",
          trigger: "blur"
        }
      ],
      alias: [
        {
          required: true,
          message: "请输入编剧其他名称",
          trigger: "blur"
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
          message: "请输入编剧简介",
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
      birth: [
        {
          required: true,
          message: "请选择编剧生日",
          trigger: "change"
        }
      ],
      family: [
        {
          required: true,
          message: "请选择编剧家庭成员",
          trigger: "blur"
        }
      ],
      occupations: [
        {
          required: true,
          message: "请选择编剧职业",
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
      screenwriter,
      rules,
      ruleFormRef,
      occupation,
      cancel,
      fileChange,
      avatar,
      isUpdate,
      prevURL
    }
  }
})
</script>

<style scoped lang="less">
.add-screenwriter {
  .screenwriter-avatar {
    width: 100%;
    height: 120px;
  }
}
</style>
