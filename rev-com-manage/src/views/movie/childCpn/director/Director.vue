<template>
  <div class="director">
    <div class="director-header">
      <div class="director-search">
        <el-input v-model="keyword" placeholder="请输入导演名称" clearable @input="keywordChange" />
      </div>
      <div class="add-director">
        <el-button type="primary" @click="addDirector">添加导演</el-button>
      </div>
    </div>
    <DirectorTable
      :height="490"
      :total="total"
      :direct-list="directList"
      :count="7"
      @directorRouter="directorRouter"
      @editDirector="editDirector"
      @deleteDirectorHandle="deleteDirectorHandle"
      @pageChange="pageChange"
    />
    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
      @closed="drawerClose"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加导演</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-director :directorItem="directorItem" ref="addDirectRef" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { useRouter } from "vue-router"
import { defineComponent, ref, reactive } from "vue"
import {
  addDirectorRequest,
  deleteDirector,
  getAllDirector,
  updateAvatar,
  updateDirector,
  uploadAvatar
} from "@/network/director"
import { IResponseType } from "@/types/responseType"
import { IPageResult } from "@/types/pageResult"
import { IDirector } from "@/types/director"
import AddDirector from "./childCpn/addDirector/AddDirector.vue"
import { ElMessage, ElMessageBox } from "element-plus/lib/components"
import { setOccupation } from "@/network/occupation"
import { debounce } from "@/utils/debounce"
import DirectorTable from "@/components/content/directorTable/DirectorTable.vue"

export default defineComponent({
  name: "Director",
  components: {
    AddDirector,
    DirectorTable
  },
  setup() {
    const router = useRouter()
    const keyword = ref<string>("")
    const drawer = ref(false)
    const direction = ref("rtl")
    const addDirectRef = ref<InstanceType<typeof AddDirector>>()
    const directorItem = reactive<{ item: IDirector | null }>({
      item: {
        alias: "",
        avatarUrl: "",
        birthPlace: "",
        createTime: "",
        description: "",
        filename: "",
        gender: "",
        id: "",
        mimetype: "",
        name: "",
        occupations: [],
        originalname: "",
        size: 0,
        updateTime: ""
      }
    })
    let directList = reactive<{ list: IDirector[] }>({
      list: []
    })
    const total = ref(0)

    const getAllDirectorRequest = () => {
      getAllDirector<IResponseType<IPageResult<IDirector[]>>>(1, 7, keyword.value).then((res) => {
        if (res.status === 200) {
          directList.list = res.data.data
          total.value = res.data.total
        }
      })
    }
    getAllDirectorRequest()
    const pageChange = (e: number) => {
      getAllDirector<IResponseType<IPageResult<IDirector[]>>>(e, 7, keyword.value).then((res) => {
        if (res.status === 200) {
          directList.list = res.data.data
          total.value = res.data.total
        }
      })
    }
    const addDirector = () => {
      drawer.value = true
    }
    const keywordChange = debounce(
      () => {
        getAllDirectorRequest()
      },
      1000,
      false
    )
    const editDirector = (item: IDirector) => {
      directorItem.item = item
      drawer.value = true
    }
    const drawerClose = () => {
      directorItem.item = null
    }
    const define = () => {
      addDirectRef.value?.ruleFormRef?.validate((e: boolean) => {
        if (e) {
          if (addDirectRef.value) {
            const { name, alias, gender, birthPlace, description, occupation } =
              addDirectRef.value.director
            console.log(addDirectRef.value.isUpdate)
            if (!addDirectRef.value.isUpdate) {
              //添加
              addDirectorRequest(name, alias, gender, birthPlace, description).then((data) => {
                if (data.status === 200) {
                  ElMessage({
                    message: "导演信息添加成功",
                    type: "success"
                  })
                  //上传头像
                  if (addDirectRef.value) {
                    const { avatar } = addDirectRef.value
                    if (avatar.source instanceof FormData) {
                      uploadAvatar(avatar.source, data.data.id).then(() => {})
                    }
                  }
                  if (occupation.length !== 0) {
                    for (let item of occupation) {
                      setOccupation("dId", data.data.id, item).then(() => {
                        getAllDirectorRequest()
                      })
                    }
                  } else {
                    getAllDirectorRequest()
                  }
                  drawer.value = false
                }
              })
            } else {
              //更新
              if (directorItem.item) {
                updateDirector(
                  directorItem.item.id,
                  name,
                  alias,
                  gender,
                  occupation,
                  description,
                  birthPlace
                ).then((data) => {
                  if (data.status === 200) {
                    ElMessage({
                      message: "导演信息更新成功",
                      type: "success"
                    })
                    if (addDirectRef.value) {
                      const { avatar } = addDirectRef.value
                      if (directorItem.item && avatar.source instanceof FormData) {
                        updateAvatar(directorItem.item.id, avatar.source).then(() => {
                          getAllDirectorRequest()
                        })
                      }
                    }

                    getAllDirectorRequest()
                    drawer.value = false
                  }
                })
              }
            }
          }
        }
      })
    }
    const deleteDirectorHandle = (item: IDirector) => {
      ElMessageBox.confirm("确定要删除该导演么?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          deleteDirector(item.id).then((data) => {
            if (data.status === 200) {
              getAllDirectorRequest()
              ElMessage({
                type: "success",
                message: "删除成功"
              })
            }
          })
        })
        .catch(() => {})
    }
    const directorRouter = (item: IDirector) => {
      if ("movies" in item) {
        delete item.movies
      }
      router.push({
        path: "/Home/director/directorDetail",
        query: {
          detail: window.btoa(encodeURIComponent(JSON.stringify(item)))
        }
      })
    }
    return {
      directList,
      pageChange,
      addDirector,
      total,
      keyword,
      drawer,
      direction,
      define,
      addDirectRef,
      keywordChange,
      editDirector,
      directorItem,
      drawerClose,
      deleteDirectorHandle,
      directorRouter
    }
  }
})
</script>

<style scoped lang="less">
.director {
  .director-header {
    width: 100%;
    border-bottom: 1px solid #dcdfe6;
    padding: 0 0 15px 0;
    display: flex;
    align-items: center;
    .director-search {
      width: 20%;
    }
    .add-director {
      margin: 0 0 0 20px;
      .el-button {
        padding: 19px 20px;
      }
    }
  }
  .director-list {
    padding: 15px 0 0 0;
    .director-avatar {
      height: 40px;
    }
  }
}
</style>
