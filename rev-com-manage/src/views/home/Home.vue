<template>
  <div class="home">
    <el-container class="home-content">
      <el-aside :width="isCollapse ? '63px' : '180px'">
        <NavList :collapse="isCollapse" />
      </el-aside>
      <el-container>
        <el-header>
          <nav-header @changeFold="changeFold" />
        </el-header>
        <el-main>
          <router-view class="home-router-view" />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts">
import NavList from "@/components/content/navList/NavList.vue";
import NavHeader from "@/components/content/navHeader/NavHeader.vue";
import { ref } from "vue";
export default {
  name: "Home",
  components: { NavHeader, NavList },
  setup() {
    const isCollapse = ref(false);
    const changeFold = (isFold: boolean) => {
      isCollapse.value = isFold;
    };
    return {
      isCollapse,
      changeFold
    };
  }
};
</script>

<style scoped lang="less">
.home {
  height: 100%;
  .home-content {
    height: 100%;
  }
  .el-aside {
    overflow-x: hidden;
    overflow-y: auto;
    text-align: left;
    cursor: pointer;
    background-color: #001529;
    transition: width 0.3s linear;
    scrollbar-width: none; /* firefox */
    -ms-overflow-style: none; /* IE 10+ */
    &::-webkit-scrollbar {
      display: none;
    }
  }
  .el-main {
    color: #333;
    text-align: center;
    background-color: #f0f2f5;
  }
  .home-router-view {
    background-color: #fff;
    height: 100%;
    width: 100%;
    padding: 20px;
    overflow-y: scroll;
  }
}
</style>
