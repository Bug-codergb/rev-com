<template>
  <div class="actor-list">
    <ActorTable
      :height="350"
      :count="7"
      @pageChange="pageChange"
      :actor-list="actorList"
      :total="total"
      :is-show-operator="false"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, onMounted } from "vue";
import ActorTable from "@/components/content/actorTable/ActorTable.vue";
import { IActor } from "@/types/actor";
import { getDirectorActor } from "@/network/actor";
export default defineComponent({
  name: "ActorList",
  components: {
    ActorTable
  },
  props: {
    id: {
      type: String,
      default: ""
    }
  },
  setup(props, context) {
    const total = ref(0);
    const actorList = reactive<{ list: IActor[] | null }>({
      list: null
    });
    const getDirectorActorRequest = async (page: number, limit: number) => {
      const data = await getDirectorActor(props.id, page, limit);
      if (data.status === 200) {
        actorList.list = data.data.data;
        total.value = data.data.total;
      }
    };
    onMounted(() => {
      getDirectorActorRequest(1, 7);
    });
    const pageChange = (e: number) => {
      getDirectorActorRequest(e, 7);
    };
    return {
      actorList,
      total,
      pageChange
    };
  }
});
</script>

<style scoped lang="less"></style>
