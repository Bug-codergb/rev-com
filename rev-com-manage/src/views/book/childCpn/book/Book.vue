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
            <template #default="scope">
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="editBookHandle(scope.row)"
                >编辑</el-button
              >
              <el-button type="text" size="small" class="table-control-btn">查看</el-button>
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="deleteBookHandle(scope.row)"
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
          layout="prev,pager,next"
          :total="total"
          :page-size="pageCount"
        />
      </div>
    </template>
    <g-b-drawer title="添加书籍" v-model="drawer">
      <template #add>
        <add-book
          @closeDrawer="drawer = false"
          @refresh="refresh"
          :writer="writer"
          :publish="publish"
          :bookItem="bookItem"
        />
      </template>
    </g-b-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue";
import { deleteBook, getAllBook } from "@/network/book/book";
import { IPageResult } from "@/types/pageResult";
import { IResponseType } from "@/types/responseType";
import { IBook } from "@/types/book/book";
import PageItemList from "@/components/content/pageItemList/PageItemList.vue";
import GBDrawer from "@/components/common/gbDrawer/GBDrawer.vue";
import AddBook from "@/views/book/childCpn/book/childCpn/addBook/AddBook.vue";
import { getAllWriter } from "@/network/book/writer";
import { IWriter } from "@/types/book/writer";
import { getAllPublish } from "@/network/book/publish";
import { IPublish } from "@/types/book/publish";
import { useDeleteHook } from "@/hook/deleteHook";
export default defineComponent({
  name: "Book",
  components: { AddBook, GBDrawer, PageItemList },
  setup(props, context) {
    const drawer = ref(false);
    const book = reactive<{ list: IBook[] }>({
      list: []
    });
    const writer = reactive<{ list: { label: string; value: string }[] }>({
      list: []
    });
    const publish = reactive<{ list: { label: string; value: string }[] }>({
      list: []
    });
    const bookItem = reactive<{ item: IBook | null }>({
      item: null
    });
    const total = ref(0);
    const pageCount = 10;
    const getAllBookRequest = async (page: number, limit: number) => {
      const data = await getAllBook<IResponseType<IPageResult<IBook[]>>>(page, limit);
      if (data.status === 200) {
        book.list = data.data.data;
        total.value = data.data.total;
      }
    };
    onMounted(async () => {
      await getAllBookRequest(1, 10);
    });
    onMounted(async () => {
      //获取所有作家
      const data = await getAllWriter(1, 1000000, "");
      if (data.status === 200) {
        writer.list = data.data.data.map((item: IWriter) => {
          return {
            label: item.name,
            value: item.id
          };
        });
      }
      //获取所有出版社
      const res = await getAllPublish(1, 1000000, "");
      if (res.status === 200) {
        publish.list = res.data.data.map((item: IPublish) => {
          return {
            label: item.name,
            value: item.id
          };
        });
      }
    });

    const keywordList = [
      { id: 1, keyword: "", placeholder: "请输入歌手名称" },
      { id: 2, keyword: "", placeholder: "请输入出版社名称" },
      { id: 3, keyword: "", placeholder: "请输入作家名称" }
    ];
    const keywordChange = () => {};
    const refresh = async () => {
      await getAllBookRequest(1, 10);
      drawer.value = false;
    };
    const showDrawer = () => {
      drawer.value = true;
    };
    const deleteBookHandle = (item: IBook) => {
      useDeleteHook(item.id, 1, 10, "", deleteBook, getAllBookRequest);
    };
    const editBookHandle = (item: IBook) => {
      bookItem.item = item;
      drawer.value = true;
    };
    const pageChange = async (e: number) => {
      await getAllBookRequest(e, 10);
    };
    return {
      book,
      total,
      keywordList,
      keywordChange,
      refresh,
      showDrawer,
      drawer,
      writer,
      publish,
      deleteBookHandle,
      editBookHandle,
      pageCount,
      pageChange,
      bookItem
    };
  }
});
</script>

<style scoped lang="less"></style>
