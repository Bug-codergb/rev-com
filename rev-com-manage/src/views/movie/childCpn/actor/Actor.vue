<template>
  <div class="actor">
    <div class="actor-header">
      <div class="actor-search">
        <el-input v-model="keyword" placeholder="请输入演员名称" clearable @input="keywordChange" />
      </div>
      <div class="add-actor">
        <el-button type="primary" @click="addActor">添加演员</el-button>
      </div>
    </div>
    <ActorTable
      :actor-list="actorList"
      :count="10"
      :total="total"
      :height="490"
      @editActor="editActor"
      @actorRouter="actorRouter"
      @deleteActorHandle="deleteActorHandle"
      @pageChange="pageChange"
    />
    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
      size="40%"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加演员</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-actor ref="addActorRef" :actorItem="actorItem" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive } from "vue"
import { useRouter } from "vue-router"
import { IActor } from "@/types/actor"
import { deleteActor, getAllActor, updateActor, uploadAvatar } from "@/network/actor"
import { debounce } from "@/utils/debounce"
import { IResponseType } from "@/types/responseType"
import { IPageResult } from "@/types/pageResult"
import AddActor from "@/views/movie/childCpn/actor/childCpn/AddActor.vue"
import { addActor as addActorRequest } from "@/network/actor"
import { ElMessage, ElMessageBox } from "element-plus/lib/components"
import { updateAvatar } from "@/network/actor"
import ActorTable from "@/components/content/actorTable/ActorTable.vue"
export default defineComponent({
  name: "Actor",
  components: {
    AddActor,
    ActorTable
  },
  setup() {
    const router = useRouter()
    const keyword = ref("")
    const total = ref(0)
    const direction = ref("rtl")
    const drawer = ref(false)
    const actorItem = reactive<{ item: IActor | null }>({
      item: null
    })
    const addActorRef = ref<InstanceType<typeof AddActor>>()
    const actorList = reactive<{ list: IActor[] }>({
      list: []
    })
    const getAllActorRequest = (e: number) => {
      getAllActor<IResponseType<IPageResult<IActor[]>>>(e, 10, keyword.value).then((data) => {
        if (data.status === 200) {
          actorList.list = data.data.data
          total.value = data.data.total
        }
      })
    }
    getAllActorRequest(1)
    const keywordChange = debounce(
      () => {
        getAllActorRequest(1)
      },
      1000,
      false
    )
    const addActor = () => {
      drawer.value = true
      actorItem.item = null
    }
    const pageChange = (e: number) => {
      getAllActorRequest(e)
    }
    const editActor = (item: IActor) => {
      drawer.value = true
      actorItem.item = item
    }
    const actorRouter = (item: IActor) => {
      console.log(item)
      router.push({
        path: "/Home/actor/actorDetail",
        query: {
          detail: window.btoa(encodeURIComponent(JSON.stringify(item)))
        }
      })
    }
    const deleteActorHandle = (item: IActor) => {
      ElMessageBox.confirm("确定要删除该演员吗?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(async () => {
          const data = await deleteActor(item.id)
          if (data.status === 200) {
            getAllActorRequest(1)
            ElMessage({
              type: "success",
              message: "删除成功"
            })
          }
        })
        .catch(() => {})
    }
    const define = () => {
      if (addActorRef.value) {
        const {
          alias,
          birth,
          birthPlace,
          constellation,
          description,
          family,
          foreignName,
          name,
          occupations
        } = addActorRef.value.actor
        const { isUpdate } = addActorRef.value
        if (addActorRef.value.ruleFormRef) {
          addActorRef.value.ruleFormRef.validate(async (e: boolean) => {
            if (e) {
              if (!isUpdate) {
                const data = await addActorRequest(
                  name,
                  foreignName,
                  constellation,
                  birth,
                  birthPlace,
                  family,
                  description,
                  alias,
                  occupations
                )
                if (data.status === 200) {
                  getAllActorRequest(1)
                  drawer.value = false
                  ElMessage({
                    message: "演员添加成功",
                    type: "success"
                  })
                  const { id } = data.data
                  if (addActorRef.value) {
                    const { avatar } = addActorRef.value
                    if (avatar.source instanceof FormData) {
                      const data = await uploadAvatar(id, avatar.source)
                    }
                  }
                }
              } else {
                if (actorItem.item) {
                  const data = await updateActor(
                    actorItem.item.id,
                    name,
                    foreignName,
                    constellation,
                    birth,
                    birthPlace,
                    family,
                    description,
                    alias,
                    occupations
                  )
                  if (data.status === 200) {
                    if (addActorRef.value) {
                      const { avatar } = addActorRef.value
                      if (actorItem.item && avatar.source instanceof FormData) {
                        updateAvatar(actorItem.item.id, avatar.source).then(() => {
                          getAllActorRequest(1)
                        })
                      }
                    }
                    getAllActorRequest(1)
                    drawer.value = false
                    ElMessage({
                      message: "演员更新成功",
                      type: "success"
                    })
                  }
                }
              }
            }
          })
        }
      }
    }
    return {
      keyword,
      total,
      actorList,
      keywordChange,
      addActor,
      pageChange,
      drawer,
      direction,
      addActorRef,
      define,
      actorItem,
      editActor,
      deleteActorHandle,
      actorRouter
    }
  }
})
</script>

<style scoped lang="less">
.actor {
  .actor-header {
    width: 100%;
    border-bottom: 1px solid #dcdfe6;
    padding: 0 0 15px 0;
    display: flex;
    align-items: center;
    .actor-search {
      width: 20%;
    }
    .add-actor {
      margin: 0 0 0 20px;
      .el-button {
        padding: 19px 20px;
      }
    }
  }
  .actor-list {
    padding: 15px 0 0 0;
  }
}
</style>
