<template>
  <div class="movie-detail">
    <el-row v-if="movieDetail.detail">
      <el-col :span="4">
        <div class="img-container centered">
          <img :src="movieDetail.detail.coverUrl" />
        </div>
      </el-col>
      <el-col :span="18">
        <el-row justify="start">
          <el-col :span="8">
            <div class="movie-name">
              <span class="key">姓名:</span>
              <span>{{ movieDetail.detail.name }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="movie-alias">
              <span class="key">别名:</span>
              <span>{{ movieDetail.detail.alias }}</span>
            </div>
          </el-col>
        </el-row>
        <el-row justify="start">
          <el-col :span="8">
            <div class="movie-releaseTime">
              <span class="key">上映时间:</span>
              <span v-format="'yyyy-MM-dd'">{{ movieDetail.detail.releaseTime }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="movie-form">
              <span class="key">形式:</span>
              <span>{{ movieDetail.detail.form.name }}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <div class="movie-language">
              <span class="key">语言:</span>
              <span>{{ movieDetail.detail.language }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="movie-cate">
              <span class="key">分类:</span>
              <template v-if="movieDetail.detail.categories.length > 0">
                <span
                  v-for="(item, index) in movieDetail.detail.categories"
                  :key="item.id"
                  class="cate-item"
                  >{{ item.name }}
                  <template v-if="index !== movieDetail.detail.categories.length - 1"> / </template>
                </span>
              </template>
              <template v-else>
                <span>暂无</span>
              </template>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <div class="movie-desc">
              <span class="key">简介:</span>
              <span class="value">{{ movieDetail.detail.description.trim() }}</span>
            </div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <template v-for="it in ['directors', 'actors', 'screenwriters']" :key="it">
      <el-row v-if="movieDetail.detail" :style="{ marginTop: '20px' }">
        <el-col>
          <el-card class="box-card">
            <template #header>
              <div class="card-header">
                <span>{{ it === "directors" ? "导演" : it === "actors" ? "演员" : "编剧" }}</span>
              </div>
            </template>
            <div class="card-item-outer">
              <template
                v-if="
                  movieDetail.detail && movieDetail.detail[it] && movieDetail.detail[it].length > 0
                "
              >
                <div
                  v-for="(item, index) in movieDetail.detail[it]"
                  :key="item.id"
                  class="card-item"
                >
                  {{ item.name }}
                  <template v-if="index !== movieDetail.detail[it].length - 1">/</template>
                </div>
              </template>
              <template v-else>
                <div class="card-item">暂无</div>
              </template>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </template>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, onMounted } from "vue"
import { useRoute } from "vue-router"
import { IMovie } from "@/types/movie"
import { ElCard } from "element-plus"
import { getMovieDetail } from "@/network/movie"
export default defineComponent({
  name: "MovieDetail",
  components: {
    ElCard
  },
  setup(props, context) {
    const route = useRoute()
    const id = ref("")
    const movieDetail = reactive<{ detail: IMovie | null }>({
      detail: null
    })
    id.value = `${route.query.id ?? ""}`
    onMounted(async () => {
      const data = await getMovieDetail(id.value)
      if (data.status === 200) {
        movieDetail.detail = data.data
      }
    })

    return {
      movieDetail
    }
  }
})
</script>

<style scoped lang="less">
.movie-detail {
  .img-container {
    width: 170px;
    height: 170px;
    background-color: #f0f2f5;
    overflow: hidden;
    img {
      height: 100%;
    }
  }
  .movie-name,
  .movie-alias,
  .movie-form,
  .movie-language,
  .movie-cate,
  .movie-releaseTime,
  .movie-desc {
    width: 100%;
    display: flex;
    justify-content: flex-start;
    padding: 0 0 15px 0;
    .key {
      display: inline-block;
      width: 80px;
      text-align: left;
      color: #9b9b9b;
      font-size: 14px;
    }
    .value {
      text-align: left;
      display: inline-block;
      width: 85%;
      line-height: 22px;
    }
  }
  .cate-item {
    color: #00a1d6;
  }
  .box-card {
    .card-header {
      display: flex;
      justify-content: space-between;
    }
    .card-item-outer {
      display: flex;
      .card-item {
        margin: 0 20px 0 0;
        color: #00a1d6;
        cursor: pointer;
      }
    }
  }
}
</style>
