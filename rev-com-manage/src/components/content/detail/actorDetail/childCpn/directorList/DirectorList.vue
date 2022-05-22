<template>
  <div class="director-list">
    <DirectorTable
      :count="7"
      :height="350"
      :direct-list="directorList"
      :is-show-operator="false"
      :total="total"
      @pageChange="pageChange"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, onMounted } from "vue"
import { IDirector } from "@/types/director"
import { getDirectorActor } from "@/network/director"
import { IPageResult } from "@/types/pageResult"
import { IResponseType } from "@/types/responseType"
import DirectorTable from "@/components/content/directorTable/DirectorTable.vue"

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
    const total = ref(0)
    const directorList = reactive<{ list: IDirector[] | null }>({
      list: null
    })
    const getDirectorActorRequest = async (page: number, limit: number) => {
      const data = await getDirectorActor<IResponseType<IPageResult<IDirector[]>>>(
        props.id,
        page,
        limit
      )
      if (data.status === 200) {
        directorList.list = data.data.data
        total.value = data.data.total
      }
    }
    onMounted(() => {
      getDirectorActorRequest(1, 7)
    })
    const pageChange = (e: number) => {
      getDirectorActorRequest(e, 7)
    }
    return {
      total,
      directorList,
      pageChange
    }
  }
})
</script>

<style scoped lang="less"></style>
