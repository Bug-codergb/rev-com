<template>
  <div>
    <template v-if="awardsList.list.length">
      <AwardsTable :awards="awardsList" />
    </template>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue";
import { IAwards } from "@/types/awards";
import { getAllAwards } from "@/network/awards";
import { IResponseType } from "@/types/responseType";
import { IPageResult } from "@/types/pageResult";
import AwardsTable from "../../../../../movieData/childCpn/awards/Awards.vue";
export default defineComponent({
  name: "AwardsList",
  components: {
    AwardsTable
  },
  setup() {
    let awardsList = reactive<{ list: IAwards[] }>({
      list: []
    });
    const total = ref<number>(0);
    const getAllAwardsRequest = async (page: number, limit: number, keyword: string) => {
      const data = await getAllAwards<IResponseType<IPageResult<IAwards[]>>>(page, limit, keyword);
      if (data.status === 200) {
        total.value = data.data.total;
        awardsList.list = data.data.data;
      }
    };
    onMounted(() => {
      getAllAwardsRequest(1, 10, "");
    });
    return {
      awardsList,
      total
    };
  }
});
</script>

<style scoped lang="less"></style>
