<template>
  <div class="movie-list">
    <template v-if="movieList.list && movieList.list.length > 0">
      <el-table
        :data="movieList.list"
        :height="500"
        row-key="id"
        :highlight-current-row="true"
      >
        <el-table-column
          :show-overflow-tooltip="true"
          prop="name"
          label="电影名称"
          width="130"
        />
        <el-table-column
          :show-overflow-tooltip="true"
          prop="alias"
          label="电影别名"
          width="140"
        />
        <el-table-column
          :show-overflow-tooltip="true"
          prop="directors"
          label="导演"
          width="150"
        >
          <template #default="scope">
            <span>{{
              scope.row.directors.map((item) => item.name).join(" / ")
            }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="actors"
          label="演员"
          min-width="180"
        >
          <template #default="scope">
            <span>{{
              scope.row.actors.map((item) => item.name).join(" / ")
            }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="screenwriters"
          label="编剧"
          width="140"
        >
          <template #default="scope">
            <span>{{
              scope.row.screenwriters.map((item) => item.name).join(" / ")
            }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="area"
          label="地区"
          width="120"
        >
          <template #default="scope">
            <span>{{
              scope.row.area.map((item) => item.name).join(" / ")
            }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="categories"
          label="类型"
          width="120"
        >
          <template #default="scope">
            <span>{{
              scope.row.categories.map((item) => item.name).join(" / ")
            }}</span>
          </template>
        </el-table-column>
        <el-table-column
          :show-overflow-tooltip="true"
          prop="form.name"
          width="90"
          label="影视形式"
        />
        <el-table-column
          :show-overflow-tooltip="true"
          prop="language"
          label="语言"
          width="80"
        />
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
        <el-table-column
          :show-overflow-tooltip="true"
          prop="duration"
          label="时长"
          width="80"
        >
          <template #default="scope">
            <span v-format="'mm:ss'">{{ scope.row.duration }}</span>
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
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref, watch } from "vue"
import { getAllMovie } from "@/network/movie"
import { IResponseType } from "@/types/responseType"
import { IMovie } from "@/types/movie"
import { IPageResult } from "@/types/pageResult"

export default defineComponent({
  name: "Movie",
  props: {
    keyword: {
      type: String,
      default: ""
    },
    cate: {
      type: String,
      default: ""
    },
    area: {
      type: String,
      default: ""
    },
    form: {
      type: String,
      default: ""
    }
  },
  setup(props, context) {
    const movieList = reactive<{ list: IMovie[] }>({
      list: []
    })
    const total = ref(0)
    const getAllMovieRequest = (
      page: number,
      limit: number,
      keyword: string,
      form: string,
      cate: string,
      area: string
    ) => {
      getAllMovie<IResponseType<IPageResult<IMovie[]>>>(
        page,
        10,
        keyword,
        form,
        cate,
        area
      ).then((data) => {
        if (data.status === 200) {
          movieList.list = data.data.data
          total.value = data.data.total
        }
      })
    }
    watch(props, (newVal) => {
      getAllMovieRequest(
        1,
        10,
        newVal.keyword,
        newVal.form,
        newVal.cate,
        newVal.area
      )
    })
    onMounted(() => {
      getAllMovieRequest(
        1,
        10,
        props.keyword,
        props.form,
        props.cate,
        props.area
      )
    })
    const pageChange = (e: number) => {
      getAllMovieRequest(
        e,
        10,
        props.keyword,
        props.form,
        props.cate,
        props.area
      )
    }
    return {
      movieList,
      total,
      pageChange
    }
  }
})
</script>

<style scoped lang="less">
.movie-list {
  .page {
    display: flex;
    justify-content: center;
    padding: 15px 0;
  }
}
</style>
