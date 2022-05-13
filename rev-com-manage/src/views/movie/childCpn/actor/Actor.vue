<template>
  <div class="actor">
    <div class="actor-header">
      <div class="actor-search">
        <el-input
          v-model="keyword"
          placeholder="请输入人导演名称"
          clearable
          @input="keywordChange"
        />
      </div>
      <div class="add-actor">
        <el-button type="primary" @click="addActor">添加演员</el-button>
      </div>
    </div>
    <div class="actor-list">
      <template v-if="actorList.list && actorList.list.length > 0">
        <el-table :data="actorList.list" :height="490">
          <el-table-column
            :show-overflow-tooltip="true"
            prop="name"
            label="演员名称"
            width="130"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="foreignName"
            label="外文名称"
            width="140"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="alias"
            label="其他名称"
            width="140"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="birthPlace"
            label="出生日期"
            width="110"
          >
            <template #default="scope">
              <span v-format="'yyyy-MM-dd'">{{ scope.row.birth }}</span>
            </template>
          </el-table-column>

          <el-table-column
            :show-overflow-tooltip="true"
            prop="birthPlace"
            label="出生地"
            width="100"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="constellation"
            width="90"
            label="星座"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="family"
            width="130"
            label="家庭成员"
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
            width="60"
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
            width="160"
          >
            <template #default="scope">
              <span v-format="'yyyy-MM-dd hh:mm'">{{
                scope.row.createTime
              }}</span>
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="140">
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
    <template v-if="total > 10">
      <div class="page">
        <el-pagination
          background
          @current-change="pageChange"
          layout="prev, pager, next"
          :total="total"
          :page-size="10"
        />
      </div>
    </template>

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
      <add-actor ref="addActorRef" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive } from "vue"
import { IActor } from "@/types/actor"
import { getAllActor } from "@/network/actor"
import { debounce } from "@/utils/debounce"
import { IResponseType } from "@/types/responseType"
import { IPageResult } from "@/types/pageResult"
import AddActor from "@/views/movie/childCpn/actor/childCpn/AddActor.vue"
export default defineComponent({
  name: "Actor",
  components: {
    AddActor
  },

  setup() {
    const keyword = ref("")
    const total = ref(0)
    const direction = ref("rtl")
    const drawer = ref(true)
    const actorList = reactive<{ list: IActor[] }>({
      list: []
    })
    const getAllActorRequest = () => {
      getAllActor<IResponseType<IPageResult<IActor[]>>>(
        1,
        10,
        keyword.value
      ).then((data) => {
        if (data.status === 200) {
          actorList.list = data.data.data
          total.value = data.data.total
        }
      })
    }
    getAllActorRequest()
    const keywordChange = debounce(
      () => {
        getAllActorRequest()
      },
      1000,
      false
    )
    const addActor = () => {
      getAllActorRequest()
    }
    const pageChange = () => {
      getAllActorRequest()
    }
    return {
      keyword,
      total,
      actorList,
      keywordChange,
      addActor,
      pageChange,
      drawer,
      direction
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
  .page {
    display: flex;
    padding: 15px 0 15px;
    justify-content: center;
  }
}
</style>
