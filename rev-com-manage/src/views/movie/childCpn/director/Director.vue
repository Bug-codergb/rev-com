<template>
  <div class="director">
    <div class="director-header">
      <div class="director-search">
        <el-input
          v-model="keyword"
          placeholder="请输入人导演名称"
          clearable
          @input="keywordChange"
        />
      </div>
      <div class="add-director">
        <el-button type="primary" @click="addDirector">添加导演</el-button>
      </div>
    </div>
    <div class="director-list">
      <template v-if="directList.list && directList.list.length > 0">
        <el-table :data="directList.list" :height="490">
          <el-table-column
            :show-overflow-tooltip="true"
            prop="name"
            label="导演头像"
            width="80"
          >
            <template #default="scope">
              <!--              <img class="director-avatar"  />-->
              <el-image :src="scope.row.avatarUrl" style="height: 40px">
                <template #error> </template>
              </el-image>
            </template>
          </el-table-column>
          <el-table-column
            :show-overflow-tooltip="true"
            prop="name"
            label="导演名称"
            min-width="100"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="alias"
            label="其他名称"
            min-width="120"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="birthPlace"
            label="出生地"
            min-width="100"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="occupations"
            label="职业"
          >
            <template #default="scope">
              <template v-if="scope.row.occupations.length > 1">
                <span>
                  {{
                    scope.row.occupations.map((item) => item.name).join(" / ")
                  }}
                </span>
              </template>
              <template v-else>
                {{ "暂无" }}
              </template>
            </template>
          </el-table-column>
          <el-table-column
            :show-overflow-tooltip="true"
            prop="gender"
            label="性别"
          >
            <template #default="scope">
              <span>{{ scope.row.gender * 1 === 0 ? "男" : "女" }}</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="createTime"
            label="创建时间"
            :sortable="true"
            min-width="100"
          >
            <template #default="scope">
              <span v-format="'yyyy-MM-dd hh:mm'">{{
                scope.row.createTime
              }}</span>
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="操作" min-width="100">
            <template #default>
              <el-button type="text" size="small" class="table-control-btn"
                >查看</el-button
              >
              <el-button type="text" size="small" class="table-control-btn"
                >编辑</el-button
              >
              <el-button type="text" size="small" class="table-control-btn"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </template>
      <template v-if="total < 1">
        <el-empty description="暂无导演信息" />
      </template>
    </div>
    <template v-if="total > 7">
      <div class="page">
        <el-pagination
          background
          @current-change="pageChange"
          layout="prev, pager, next"
          :total="total"
          :page-size="7"
        />
      </div>
    </template>

    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加导演</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-director ref="addDirectRef" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive } from "vue"
import { addDirectorRequest, getAllDirector } from "@/network/director"
import { IResponseType } from "@/types/responseType"
import { IPageResult } from "@/types/pageResult"
import { IDirector } from "@/types/director"
import AddDirector from "./childCpn/addDirector/AddDirector.vue"
import { ElMessage } from "element-plus"
import { setOccupation } from "@/network/occupation"
import { debounce } from "@/utils/debounce"

export default defineComponent({
  name: "Director",
  components: {
    AddDirector
  },
  setup() {
    const keyword = ref<string>("")
    const drawer = ref(false)
    const direction = ref("rtl")
    const addDirectRef = ref<InstanceType<typeof AddDirector>>()

    let directList = reactive<{ list: IDirector[] }>({
      list: []
    })
    const total = ref(0)

    const getAllDirectorRequest = () => {
      getAllDirector<IResponseType<IPageResult<IDirector[]>>>(
        1,
        7,
        keyword.value
      ).then((res) => {
        if (res.status === 200) {
          directList.list = res.data.data
          total.value = res.data.total
        }
      })
    }
    getAllDirectorRequest()
    const pageChange = (e: number) => {
      getAllDirector<IResponseType<IPageResult<IDirector[]>>>(
        e,
        7,
        keyword.value
      ).then((res) => {
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
    const define = () => {
      addDirectRef.value?.ruleFormRef?.validate((e) => {
        if (e) {
          if (addDirectRef.value) {
            const { name, alias, gender, birthPlace, description, occupation } =
              addDirectRef.value.director
            addDirectorRequest(
              name,
              alias,
              gender,
              birthPlace,
              description
            ).then((data) => {
              if (data.status === 200) {
                ElMessage({
                  message: "导演信息添加成功",
                  type: "success"
                })
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
          }
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
      keywordChange
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
  .page {
    display: flex;
    padding: 15px 0 15px;
    justify-content: center;
  }
}
</style>
