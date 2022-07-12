<template>
  <div class="add-book">
    <add-info :form-shape="formShape" v-model="formData.book" :rules="rules" ref="addBookRef" />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref } from "vue";
import AddInfo from "@/components/content/addInfo/AddInfo.vue";
import { FormRules } from "element-plus";
import emitter from "@/utils/evenBus";
import { debounce } from "@/utils/debounce";
export default defineComponent({
  name: "AddBook",
  components: { AddInfo },
  props: {
    writer: {
      type: Object,
      required: true
    },
    publish: {
      type: Object,
      required: true
    }
  },
  setup(props, context) {
    const formData = reactive({
      book: {
        name: "",
        writerId: "",
        publishTime: "",
        publishId: "",
        description: "",
        price: "",
        pageCount: ""
      }
    });
    const addBookRef = ref<InstanceType<typeof AddInfo>>();
    const formShape = {
      row: [
        [
          {
            field: "name",
            name: "书籍名称",
            shape: "input",
            placeholder: "请输入书籍名称",
            span: 12,
            type: "text"
          },
          {
            field: "writerId",
            name: "作家名称",
            shape: "select",
            placeholder: "请选择作家名称",
            span: 12,
            selectList: props.writer.list
          }
        ],
        [
          {
            field: "publishTime",
            name: "出版时间",
            shape: "time",
            placeholder: "请选择出版时间",
            span: 12
          },
          {
            field: "price",
            name: "价格",
            shape: "input",
            placeholder: "请输入书籍价格",
            span: 12
          }
        ],
        [
          {
            field: "publishId",
            name: "出版社",
            shape: "select",
            placeholder: "请选择出版社",
            span: 12,
            selectList: props.publish.list
          },
          {
            field: "pageCount",
            name: "书籍页数",
            shape: "input",
            placeholder: "请输入书籍页数",
            span: 12
          }
        ],
        [
          {
            field: "description",
            name: "书籍简介",
            shape: "input",
            placeholder: "请输入书籍简介",
            span: 24,
            type: "textarea"
          }
        ],
        [
          {
            field: "avatar",
            name: "书籍封面",
            shape: "upload"
          }
        ]
      ]
    };
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入书籍名称",
          trigger: "blur"
        }
      ],
      writerId: [
        {
          required: true,
          message: "请选择作家",
          trigger: "blur"
        }
      ],
      publishTime: [
        {
          required: true,
          message: "请选择书籍出版时间",
          trigger: "change"
        }
      ],
      publishId: [
        {
          required: true,
          message: "请选择出版社",
          trigger: "change"
        }
      ],
      description: [
        {
          required: true,
          message: "请输入书籍简介",
          trigger: "blur"
        }
      ],
      price: [
        {
          required: true,
          message: "请输入书籍价格",
          trigger: "blur"
        }
      ],
      pageCount: [
        {
          required: true,
          message: "请输入书籍页数",
          trigger: "blur"
        }
      ]
    });
    emitter.on(
      "drawerDefine",
      debounce(
        () => {
          if (addBookRef.value && addBookRef.value.ruleFormRef) {
            addBookRef.value.ruleFormRef.validate((e: boolean) => {
              if (e) {
                console.log(formData.book);
              }
            });
          }
        },
        500,
        false
      )
    );
    return {
      formShape,
      formData,
      rules,
      addBookRef
    };
  }
});
</script>

<style scoped lang="less"></style>
