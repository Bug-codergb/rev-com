<template>
  <div class="director-detail">
    <el-row>
      <el-col :span="4">
        <div class="img-container">
          <img :src="directorDetail.detail.avatarUrl" />
        </div>
      </el-col>
      <el-col :span="18">
        <el-row justify="start">
          <el-col :span="12">
            <div class="director-name">
              <span class="key">姓名:</span>
              <span>{{ directorDetail.detail.name }}</span>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="director-alias">
              <span class="key">别名:</span>
              <span>{{ directorDetail.detail.alias }}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <div class="director-gender">
              <span class="key">性别:</span>
              <span>{{ directorDetail.detail.gender * 1 === 0 ? "男" : "女" }}</span>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="director-birth-place">
              <span class="key">出生地:</span>
              <span>{{ directorDetail.detail.birthPlace }}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <div class="director-createTime">
              <span class="key">创建时间:</span>
              <span v-format="'yyyy-MM-hh mm:ss'">{{ directorDetail.detail.createTime }}</span>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="director-occ">
              <span class="key">职业:</span>
              <span
                v-for="it in directorDetail.detail.occupations"
                :key="it.id"
                class="occupations"
              >
                {{ it.name }}
              </span>
            </div></el-col
          >
        </el-row>
        <el-row>
          <el-col>
            <div class="director-desc">
              <span class="key">简介:</span>
              <span class="value">{{ directorDetail.detail.description.trim() }}</span>
            </div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <div class="movie-list">
      <el-tabs>
        <el-tab-pane label="导演作品">
          <movie-list :id="directorDetail.detail.id" />
        </el-tab-pane>
        <el-tab-pane label="合作演员">Config</el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive } from "vue"
import { useRoute } from "vue-router"
import { IDirector } from "@/types/director"
import MovieList from "@/components/content/detail/directorDetail/childCpn/movieList/MovieList.vue"
export default defineComponent({
  name: "DirectorDetail",
  components: {
    MovieList
  },
  setup(props, context) {
    const route = useRoute()
    const directorDetail = reactive<{ detail: IDirector | null }>({
      detail: null
    })
    directorDetail.detail = JSON.parse(
      decodeURIComponent(window.atob(`${route.query.detail}` ?? ""))
    )
    console.log(directorDetail.detail)
    return {
      directorDetail
    }
  }
})
</script>

<style scoped lang="less">
.director-detail {
  .img-container {
    width: 170px;
    height: 170px;
    background-color: #f0f2f5;
    img {
      height: 100%;
    }
  }
  .director-name,
  .director-alias,
  .director-birth-place,
  .director-gender,
  .director-occ,
  .director-createTime,
  .director-desc {
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
  .occupations {
    color: #00a1d6;
    margin: 0 5px 0 0;
    cursor: pointer;
    &::after {
      content: " /";
    }
  }
  .movie-list {
    margin: 15px 0 0 0;
  }
}
</style>
