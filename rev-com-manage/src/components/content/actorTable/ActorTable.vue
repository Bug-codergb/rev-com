<template>
  <div class="actor-table">
    <div class="actor-list">
      <template v-if="actorList.list && actorList.list.length > 0">
        <el-table :data="actorList.list" :height="height" row-key="id">
          <el-table-column :show-overflow-tooltip="true" prop="name" label="演员名称" width="130" />
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
          <el-table-column :show-overflow-tooltip="true" prop="birth" label="出生日期" width="110">
            <template #default="scope">
              <span :key="scope.row.birth" v-format="'yyyy-MM-dd'">{{ scope.row.birth }}</span>
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
          <el-table-column :show-overflow-tooltip="true" prop="occupations" label="职业">
            <template #default="scope">
              <template v-if="scope.row.occupations.length > 0">
                <span>
                  {{ scope.row.occupations.map((item) => item.name).join(" / ") }}
                </span>
              </template>
              <template v-else>
                {{ "暂无" }}
              </template>
            </template>
          </el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="gender" width="60" label="性别">
            <template #default="scope">
              <span>{{ scope.row.gender * 1 === 0 ? "男" : "女" }}</span>
            </template>
          </el-table-column>
          <el-table-column prop="createTime" label="创建时间" :sortable="true" width="160">
            <template #default="scope">
              <span v-format="'yyyy-MM-dd hh:mm'">{{ scope.row.createTime }}</span>
            </template>
          </el-table-column>
          <el-table-column v-if="isShowOperator" fixed="right" label="操作" width="140">
            <template #default="scope">
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="actorRouter(scope.row)"
                >查看</el-button
              >
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="editActor(scope.row)"
                >编辑</el-button
              >
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="deleteActorHandle(scope.row)"
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
    <template v-if="total > count">
      <div class="page">
        <el-pagination
          background
          @current-change="pageChange"
          layout="prev, pager, next"
          :total="total"
          :page-size="count"
        />
      </div>
    </template>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue"
import { IActor } from "@/types/actor"

export default defineComponent({
  name: "ActorTable",
  props: {
    actorList: {
      type: Object
    },
    total: {
      type: Number,
      default: 0
    },
    count: {
      type: Number,
      default: 10
    },
    height: {
      type: Number,
      default: 490
    },
    isShowOperator: {
      type: Boolean,
      default: true
    }
  },
  emits: ["actorRouter", "editActor", "deleteActorHandle", "pageChange"],
  setup(props, context) {
    const actorRouter = (item: IActor) => {
      context.emit("actorRouter", item)
    }
    const editActor = (item: IActor) => {
      context.emit("editActor", item)
    }
    const deleteActorHandle = (item: IActor) => {
      context.emit("deleteActorHandle", item)
    }
    const pageChange = (e: number) => {
      context.emit("pageChange", e)
    }
    return {
      actorRouter,
      editActor,
      deleteActorHandle,
      pageChange
    }
  }
})
</script>

<style scoped lang="less">
.actor-table {
  margin: 5px 0 0 0;
  .page {
    display: flex;
    padding: 15px 0;
    justify-content: center;
  }
}
</style>
