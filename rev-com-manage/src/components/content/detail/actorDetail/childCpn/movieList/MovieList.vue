<template>
  <div class="movie-list">
    <MovieTable
      :movie-list="movieList"
      :count="7"
      :is-show-operator="false"
      :height="350"
      @pageChange="pageChange"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, onMounted } from "vue"
import MovieTable from "@/components/content/movieTable/MovieTable.vue"
import { IMovie } from "@/types/movie"
import { getMovieByAid } from "@/network/movie"

export default defineComponent({
  name: "MovieList",
  components: { MovieTable },
  props: {
    id: {
      type: String,
      default: ""
    }
  },
  setup(props, context) {
    const movieList = reactive<{ list: IMovie[] | null }>({
      list: null
    })
    const total = ref(0)
    const getMovieByAidRequest = async (page: number, limit: number) => {
      const data = await getMovieByAid(props.id, page, limit)
      if (data.status === 200) {
        movieList.list = data.data.data
        total.value = data.data.total
      }
    }
    onMounted(() => {
      getMovieByAidRequest(1, 7)
    })
    const pageChange = (e: number) => {
      getMovieByAidRequest(e, 7)
    }
    return {
      movieList,
      pageChange
    }
  }
})
</script>

<style scoped lang="less"></style>
