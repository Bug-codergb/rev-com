<template>
  <div class="movie">
    <div class="movie-header">
      <div class="movie-header-left">
        <div class="movie-search">
          <el-input
            v-model="keyword"
            placeholder="请输入电影/导演/演员/名称"
            clearable
            @input="keywordChange"
          />
        </div>
        <div class="cate-list">
          <el-select v-model="cate" class="m-2" filterable placeholder="请选择电影类型">
            <el-option
              v-for="item in cateList.list"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </div>
        <div class="form-list">
          <el-select v-model="form" class="m-2" filterable placeholder="请选择电影形式">
            <el-option
              v-for="item in formList.list"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </div>
        <div class="area-list">
          <el-select v-model="area" class="m-2" filterable placeholder="请选择电影地区">
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
      <div class="movie-header-right">
        <el-icon :class="{ active: isRotate }" @click="changeRotate"><refresh /></el-icon>
      </div>
    </div>
    <div class="movie-body">
      <movie-list
        :key="keyIndex"
        :keyword="keyword"
        :area="area"
        :cate="cate"
        :form="form"
        @editMovie="editMovie"
      />
    </div>
    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
      size="45%"
      @close="drawerClose"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加影视</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-movie ref="addMovieRef" :movieItem="movieItem" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue"
import { Refresh } from "@element-plus/icons-vue"
import { ElMessage } from "element-plus"
import { addMovie, updateCover, updateMovie, uploadCover } from "@/network/movie"
import { IResponseType } from "@/types/responseType"
import { getAllArea } from "@/network/movie/area"
import { IArea } from "@/types/area"
import { getAllForm } from "@/network/movie/form"
import { IForm } from "@/types/form"
import { getAllCate } from "@/network/movie/cate"
import { ICategory } from "@/types/category"
import MovieList from "./childCpn/movie/Movie.vue"
import AddMovie from "./childCpn/movie/childCpn/addMovie/AddMovie.vue"
import { IMovie } from "@/types/movie"
export default defineComponent({
  name: "Movie",
  components: {
    MovieList,
    AddMovie,
    Refresh
  },
  setup() {
    const isRotate = ref(false)
    const keyIndex = ref(0)
    const keyword = ref("")
    const area = ref("")
    const cate = ref("")
    const form = ref("")
    const drawer = ref(false)
    const direction = ref("rtl")
    const addMovieRef = ref<InstanceType<typeof AddMovie>>()
    const movieItem = reactive<{ item: null | IMovie }>({
      item: null
    })
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
    const changeRotate = () => {
      isRotate.value = true
      keyword.value = ""
      area.value = ""
      form.value = ""
      cate.value = ""
      setTimeout(() => {
        isRotate.value = false
      }, 2000)
    }
    const keywordChange = () => {}
    const define = () => {
      addMovieRef.value?.ruleFormRef?.validate(async (e) => {
        if (e) {
          if (addMovieRef.value) {
            const {
              name,
              language,
              alias,
              actor,
              area,
              cate,
              desc,
              director,
              form,
              releaseTime,
              screenwriter
            } = addMovieRef.value.movie
            if (!addMovieRef.value.isUpdate) {
              //创建电影
              const data = await addMovie(
                name,
                director,
                screenwriter,
                area,
                actor,
                language.join("/"),
                releaseTime,
                15000,
                alias,
                form,
                cate,
                desc
              )
              if (data.status === 200) {
                keyIndex.value += 1
                ElMessage({
                  message: "电影添加成功",
                  type: "success"
                })
                drawer.value = false
              }
              if (addMovieRef.value.cover && addMovieRef.value.cover.source) {
                const { cover } = addMovieRef.value
                if (cover.source instanceof FormData) {
                  const res = await uploadCover(data.data.id, cover.source)
                  console.log(res)
                }
              }
            } else {
              //更新电影
              if (movieItem.item) {
                const data = await updateMovie(
                  movieItem.item.id,
                  name,
                  director,
                  screenwriter,
                  area,
                  actor,
                  language.join("/"),
                  releaseTime,
                  1500,
                  alias,
                  form,
                  cate,
                  desc
                )
                if (data.status === 200) {
                  ElMessage({
                    message: "电影信息更新成功",
                    type: "success"
                  })
                  if (addMovieRef.value && addMovieRef.value.cover.source) {
                    const { cover } = addMovieRef.value
                    if (cover.source instanceof FormData) {
                      const res = await updateCover(movieItem.item.id, cover.source)
                      if (res.status === 200) {
                        drawer.value = false
                        keyIndex.value += 1
                      }
                    }
                  }
                  drawer.value = false
                  keyIndex.value += 1
                }
              }
            }
          }
        }
      })
    }
    const editMovie = (item: IMovie) => {
      drawer.value = true
      movieItem.item = item
    }
    const drawerClose = () => {
      movieItem.item = null
    }
    return {
      isRotate,
      changeRotate,
      keyword,
      keywordChange,
      areaList,
      formList,
      cateList,
      area,
      form,
      cate,
      drawer,
      direction,
      define,
      addMovieRef,
      keyIndex,
      editMovie,
      movieItem,
      drawerClose
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
    justify-content: space-between;
    .movie-header-left {
      display: flex;
      align-items: center;
    }
    .movie-header-right {
      background-color: #00a1d6;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 5px;
      border-radius: 4px;
      cursor: pointer;
      @keyframes test {
        from {
          transform: rotateZ(0deg);
        }
        to {
          transform: rotateZ(-360deg);
        }
      }
      .el-icon {
        font-size: 24px;
        color: #fff;
        &.active {
          animation: test 1s linear 0s 1;
        }
      }
    }
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
