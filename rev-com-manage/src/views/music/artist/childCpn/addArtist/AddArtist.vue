<template>
  <div>
    <add-info v-model="formData" :rules="rules" :form-shape="formShape" ref="addArtist" />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, inject } from "vue"
import AddInfo from "@/components/content/addInfo/AddInfo.vue"
import { FormRules } from "element-plus"
import emitter from "@/utils/evenBus"
import { debounce } from "@/utils/debounce"
export default defineComponent({
  name: "AddArtist",
  components: { AddInfo },
  props: {
    cate: {
      type: Array,
      required: true
    },
    type: {
      type: Array,
      required: true
    }
  },
  setup(props, context) {
    const drawer = ref<boolean>(true)
    const addArtist = ref<InstanceType<typeof AddInfo>>()
    const formData = reactive({
      name: "",
      description: "",
      typeId: "",
      cateId: ""
    })
    const formShape = reactive({
      row: [
        [
          {
            field: "name",
            name: "歌手名称",
            shape: "input",
            placeholder: "请输入歌手名称",
            span: 24,
            type: "text"
          }
        ],
        [
          {
            field: "cateId",
            name: "歌手分类",
            shape: "select",
            placeholder: "请选择歌手分类",
            span: 12,
            selectList: props.cate
          },
          {
            field: "typeId",
            name: "歌手类型",
            shape: "select",
            placeholder: "请选择歌手类型",
            span: 12,
            selectList: props.type
          }
        ],
        [
          {
            field: "description",
            name: "歌手简介",
            shape: "input",
            placeholder: "请输入歌手简介",
            span: 24,
            type: "textarea"
          }
        ]
      ]
    })
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入歌手名称",
          trigger: "blur"
        }
      ],
      description: [
        {
          required: true,
          message: "请输入歌手简介",
          trigger: "blur"
        }
      ],
      typeId: [
        {
          required: true,
          message: "请选择歌手类型",
          trigger: "change"
        }
      ],
      cateId: [
        {
          required: true,
          message: "请选择歌手分类",
          trigger: "change"
        }
      ]
    })
    emitter.on(
      "drawerDefine",
      debounce(
        () => {
          console.log(1212121)
          if (addArtist.value && addArtist.value.ruleFormRef) {
            addArtist.value.ruleFormRef.validate((e: boolean) => {
              if (e) {
                drawer.value = false
              }
            })
          }
        },
        500,
        false
      )
    )
    return {
      formData,
      rules,
      formShape,
      drawer,
      addArtist
    }
  }
})
</script>

<style scoped lang="less"></style>
