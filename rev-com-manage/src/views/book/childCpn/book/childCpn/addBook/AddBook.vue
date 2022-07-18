<template>
  <div class="add-book">
    <add-info
      :form-shape="formShape"
      v-model="formData.book"
      :rules="rules"
      ref="addBookRef"
      file-name="cover"
      :prev-u-r-l="prevURL"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, toRefs } from "vue";
import AddInfo from "@/components/content/addInfo/AddInfo.vue";
import { ElMessage, FormRules } from "element-plus";
import emitter from "@/utils/evenBus";
import { debounce } from "@/utils/debounce";
import { createBook, updateBook, updateCover, uploadCover } from "@/network/book/book";
import { useUpload } from "@/hook/uploadHook";
import { IBook } from "@/types/book/book";
import { useUpdate } from "@/hook/updateHok";
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
    },
    bookItem: {
      type: Object
    }
  },
  emits: ["refresh"],
  setup(props, context) {
    const isUpdate = ref<boolean>(false);
    const formData = reactive({
      book: {
        name: "",
        writer: "",
        publishTime: "",
        publish: "",
        description: "",
        price: "",
        pageCount: ""
      }
    });
    const addBookRef = ref<InstanceType<typeof AddInfo>>();
    const prevURL = ref("");
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
            field: "writer",
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
            field: "publish",
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
      writer: [
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
      publish: [
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

    //更新
    if (props.bookItem && props.bookItem.item && props.bookItem.item.id) {
      const newBook = toRefs(props.bookItem.item);
      if (newBook.coverUrl.value) {
        prevURL.value = newBook.coverUrl.value;
      }
      formData.book.name = newBook.name.value;
      formData.book.writer = newBook.writer.value.id;
      formData.book.publishTime = newBook.publishTime.value;
      formData.book.publish = newBook.publish.value.id;
      formData.book.description = newBook.description.value;
      formData.book.price = newBook.price.value;
      formData.book.pageCount = newBook.pageCount.value;
      isUpdate.value = true;
    }
    emitter.on(
      "drawerDefine",
      debounce(
        () => {
          if (addBookRef.value && addBookRef.value.ruleFormRef) {
            addBookRef.value.ruleFormRef.validate(async (e: boolean) => {
              if (e) {
                const { name, writer, publishTime, publish, description, price, pageCount } =
                  formData.book;
                if (!isUpdate.value) {
                  //上传书籍
                  const data = await createBook(
                    name,
                    writer,
                    publishTime,
                    publish,
                    description,
                    price,
                    pageCount
                  );
                  if (data.status === 200) {
                    ElMessage({
                      type: "success",
                      message: "书籍添加成功"
                    });
                    //上传头象
                    const { id } = data.data;
                    await useUpload(id, addBookRef, uploadCover);
                    context.emit("refresh");
                  }
                } else {
                  //更新书籍信息
                  if (props.bookItem && props.bookItem.item) {
                    const data = await updateBook(
                      props.bookItem.item.id,
                      name,
                      writer,
                      publishTime,
                      publish,
                      description,
                      price,
                      pageCount
                    );
                    if (data.status === 200) {
                      ElMessage.success({
                        message: "书籍更新成功"
                      });
                      if (addBookRef.value && props.bookItem.item && props.bookItem.item.id) {
                        useUpload(props.bookItem.item.id, addBookRef, updateCover);
                      }
                      context.emit("refresh");
                    }
                  }
                }
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
      addBookRef,
      prevURL
    };
  }
});
</script>

<style scoped lang="less"></style>
