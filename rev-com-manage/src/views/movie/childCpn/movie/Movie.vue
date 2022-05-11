<template>
  <div class="movie-list">
    <template v-if="movieList.list && movieList.list.length > 0">
      <el-table :data="movieList.list" :height="490">
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
          prop="language"
          label="语言"
          width="80"
        />
        <el-table-column
          :show-overflow-tooltip="true"
          prop="releaseTime"
          label="上映日期"
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
        <el-table-column
          :show-overflow-tooltip="true"
          prop="form.name"
          width="90"
          label="影视形式"
        />

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
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue"
import { getAllMovie } from "@/network/movie"
import { IResponseType } from "@/types/responseType"
import { IMovie } from "@/types/movie"
import { IPageResult } from "@/types/pageResult"
import { formatTime } from "@/utils/formatTime"
export default defineComponent({
  name: "Movie",
  setup() {
    const movieList = reactive<{ list: IMovie[] }>({
      list: []
    })
    const total = ref(0)
    onMounted(() => {
      getAllMovie<IResponseType<IPageResult<IMovie[]>>>(1, 10).then((data) => {
        if (data.status === 200) {
          movieList.list = data.data.data
          total.value = data.data.total
        }
      })
    })
    const formatDate = (time: number | string, fm: string) => {
      return formatTime(time, fm)
    }
    return {
      movieList,
      total,
      formatDate
    }
  }
})
</script>

<style scoped lang="less"></style>
