<template>
  <div class="movie-list">
    <MovieTable
      :movie-list="movieList"
      :total="total"
      @pageChange="pageChange"
      :count="7"
      :height="350"
      :is-show-operator="false"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, onMounted, ref } from "vue";
import MovieTable from "@/components/content/movieTable/MovieTable.vue";
import { getMovieByDid } from "@/network/movie";
import { IMovie } from "@/types/movie";

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
    });
    const total = ref(0);
    const getMovieByDidRequest = async (page: number, limit: number) => {
      const data = await getMovieByDid(props.id, page, limit);
      if (data.status === 200) {
        movieList.list = data.data.data;
        total.value = data.data.total;
      }
    };
    onMounted(async () => {
      await getMovieByDidRequest(1, 7);
    });
    const pageChange = (e: number) => {
      getMovieByDidRequest(e, 7);
    };
    return {
      movieList,
      total,
      pageChange
    };
  }
});
</script>

<style scoped lang="less"></style>
