<template>
  <div>
    <el-form
      ref="ruleFormRef"
      :model="writer"
      :rules="rules"
      label-width="80px"
      class="demo-ruleForm"
      label-position="top"
    >
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="作家名称" prop="name">
            <el-input v-model="writer.name" style="width: 100%" placeholder="请输入作家名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="作家外文名" prop="foreignName">
            <el-input
              v-model="writer.foreignName"
              style="width: 100%"
              placeholder="请输入演员名称"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="其他名称" prop="alias">
            <el-input v-model="writer.alias" style="width: 100%" placeholder="请输入作家其他名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地区" prop="area">
            <el-input v-model="writer.area" style="width: 100%" placeholder="请输入地区" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="生日" prop="birth">
            <el-date-picker
              v-model="writer.birth"
              type="date"
              style="width: 100%"
              placeholder="选择演员生日"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="出生地" prop="birthPlace">
            <el-input v-model="writer.birthPlace" style="width: 100%" placeholder="请输入出生地" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col>
          <el-form-item label="作家性别" prop="gender">
            <el-radio-group v-model="writer.gender">
              <el-radio label="0">男</el-radio>
              <el-radio label="1">女</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col>
          <el-form-item label="简介" prop="description">
            <el-input
              type="textarea"
              v-model="writer.description"
              style="width: 100%"
              placeholder="请输入演员简介"
              :autosize="{ minRows: 4, maxRows: 6 }"
            />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref, toRefs } from "vue";
import { IOccupation } from "@/types/occupation";
import { getAllOccupation } from "@/network/occupation";
import { IResponseType } from "@/types/responseType";
import type { FormInstance, FormRules } from "element-plus";

export default defineComponent({
  name: "AddWriter",
  props: {
    actorItem: {
      type: Object
    }
  },
  setup(props, context) {
    const ruleFormRef = ref<FormInstance>();
    const writer = reactive({
      name: "",
      gender: "0",
      alias: "",
      birth: "",
      birthPlace: "",
      description: "",
      area: "",
      foreignName: ""
    });
    const isUpdate = ref<boolean>(false);
    const avatar = reactive<{ source: FormData | null }>({
      source: null
    });
    const occupation = reactive<{ list: IOccupation[] }>({
      list: []
    });
    /* if (props.actorItem) {
      if (
        props.actorItem.item &&
        Object.keys(props.actorItem.item).length !== 0 &&
        props.actorItem.item.id !== ""
      ) {
        let actorTmp = toRefs(props.actorItem.item)
        console.log(actorTmp)
        actor.name = actorTmp.name.value
        actor.alias = actorTmp.alias.value
        actor.birth = actorTmp.birth.value
        actor.birthPlace = actorTmp.birthPlace.value
        actor.description = actorTmp.description.value
        actor.occupations = actorTmp.occupations.value.map(
          (item: IOccupation) => item.id
        )
        actor.family = actorTmp.family.value
        actor.foreignName = actorTmp.foreignName.value
        actor.constellation = actorTmp.constellation.value
        isUpdate.value = true
      }
    }*/
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入作家名称",
          trigger: "blur"
        }
      ],
      alias: [
        {
          required: true,
          message: "请输入作家其他名称",
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
          message: "请输入作家简介",
          trigger: "blur"
        }
      ],
      foreignName: [
        {
          required: true,
          message: "请输入作家外文名",
          trigger: "blur"
        }
      ],
      birth: [
        {
          required: true,
          message: "请选择作家生日",
          trigger: "change"
        }
      ],
      area: [
        {
          required: true,
          message: "请输入地区",
          trigger: "blur"
        }
      ]
    });

    onMounted(async () => {
      const data = await getAllOccupation<IResponseType<IOccupation[]>>();
      if (data.status === 200) {
        occupation.list = data.data;
      }
    });
    const cancel = () => {
      avatar.source = null;
    };
    const fileChange = (file: File) => {
      let formData = new FormData();
      formData.append("avatar", file);
      avatar.source = formData;
    };
    return {
      writer,
      rules,
      ruleFormRef,
      cancel,
      fileChange,
      avatar,
      isUpdate
    };
  }
});
</script>

<style scoped lang="less"></style>
