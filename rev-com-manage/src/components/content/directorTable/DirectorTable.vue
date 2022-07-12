<template>
  <div class="director-list">
    <template v-if="directList.list && directList.list.length > 0">
      <el-table :data="directList.list" :height="height" row-key="id">
        <el-table-column :show-overflow-tooltip="true" prop="name" label="导演头像" width="80">
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
          min-width="120"
          label="职业"
        >
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
        <el-table-column :show-overflow-tooltip="true" prop="gender" width="80" label="性别">
          <template #default="scope">
            <span>{{ scope.row.gender * 1 === 0 ? "男" : "女" }}</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="description"
          label="演员简介"
          min-width="130"
          :show-overflow-tooltip="false"
        >
          <template #default="scope">
            <span class="text-nowrap">{{ scope.row.description }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" :sortable="true" min-width="100">
          <template #default="scope">
            <span v-format="'yyyy-MM-dd hh:mm'">{{ scope.row.createTime }}</span>
          </template>
        </el-table-column>
        <el-table-column v-if="isShowOperator" fixed="right" label="操作" min-width="100">
          <template #default="scope">
            <el-button
              type="text"
              size="small"
              class="table-control-btn"
              @click="directorRouter(scope.row)"
              >查看</el-button
            >
            <el-button
              type="text"
              size="small"
              class="table-control-btn"
              @click="editDirector(scope.row)"
              >编辑</el-button
            >
            <el-button
              type="text"
              size="small"
              class="table-control-btn"
              @click="deleteDirectorHandle(scope.row)"
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
        :default-current-page="1"
        :total="total"
        :page-size="count"
      />
    </div>
  </template>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { IDirector } from "@/types/director";

export default defineComponent({
  name: "DirectorTable",
  props: {
    directList: {
      type: Object
    },
    total: {
      type: Number,
      default: 0
    },
    count: {
      type: Number,
      default: 0
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
  emits: ["directorRouter", "editDirector", "deleteDirectorHandle", "pageChange"],
  setup(props, context) {
    const directorRouter = (item: IDirector) => {
      context.emit("directorRouter", item);
    };
    const editDirector = (item: IDirector) => {
      context.emit("editDirector", item);
    };
    const deleteDirectorHandle = (item: IDirector) => {
      context.emit("deleteDirectorHandle", item);
    };
    const pageChange = (e: number) => {
      context.emit("pageChange", e);
    };
    return {
      directorRouter,
      editDirector,
      deleteDirectorHandle,
      pageChange
    };
  }
});
</script>

<style scoped lang="less">
.director-list {
  margin: 5px 0 0 0;
}
.page {
  display: flex;
  padding: 15px 0;
  justify-content: center !important;
}
</style>
