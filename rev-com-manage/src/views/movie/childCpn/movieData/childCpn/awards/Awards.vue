<template>
  <PageItemList
    add-name="添加奖项"
    :keyword-list="keywordList"
    @keywordChange="keywordChange"
    @showDrawer="showDrawer"
  />
  <template v-if="awardsList.list.length">
    <AwardsTable :awards="awardsList" @awards-edit="awardsEdit" @awards-delete="awardsDelete" />
  </template>
  <template v-if="total > pageCount">
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
  <g-b-drawer title="添加奖项" v-model="drawer">
    <template #add>
      <add-awards :awards="awards" @closeDrawer="closeDrawer" />
    </template>
  </g-b-drawer>
</template>

<script lang="ts" setup>
import { reactive, ref, onMounted } from "vue";
import PageItemList from "@/components/content/pageItemList/PageItemList.vue";
import AwardsTable from "./childCpn/awardsTable/AwardsTable.vue";
import GBDrawer from "@/components/common/gbDrawer/GBDrawer.vue";
import AddAwards from "./childCpn/addAwards/AddAwards.vue";

import { IAwards } from "@/types/awards";
import { getAllAwards } from "@/network/awards";
import { IResponseType } from "@/types/responseType";
import { IPageResult } from "@/types/pageResult";
import { debounce } from "@/utils/debounce";

let awardsList = reactive<{ list: IAwards[] }>({
  list: []
});
const awards = reactive<{ item: IAwards | null }>({
  item: null
});
const total = ref<number>(0);
const pageCount = 10;
const keyword = ref("");
const drawer = ref(false);
const getAllAwardsRequest = async (page: number, limit: number, keyword: string) => {
  const data = await getAllAwards<IResponseType<IPageResult<IAwards[]>>>(page, limit, keyword);
  if (data.status === 200) {
    total.value = data.data.total;
    awardsList.list = data.data.data;
  }
};
const keywordList = [
  {
    id: 1001,
    keyword: "",
    placeholder: "请输入奖项名称"
  }
];
const keywordChange = debounce(
  (keywords: string[]) => {
    keyword.value = keywords[0];
    getAllAwardsRequest(1, 10, keyword.value);
  },
  1000,
  false
);
const awardsEdit = (item: IAwards) => {
  awards.item = item;
  drawer.value = true;
};
const awardsDelete = () => {
  getAllAwardsRequest(1, 10, "");
};
const showDrawer = () => {
  drawer.value = true;
  awards.item = null;
};
const closeDrawer = () => {
  drawer.value = false;
  getAllAwardsRequest(1, 10, "");
};
const pageChange = (e: number) => {
  getAllAwardsRequest(e, 10, "");
};
onMounted(() => {
  getAllAwardsRequest(1, 10, "");
});
</script>

<style scoped></style>
