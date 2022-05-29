<template>
  <div class="screen-writer">
    <PageItemList
      :is-show-refresh="false"
      :keyword-list="keywordList"
      add-name="添加编剧"
      @keywordChange="keywordChange"
      @showDrawer="showDrawer"
    />
    <screenwriter-table
      :screenwriter-list="screenwriter"
      :total="total"
      :count="7"
      :height="490"
      @pageChange="pageChange"
      @deleteScreenwriterHandle="deleteScreenwriterHandle"
      @editScreenwriter="editScreenwriter"
    />
    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
      size="45%"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加编剧</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-screenwriter ref="addScreen" :screenItem="screenItem" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue"
import { ElMessage } from "element-plus"
import PageItemList from "@/components/content/pageItemList/PageItemList.vue"
import AddScreenwriter from "@/views/movie/childCpn/screenwriter/childCpn/addScreenwriter/AddScreenwriter.vue"
import { debounce } from "@/utils/debounce"
import {
  addScreenwriter,
  deleteScreenwriter,
  getAllScreenwriter,
  updateAvatar,
  updateScreenwriter,
  uploadAvatar
} from "@/network/screenwriter"
import ScreenwriterTable from "@/components/content/screenwriterTable/ScreenwriterTable.vue"
import { IScreenwriter } from "@/types/screenwriter"
import { IPageResult } from "@/types/pageResult"
import { IResponseType } from "@/types/responseType"
import { IWriter } from "@/types/book/writer"
import { useDeleteHook } from "@/hook/deleteHook"
export default defineComponent({
  name: "Screenwriter",
  components: {
    ScreenwriterTable,
    PageItemList,
    AddScreenwriter
  },
  setup() {
    const addScreen = ref<InstanceType<typeof AddScreenwriter>>()
    const drawer = ref(false)
    const direction = ref("rtl")
    const keywordList = [{ id: 1001, keyword: "请输入编剧名称", placeholder: "请输入编剧名称" }]
    const keyword = ref("")
    const keywordChange = debounce(
      (keywords: string[]) => {
        keyword.value = keywords[0]
        getAllScreenwriterRequest(1, 7, keywords[0])
      },
      1000,
      false
    )
    const total = ref(0)
    const screenwriter = reactive<{ list: IScreenwriter[] | null }>({
      list: null
    })
    const screenItem = reactive<{ item: IScreenwriter | null }>({
      item: null
    })
    const showDrawer = () => {
      drawer.value = true
      screenItem.item = null
    }
    const getAllScreenwriterRequest = async (page: number, limit: number, keyword: string) => {
      const data = await getAllScreenwriter<IResponseType<IPageResult<IScreenwriter[]>>>(
        page,
        limit,
        keyword
      )
      if (data.status === 200) {
        screenwriter.list = data.data.data
        total.value = data.data.total
      }
    }
    onMounted(async () => {
      await getAllScreenwriterRequest(1, 7, keyword.value)
    })
    const pageChange = (e: number) => {
      getAllScreenwriterRequest(e, 7, keyword.value)
    }
    const editScreenwriter = (item: IScreenwriter) => {
      screenItem.item = item
      drawer.value = true
    }
    const deleteScreenwriterHandle = (item: IScreenwriter) => {
      useDeleteHook(item.id, 1, 10, keyword.value, deleteScreenwriter, getAllScreenwriterRequest)
    }
    const define = () => {
      if (addScreen.value) {
        addScreen.value.ruleFormRef?.validate(async (e: boolean) => {
          if (e) {
            if (addScreen.value?.screenwriter) {
              const { name, alias, gender, birthPlace, birth, description, family, occupations } =
                addScreen.value?.screenwriter
              const { isUpdate } = addScreen.value
              if (!isUpdate) {
                const data = await addScreenwriter(
                  name,
                  alias,
                  family,
                  gender,
                  birthPlace,
                  birth,
                  description,
                  occupations
                )
                if (data.status === 200) {
                  ElMessage({
                    message: "编剧添加成功",
                    type: "success"
                  })
                  const { id } = data.data
                  if (addScreen.value && addScreen.value?.avatar.source instanceof FormData) {
                    uploadAvatar(id, addScreen.value?.avatar.source).then(() => {
                      getAllScreenwriterRequest(1, 10, keyword.value)
                    })
                  }
                  drawer.value = false
                }
              } else {
                if (screenItem.item) {
                  const data = await updateScreenwriter(
                    screenItem.item.id,
                    name,
                    alias,
                    family,
                    gender,
                    birthPlace,
                    birth,
                    description,
                    occupations
                  )
                  if (data.status === 200) {
                    ElMessage({
                      message: "编剧修改成功",
                      type: "success"
                    })
                    const { avatar } = addScreen.value
                    if (screenItem.item && avatar.source instanceof FormData) {
                      await updateAvatar(screenItem.item.id, avatar.source)
                    }
                    getAllScreenwriterRequest(1, 10, keyword.value)
                    drawer.value = false
                  }
                }
              }
            }
          }
        })
      }
    }
    return {
      keywordList,
      keywordChange,
      showDrawer,
      drawer,
      direction,
      define,
      addScreen,
      screenwriter,
      total,
      pageChange,
      editScreenwriter,
      screenItem,
      deleteScreenwriterHandle
    }
  }
})
</script>

<style scoped lang="less"></style>
