<template>
  <div class="nav-header">
    <div class="is-nav-fold" @click="changeFold">
      <template v-if="isFold">
        <el-icon><expand /></el-icon>
      </template>
      <template v-if="!isFold">
        <el-icon><fold /></el-icon>
      </template>
    </div>
  </div>
</template>

<script>
import { ref } from "vue"
import { Expand, Fold } from "@element-plus/icons-vue"
export default {
  name: "NavHeader",
  components: {
    Expand,
    Fold
  },
  emits: ["changeFold"],
  setup(props, { emit }) {
    const isFold = ref(false)
    const changeFold = () => {
      isFold.value = !isFold.value
      emit("changeFold", isFold.value)
    }
    return {
      isFold,
      changeFold
    }
  }
}
</script>

<style scoped lang="less">
.nav-header {
  border-bottom: 1px dotted #00a1d6;
  height: 100%;
  width: 100%;
  .is-nav-fold {
    height: 100%;
    display: flex;
    align-items: center;
    padding: 0 10px 0 0;
    cursor: pointer;
    &:hover {
      .el-icon {
        color: #000;
      }
    }
    .el-icon {
      font-size: 27px;
      color: #0c2135;
    }
  }
}
</style>
