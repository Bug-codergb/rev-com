<template>
  <div class="movie">
    <div class="movie-header">
      <div class="movie-search">
        <el-input
          v-model="keyword"
          placeholder="请输入人导演名称"
          clearable
          @input="keywordChange"
        />
      </div>
      <div class="cate-list">
        <el-select
          v-model="cate"
          class="m-2"
          filterable
          placeholder="请选择电影类型"
        >
          <el-option
            v-for="item in cateList.list"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </div>
      <div class="form-list">
        <el-select
          v-model="form"
          class="m-2"
          filterable
          placeholder="请选择电影形式"
        >
          <el-option
            v-for="item in formList.list"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </div>
      <div class="area-list">
        <el-select
          v-model="area"
          class="m-2"
          filterable
          placeholder="请选择电影地区"
        >
          <el-option
            v-for="item in areaList.list"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </div>
      <div class="add-movie-btn">
        <el-button type="primary" @click="drawer = true">添加电影</el-button>
      </div>
    </div>
    <div class="movie-body">
      <movie-list />
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
          <div class="title">添加导演</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-movie ref="addMovieRef" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue"
import { getAllMovie } from "@/network/movie"
import { IResponseType } from "@/types/responseType"
import { IMovie } from "@/types/movie"
import { getAllArea } from "@/network/movie/area"
import { IArea } from "@/types/area"
import { getAllForm } from "@/network/movie/form"
import { IForm } from "@/types/form"
import { getAllCate } from "@/network/movie/cate"
import { ICategory } from "@/types/category"
import MovieList from "./childCpn/movie/Movie.vue"
import AddMovie from "./childCpn/movie/childCpn/addMovie/AddMovie.vue"
export default defineComponent({
  name: "Movie",
  components: {
    MovieList,
    AddMovie
  },
  setup() {
    const keyword = ref("")
    const area = ref("")
    const cate = ref("")
    const form = ref("")
    const drawer = ref(true)
    const direction = ref("rtl")
    const areaList = reactive<{ list: IArea[] }>({
      list: []
    })
    const cateList = reactive<{ list: ICategory[] }>({
      list: []
    })
    const formList = reactive<{ list: IForm[] }>({
      list: []
    })
    onMounted(() => {
      getAllMovie<IResponseType<IMovie[]>>(1, 10).then((data) => {
        console.log(data)
      })
      getAllArea<IResponseType<IArea[]>>().then((data) => {
        if (data.status === 200) {
          areaList.list = data.data
        }
      })
      getAllForm<IResponseType<IForm[]>>().then((data) => {
        if (data.status === 200) {
          formList.list = data.data
        }
      })
      getAllCate<IResponseType<ICategory[]>>().then((data) => {
        if (data.status === 200) {
          cateList.list = data.data
        }
      })
    })
    const keywordChange = () => {}
    return {
      keyword,
      keywordChange,
      areaList,
      formList,
      cateList,
      area,
      form,
      cate,
      drawer,
      direction
    }
  }
})
</script>

<style scoped lang="less">
.movie {
  .movie-header {
    display: flex;
    align-items: center;
    border-bottom: 1px solid #dcdfe6;
    padding: 0 0 15px 0;
    .movie-search,
    .cate-list,
    .form-list {
      margin: 0 20px 0 0;
    }
    .add-movie-btn {
      margin: 0 0 0 20px;
      .el-button {
        padding: 19px 20px;
      }
    }
  }
}
</style>
