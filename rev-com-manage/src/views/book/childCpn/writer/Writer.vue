<template>
  <div class="writer">
    <div class="writer-header">
      <PageItemList
        :keyword-list="keywordList"
        add-name="添加作家"
        @showDrawer="showDrawer"
      />
    </div>
    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
      size="45%"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加作家</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-writer ref="addWriter" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue"
import PageItemList from "@/components/content/pageItemList/PageItemList.vue"
import AddWriter from "@/views/book/childCpn/writer/childCpn/addWriter/AddWriter.vue"
import { createWriter } from "@/network/book/writer"
import { ElMessage } from "element-plus/lib/components"
export default defineComponent({
  name: "Writer",
  components: {
    PageItemList,
    AddWriter
  },
  setup() {
    const addWriter = ref<InstanceType<typeof AddWriter>>()
    const drawer = ref(false)
    const direction = ref("rtl")
    const keywordList = [
      { id: 1, keyword: "请输入人", placeholder: "请输入作家名称" }
    ]
    const define = () => {
      if (
        addWriter.value &&
        addWriter.value.ruleFormRef &&
        addWriter.value.writer
      ) {
        addWriter.value.ruleFormRef.validate(async (e: boolean) => {
          if (e) {
            if (addWriter.value) {
              const {
                alias,
                area,
                birth,
                birthPlace,
                description,
                foreignName,
                gender,
                name
              } = addWriter.value.writer
              const data = await createWriter(
                name,
                gender,
                birth,
                birthPlace,
                area,
                foreignName,
                alias,
                description
              )
              if (data.status === 200) {
                ElMessage({
                  type: "success",
                  message: "作家添加成功"
                })
                drawer.value = false
              }
            }
          }
        })
      }
    }
    const showDrawer = () => {
      drawer.value = true
    }
    return {
      keywordList,
      drawer,
      direction,
      define,
      showDrawer,
      addWriter
    }
  }
})
</script>

<style scoped lang="less">
.writer {
}
</style>
