<template>
  <div class="movie-list">
    <MovieTable
      @editMovie="editMovie"
      @deleteMovieHandle="deleteMovieHandle"
      @movieRouter="movieRouter"
      @pageChange="pageChange"
      :total="total"
      :movie-list="movieList"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref, watch } from "vue"
import { useRouter } from "vue-router"
import { deleteMovie, getAllMovie } from "@/network/movie"
import { IResponseType } from "@/types/responseType"
import { IMovie } from "@/types/movie"
import { IPageResult } from "@/types/pageResult"
import { ElMessage, ElMessageBox } from "element-plus/lib/components"
import MovieTable from "@/components/content/movieTable/MovieTable.vue"
export default defineComponent({
  name: "Movie",
  components: {
    MovieTable
  },
  emits: ["editMovie"],
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
    const router = useRouter()
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
      getAllMovie<IResponseType<IPageResult<IMovie[]>>>(page, 10, keyword, form, cate, area).then(
        (data) => {
          if (data.status === 200) {
            movieList.list = data.data.data
            total.value = data.data.total
          }
        }
      )
    }
    watch(props, (newVal) => {
      getAllMovieRequest(1, 10, newVal.keyword, newVal.form, newVal.cate, newVal.area)
    })
    onMounted(() => {
      getAllMovieRequest(1, 10, props.keyword, props.form, props.cate, props.area)
    })
    const pageChange = (e: number) => {
      getAllMovieRequest(e, 10, props.keyword, props.form, props.cate, props.area)
    }
    const editMovie = (item: IMovie) => {
      context.emit("editMovie", item)
    }
    const movieRouter = (item: IMovie) => {
      router.push({
        path: "/Home/movie/movieDetail",
        query: {
          id: item.id
        }
      })
    }
    const deleteMovieHandle = (item: IMovie) => {
      ElMessageBox.confirm("确定要删除该电影么?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          deleteMovie(item.id).then((data) => {
            if (data.status === 200) {
              getAllMovieRequest(1, 10, props.keyword, props.form, props.cate, props.area)
              ElMessage({
                type: "success",
                message: "删除成功"
              })
            }
          })
        })
        .catch(() => {})
    }
    return {
      movieList,
      total,
      pageChange,
      editMovie,
      movieRouter,
      deleteMovieHandle
    }
  }
})
</script>

<style scoped lang="less">
.movie-list {
}
</style>
