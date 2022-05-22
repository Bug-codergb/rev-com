<template>
  <div class="actor-list">
    <ActorTable
      :count="7"
      :height="350"
      :actor-list="actorList"
      :is-show-operator="false"
      @pageChange="pageChange"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, onMounted } from "vue"
import { getActorCooperate } from "@/network/actor"
import { IActor } from "@/types/actor"
import { IPageResult } from "@/types/pageResult"
import { IResponseType } from "@/types/responseType"
import ActorTable from "@/components/content/actorTable/ActorTable.vue"
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
    const total = ref(0)
    const actorList = reactive<{ list: IActor[] | null }>({
      list: null
    })
    const getActorCooperateRequest = async (page: number, limit: number) => {
      const data = await getActorCooperate<IResponseType<IPageResult<IActor[]>>>(
        props.id,
        page,
        limit
      )
      if (data.status === 200) {
        total.value = data.data.total
        actorList.list = data.data.data
      }
    }
    onMounted(() => {
      getActorCooperateRequest(1, 7)
    })
    const pageChange = (e: number) => {
      getActorCooperateRequest(e, 7)
    }
    return {
      actorList,
      total,
      pageChange
    }
  }
})
</script>

<style scoped lang="less"></style>
