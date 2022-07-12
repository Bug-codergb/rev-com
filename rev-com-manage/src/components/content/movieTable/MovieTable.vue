<template>
  <div class="movie-table">
    <template v-if="movieList.list && movieList.list.length > 0">
      <el-table :data="movieList.list" :height="height" row-key="id" :highlight-current-row="true">
        <el-table-column :show-overflow-tooltip="true" prop="name" label="电影名称" width="130" />
        <el-table-column :show-overflow-tooltip="true" prop="alias" label="电影别名" width="140" />
        <el-table-column :show-overflow-tooltip="true" prop="directors" label="导演" width="150">
          <template #default="scope">
            <span>{{ scope.row.directors.map((item) => item.name).join(" / ") }}</span>
          </template>
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true" prop="actors" label="演员" min-width="180">
          <template #default="scope">
            <span>{{ scope.row.actors.map((item) => item.name).join(" / ") }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="screenwriters"
          label="编剧"
          width="140"
        >
          <template #default="scope">
            <span>{{ scope.row.screenwriters.map((item) => item.name).join(" / ") }}</span>
          </template>
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true" prop="area" label="地区" width="120">
          <template #default="scope">
            <span>{{ scope.row.area.map((item) => item.name).join(" / ") }}</span>
          </template>
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true" prop="categories" label="类型" width="120">
          <template #default="scope">
            <span>{{ scope.row.categories.map((item) => item.name).join(" / ") }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="form.name"
          width="90"
          label="影视形式"
        />
        <el-table-column :show-overflow-tooltip="true" prop="language" label="语言" width="80" />
        <el-table-column
          :show-overflow-tooltip="true"
          prop="releaseTime"
          label="上映日期"
          sortable
          width="130"
        >
          <template #default="scope">
            <span v-format="'yyyy-MM-dd'">{{ scope.row.releaseTime }}</span>
          </template>
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true" prop="duration" label="时长" width="80">
          <template #default="scope">
            <span v-format="'mm:ss'">{{ scope.row.duration }}</span>
          </template>
        </el-table-column>
        <el-table-column v-if="isShowOperator" fixed="right" label="操作" width="140">
          <template #default="scope">
            <el-button
              type="text"
              size="small"
              class="table-control-btn"
              @click="movieRouter(scope.row)"
              >查看</el-button
            >
            <el-button
              type="text"
              size="small"
              class="table-control-btn"
              @click="editMovie(scope.row)"
              >编辑</el-button
            >
            <el-button
              type="text"
              size="small"
              class="table-control-btn"
              @click="deleteMovieHandle(scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>
    <template v-if="total < 1">
      <el-empty description="暂无导演信息" />
    </template>
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
import { defineComponent } from "vue";
import { IMovie } from "@/types/movie";

export default defineComponent({
  name: "MovieTable",
  props: {
    movieList: {
      type: Object
    },
    total: {
      type: Number
    },
    count: {
      type: Number,
      default: 10
    },
    height: {
      type: Number,
      default: 500
    },
    isShowOperator: {
      type: Boolean,
      default: true
    }
  },
  emits: ["editMovie", "deleteMovieHandle", "pageChange", "movieRouter"],
  setup(props, context) {
    const editMovie = (item: IMovie) => {
      context.emit("editMovie", item);
    };
    const deleteMovieHandle = (item: IMovie) => {
      context.emit("deleteMovieHandle", item);
    };
    const pageChange = (item: IMovie) => {
      context.emit("pageChange", item);
    };
    const movieRouter = (item: IMovie) => {
      context.emit("movieRouter", item);
    };
    return {
      editMovie,
      deleteMovieHandle,
      pageChange,
      movieRouter
    };
  }
});
</script>

<style scoped lang="less">
.movie-table {
  margin: 5px 0 0 0;
  .page {
    display: flex;
    justify-content: center;
    padding: 15px 0;
  }
}
</style>
