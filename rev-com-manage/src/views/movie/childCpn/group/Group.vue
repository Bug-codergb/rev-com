<template>
  <div class="group">
    <g-b-drawer v-model="drawer" @define="define">
      <template #add>
        <add-info v-model="formData" :rules="rules" :form-shape="formShape" ref="addGroup" />
      </template>
    </g-b-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref } from "vue";
import AddInfo from "@/components/content/addInfo/AddInfo.vue";
import { FormRules } from "element-plus";
import GBDrawer from "@/components/common/gbDrawer/GBDrawer.vue";

export default defineComponent({
  name: "Group",
  components: { GBDrawer, AddInfo },
  setup: function (props, context) {
    const drawer = ref<boolean>(true);
    const addGroup = ref<InstanceType<typeof AddInfo>>();
    const formData = reactive({
      id: "",
      name: "",
      hobby: "",
      gender: "0"
    });
    const formShape = reactive({
      row: [
        [
          { field: "id", name: "用户id", shape: "input", placeholder: "请输入用户id", span: 12 },
          { field: "name", name: "用户名", shape: "input", placeholder: "请输入用户名", span: 12 }
        ],
        [
          {
            field: "gender",
            name: "性别",
            shape: "radio",
            placeholder: "请输入用户性别",
            span: 12,
            radioList: [
              { label: "男", value: "0" },
              { label: "女", value: "1" }
            ]
          }
        ],
        [
          {
            field: "hobby",
            name: "爱好",
            shape: "select",
            placeholder: "请输入用户爱好",
            span: 24,
            selectList: [
              { name: "呵呵", id: 111 },
              { name: "哈哈哈", id: 112 },
              { name: "喜喜", id: 113 }
            ]
          }
        ]
      ]
    });
    const rules = reactive<FormRules>({
      id: [
        {
          required: true,
          message: "请输入id",
          trigger: "blur"
        }
      ],
      name: [
        {
          required: true,
          message: "请输入名称",
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
      hobby: [
        {
          required: true,
          message: "请选择hobby",
          trigger: "change"
        }
      ]
    });
    const define = () => {
      if (addGroup.value && addGroup.value.ruleFormRef) {
        addGroup.value.ruleFormRef.validate((e: boolean) => {
          if (e) {
            drawer.value = false;
          }
        });
      }
    };
    return {
      formData,
      rules,
      formShape,
      drawer,
      define,
      addGroup
    };
  }
});
</script>

<style scoped lang="less"></style>
