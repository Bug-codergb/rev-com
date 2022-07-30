<template>
  <div class="movie-data">
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="电影奖项" name="movie-awards">User</el-tab-pane>
      <el-tab-pane label="奖项" name="second">Config</el-tab-pane>
      <el-tab-pane label="奖项" name="third">Role</el-tab-pane>
      <el-tab-pane label="奖项" name="fourth">Task</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import type { TabsPaneContext } from "element-plus";

const activeName = ref("movie-awards");
const handleClick = (tab: TabsPaneContext, event: Event) => {
  console.log(tab, event);
};
</script>

<style scoped></style>
