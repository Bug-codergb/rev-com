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
    <div class="right-content">
      <el-dropdown trigger="click" @command="handleCommand">
        <div class="user-avatar">
          <el-icon><UserFilled /></el-icon>
        </div>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item command="profile">个人中心</el-dropdown-item>
            <el-dropdown-item command="exit">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang="ts">
import { ref, defineComponent } from "vue"
import { useRouter } from "vue-router"
import { Expand, Fold, UserFilled } from "@element-plus/icons-vue"
export default defineComponent({
  name: "NavHeader",
  components: {
    Expand,
    Fold,
    UserFilled
  },
  emits: ["changeFold"],
  setup(props, { emit }) {
    const isFold = ref(false)
    const router = useRouter()
    const changeFold = () => {
      isFold.value = !isFold.value
      emit("changeFold", isFold.value)
    }
    const handleCommand = (e: string) => {
      if (e === "exit") {
        router.push({
          path: "/Login"
        })
      }
    }
    return {
      isFold,
      changeFold,
      handleCommand
    }
  }
})
</script>

<style scoped lang="less">
.nav-header {
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: space-between;
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
  .right-content {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 20px 0 0;
    .user-avatar {
      background-color: #dcdfe6;
      padding: 7px 8px;
      border-radius: 50%;
      cursor: pointer;
      .el-icon {
        font-size: 24px;
      }
    }
  }
}
</style>
