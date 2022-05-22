<template>
  <div class="actor-detail">
    <el-row>
      <el-col :span="4">
        <div class="img-container">
          <img :src="actorDetail.detail.avatarUrl" />
        </div>
      </el-col>
      <el-col :span="18">
        <el-row justify="start">
          <el-col :span="8">
            <div class="actor-name">
              <span class="key">姓名:</span>
              <span>{{ actorDetail.detail.name }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="actor-alias">
              <span class="key">别名:</span>
              <span>{{ actorDetail.detail.alias }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="actor-foreign-name">
              <span class="key">外文名:</span>
              <span>{{ actorDetail.detail.foreignName }}</span>
            </div>
          </el-col>
        </el-row>
        <el-row justify="start">
          <el-col :span="8">
            <div class="actor-constellation">
              <span class="key">星座:</span>
              <span>{{ actorDetail.detail.constellation }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="actor-family">
              <span class="key">家庭成员:</span>
              <span>{{ actorDetail.detail.family }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="actor-occ">
              <span class="key">职业:</span>
              <span v-for="it in actorDetail.detail.occupations" :key="it.id" class="occupations">
                {{ it.name }}
              </span>
            </div></el-col
          >
        </el-row>
        <el-row>
          <el-col :span="8">
            <div class="actor-birth">
              <span class="key">生日:</span>
              <span v-format="'yyyy-MM-dd'">{{ actorDetail.detail.birth }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="actor-birth-place">
              <span class="key">出生地:</span>
              <span>{{ actorDetail.detail.birthPlace }}</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="actor-createTime">
              <span class="key">创建时间:</span>
              <span v-format="'yyyy-MM-hh mm:ss'">{{ actorDetail.detail.createTime }}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <div class="actor-desc">
              <span class="key">简介:</span>
              <span class="value">{{ actorDetail.detail.description.trim() }}</span>
            </div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <div class="work-list">
      <el-tabs>
        <el-tab-pane label="参与作品">
          <movie-list :id="actorDetail.detail.id" />
        </el-tab-pane>
        <el-tab-pane label="合作演员">
          <ActorList :id="actorDetail.detail.id" />
        </el-tab-pane>
        <el-tab-pane label="合作导演">
          <DirectorList :id="actorDetail.detail.id" />
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive } from "vue"
import { useRoute } from "vue-router"
import { IActor } from "@/types/actor"
import MovieList from "@/components/content/detail/actorDetail/childCpn/movieList/MovieList.vue"
import ActorList from "@/components/content/detail/actorDetail/childCpn/actorList/ActorList.vue"
import DirectorList from "@/components/content/detail/actorDetail/childCpn/directorList/DirectorList.vue"
export default defineComponent({
  name: "ActorDetail",
  components: {
    DirectorList,
    MovieList,
    ActorList
  },
  setup(props, context) {
    const route = useRoute()
    const actorDetail = reactive<{ detail: IActor | null }>({
      detail: null
    })
    actorDetail.detail = JSON.parse(decodeURIComponent(window.atob(`${route.query.detail}` ?? "")))
    console.log(actorDetail.detail)
    return {
      actorDetail
    }
  }
})
</script>

<style scoped lang="less">
.actor-detail {
  .img-container {
    width: 170px;
    height: 170px;
    background-color: #f0f2f5;
    img {
      height: 100%;
    }
  }
  .actor-name,
  .actor-alias,
  .actor-foreign-name,
  .actor-birth-place,
  .actor-constellation,
  .actor-occ,
  .actor-family,
  .actor-createTime,
  .actor-birth,
  .actor-desc {
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
  .work-list {
    margin: 5px 0 0 0;
  }
}
</style>
