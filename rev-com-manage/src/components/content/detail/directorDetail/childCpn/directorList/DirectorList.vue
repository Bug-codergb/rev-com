<template>
  <div class="director-list">
    <DirectorTable
      :count="7"
      :height="350"
      @pageChange="pageChange"
      :direct-list="directorList"
      :total="total"
      :is-show-operator="false"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, onMounted } from "vue";
import DirectorTable from "@/components/content/directorTable/DirectorTable.vue";
import { IDirector } from "@/types/director";
import { getDirectorCooperate } from "@/network/director";
import { IPageResult } from "@/types/pageResult";
import { IResponseType } from "@/types/responseType";

export default defineComponent({
  name: "DirectorList",
  components: { DirectorTable },
  props: {
    id: {
      type: String,
      default: ""
    }
  },
  setup(props, context) {
    const total = ref(0);
    const directorList = reactive<{ list: IDirector[] | null }>({
      list: null
    });
    const getDirectorCooperateRequest = async (page: number, limit: number) => {
      const data = await getDirectorCooperate<IResponseType<IPageResult<IDirector[]>>>(
        props.id,
        page,
        limit
      );
      if (data.status === 200) {
        directorList.list = data.data.data;
        total.value = data.data.total;
      }
    };
    onMounted(() => {
      getDirectorCooperateRequest(1, 7);
    });
    const pageChange = (e: number) => {
      getDirectorCooperateRequest(e, 7);
    };
    return {
      pageChange,
      total,
      directorList
    };
  }
});
</script>

<style scoped lang="less"></style>
