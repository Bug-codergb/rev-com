<template>
  <div>
    <el-form
      ref="ruleFormRef"
      :model="publish"
      :rules="rules"
      label-width="80px"
      class="demo-ruleForm"
      label-position="top"
    >
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="出版社名称" prop="name">
            <el-input v-model="publish.name" style="width: 100%" placeholder="请输入出版社名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="出版社外文名" prop="foreignName">
            <el-input
              v-model="publish.foreignName"
              style="width: 100%"
              placeholder="请输入出版社外文名"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="法定代表人" prop="representative">
            <el-input
              v-model="publish.representative"
              style="width: 100%"
              placeholder="请输入出版社法定代表人"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所属行业" prop="industry">
            <el-input v-model="publish.industry" style="width: 100%" placeholder="请输入所属行业" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="成立时间" prop="establish">
            <el-date-picker
              v-model="publish.establish"
              type="date"
              style="width: 100%"
              placeholder="选择演成立时间"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="官方网站" prop="online">
            <el-input v-model="publish.online" style="width: 100%" placeholder="请输入官方网站" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="类型" prop="type">
            <el-input v-model="publish.type" style="width: 100%" placeholder="请输入出版社类型" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="主办单位" prop="organizer">
            <el-input
              v-model="publish.organizer"
              style="width: 100%"
              placeholder="请输入主办单位"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col>
          <el-form-item label="简介" prop="description">
            <el-input
              type="textarea"
              v-model="publish.description"
              style="width: 100%"
              placeholder="请输入出版社简介"
              :autosize="{ minRows: 4, maxRows: 6 }"
            />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue";
import { IOccupation } from "@/types/occupation";
import { getAllOccupation } from "@/network/occupation";
import { IResponseType } from "@/types/responseType";
import type { FormInstance, FormRules } from "element-plus";
export default defineComponent({
  name: "AddPublish",
  setup(props, context) {
    const ruleFormRef = ref<FormInstance>();
    const publish = reactive({
      name: "",
      foreignName: "",
      representative: "",
      industry: "",
      establish: "",
      online: "",
      organizer: "",
      description: "",
      type: ""
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
          message: "请输入出版社名称",
          trigger: "blur"
        }
      ],
      foreignName: [
        {
          required: true,
          message: "请输入出版社外文名称",
          trigger: "blur"
        }
      ],
      representative: [
        {
          required: true,
          message: "请输入出版社法定代表人",
          trigger: "blur"
        }
      ],
      industry: [
        {
          required: true,
          message: "请输入出版社所属行业",
          trigger: "blur"
        }
      ],
      establish: [
        {
          required: true,
          message: "请输入出版社成立时间",
          trigger: "change"
        }
      ],
      online: [
        {
          required: true,
          message: "请输入出版社官方网站",
          trigger: "blur"
        }
      ],
      organizer: [
        {
          required: true,
          message: "请输入出版社主办单位",
          trigger: "blur"
        }
      ],
      description: [
        {
          required: true,
          message: "请输入出版社简介",
          trigger: "blur"
        }
      ],
      type: [
        {
          required: true,
          message: "请输入出版社类型",
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
      publish,
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
