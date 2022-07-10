<template>
  <div class="book">
    <template v-if="keywordList.length > 0">
      <PageItemList
        add-name="添加书籍"
        :keyword-list="keywordList"
        @keywordChange="keywordChange"
        @refresh="refresh"
        @showDrawer="showDrawer"
      />
    </template>
    <div class="book-list">
      <template v-if="book.list && book.list.length > 0">
        <el-table :data="book.list" :height="490" row-key="id">
          <el-table-column
            :show-overflow-tooltip="true"
            prop="name"
            label="书籍名称"
          ></el-table-column>
          <el-table-column
            prop="writer.name"
            label="作者"
            :show-overflow-tooltip="true"
          ></el-table-column>
          <el-table-column
            prop="publish.name"
            label="出版社"
            :show-overflow-tooltip="true"
          ></el-table-column>
          <el-table-column label="出版时间">
            <template #default="scope">
              <span v-format="'yyyy-MM-dd'">{{ scope.row.publishTime }}</span>
            </template>
          </el-table-column>
          <el-table-column prop="price" label="价格" />
          <el-table-column prop="pageCount" label="页数" />
          <el-table-column prop="score" label="评分">
            <template #default="scope">
              <span>
                {{ scope.row.score ? scope.row.score : 0 }}
              </span>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template #default>
              <el-button type="text" size="small" class="table-control-btn">编辑</el-button>
              <el-button type="text" size="small" class="table-control-btn">查看</el-button>
              <el-button type="text" size="small" class="table-control-btn">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
    </div>
    <g-b-drawer title="添加书籍" v-model="drawer">
      <template #add>
        <add-book @closeDrawer="drawer = false" @refresh="refresh" />
      </template>
    </g-b-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue"
import { getAllBook } from "@/network/book/book"
import { IPageResult } from "@/types/pageResult"
import { IResponseType } from "@/types/responseType"
import { IBook } from "@/types/book/book"
import PageItemList from "@/components/content/pageItemList/PageItemList.vue"
import GBDrawer from "@/components/common/gbDrawer/GBDrawer.vue"
import AddBook from "@/views/book/childCpn/book/childCpn/addBook/AddBook.vue"
export default defineComponent({
  name: "Book",
  components: { AddBook, GBDrawer, PageItemList },
  setup(props, context) {
    const drawer = ref(false)
    const book = reactive<{ list: IBook[] }>({
      list: []
    })
    const total = ref(0)
    onMounted(async () => {
      const data = await getAllBook<IResponseType<IPageResult<IBook[]>>>(1, 10)
      if (data.status === 200) {
        book.list = data.data.data
        total.value = data.data.total
      }
    })
    const keywordList = [
      { id: 1, keyword: "", placeholder: "请输入歌手名称" },
      { id: 2, keyword: "", placeholder: "请输入出版社名称" },
      { id: 3, keyword: "", placeholder: "请输入作家名称" }
    ]
    const keywordChange = () => {}
    const refresh = () => {}
    const showDrawer = () => {
      drawer.value = true
    }
    return {
      book,
      total,
      keywordList,
      keywordChange,
      refresh,
      showDrawer,
      drawer
    }
  }
})
</script>

<style scoped lang="less"></style>
