<template>
  <div class="publish">
    <div class="publish-header">
      <PageItemList
        :keyword-list="keywordList"
        add-name="添加出版社"
        @showDrawer="showDrawer"
        @keywordChange="keywordChange"
      />
    </div>
    <div class="publish-list">
      <template v-if="publishList.list && publishList.list.length > 0">
        <el-table :data="publishList.list" :height="490" row-key="id">
          <el-table-column
            :show-overflow-tooltip="true"
            prop="name"
            label="出版社名称"
            min-width="130"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="foreignName"
            label="出版社外文名"
            width="130"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="representative"
            label="法定代表人"
            width="140"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="industry"
            label="所属行业"
            min-width="130"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="establish"
            label="成立日期"
            width="130"
            :sortable="true"
          >
            <template #default="scope">
              <span v-format="'yyyy-MM-dd'">{{ scope.row.establish }}</span>
            </template>
          </el-table-column>
          <el-table-column
            :show-overflow-tooltip="true"
            prop="online"
            label="官方网址"
            width="130"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="organizer"
            label="主办单位"
            width="100"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="type"
            label="类型"
            min-width="120"
          />

          <el-table-column fixed="right" label="操作" width="140">
            <template #default="scope">
              <el-button type="text" size="small" class="table-control-btn"
                >查看</el-button
              >
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="editWriter(scope.row)"
                >编辑</el-button
              >
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="deleteWriterHandle(scope.row)"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </template>
    </div>
    <template v-if="total > 10">
      <div class="page">
        <el-pagination
          background
          @current-change="pageChange"
          layout="prev, pager, next"
          :total="total"
          :page-size="10"
        />
      </div>
    </template>
    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
      size="45%"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加出版社</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-publish ref="addPublish" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, onMounted } from "vue"
import PageItemList from "@/components/content/pageItemList/PageItemList.vue"
import { debounce } from "@/utils/debounce"
import AddPublish from "@/views/book/childCpn/publish/childCpn/addPublish/AddPublish.vue"
import { createPublish, getAllPublish } from "@/network/book/publish"
import { ElMessage } from "element-plus/lib/components"
import { IPublish } from "@/types/book/publish"
import { IResponseType } from "@/types/responseType"
import { IPageResult } from "@/types/pageResult"
export default defineComponent({
  name: "Publish",
  components: {
    PageItemList,
    AddPublish
  },
  setup() {
    const drawer = ref(false)
    const direction = ref("rtl")
    const addPublish = ref<InstanceType<typeof AddPublish>>()
    const keywordList = [
      { id: 1, keyword: "请输入", placeholder: "请输入出版社名称" }
    ]
    const publishList = reactive<{ list: IPublish[] | null }>({
      list: null
    })
    const total = ref(0)
    const keyword = ref("")
    const showDrawer = () => {
      drawer.value = true
    }
    const getAllPublishRequest = async (
      page: number,
      limit: number,
      keyword: string
    ) => {
      const data = await getAllPublish<IResponseType<IPageResult<IPublish[]>>>(
        page,
        limit,
        keyword
      )
      if (data.status === 200) {
        total.value = data.data.total
        publishList.list = data.data.data
      }
    }
    onMounted(async () => {
      await getAllPublishRequest(1, 10, keyword.value)
    })
    const keywordChange = debounce(
      (keywords: string[]) => {
        keyword.value = keywords[0]
        getAllPublishRequest(1, 10, keyword.value)
      },
      1000,
      false
    )
    const pageChange = (e: number) => {
      getAllPublishRequest(e, 10, keyword.value)
    }
    const define = () => {
      if (addPublish.value && addPublish.value.ruleFormRef) {
        addPublish.value.ruleFormRef.validate(async (e: boolean) => {
          if (e) {
            if (addPublish.value) {
              const {
                name,
                foreignName,
                representative,
                industry,
                establish,
                online,
                organizer,
                description,
                type
              } = addPublish.value.publish
              const data = await createPublish(
                name,
                foreignName,
                representative,
                industry,
                establish,
                online,
                organizer,
                description,
                type
              )
              if (data.status === 200) {
                ElMessage({
                  message: "出版社添加成功",
                  type: "success"
                })
                drawer.value = false
                await getAllPublishRequest(1, 10, keyword.value)
              }
            }
          }
        })
      }
    }
    return {
      keywordList,
      drawer,
      direction,
      showDrawer,
      keywordChange,
      define,
      addPublish,
      publishList,
      pageChange,
      total
    }
  }
})
</script>

<style scoped lang="less">
.publish {
  .page {
    display: flex;
    justify-content: center;
    padding: 15px 0;
  }
}
</style>
