<template>
  <div class="nav-list">
    <div class="logo">
      <span class="sys-title" :class="{ isOpacity: collapse }"> Rev-Com </span>
    </div>
    <el-menu
      default-active="11-1"
      background-color="#0c2135"
      text-color="#b7bdc3"
      active-text-color="#0a60bd"
      :collapse="collapse"
      :unique-opened="true"
    >
      <template v-for="item in menu" :key="item.name">
        <el-sub-menu :index="item.index">
          <template #title>
            <el-icon><box /></el-icon>
            <span>{{ item.name }}</span>
          </template>
          <template v-for="it in item.children" :key="it.name">
            <el-menu-item :index="`${it.index}`">
              {{ it.name }}
            </el-menu-item>
          </template>
        </el-sub-menu>
      </template>
    </el-menu>
  </div>
</template>

<script lang="ts">
import { menu } from "@/constant/menu"
import { Box } from "@element-plus/icons-vue"
export default {
  name: "NavList",
  components: {
    Box
  },
  props: {
    collapse: {
      type: Boolean,
      default: false
    }
  },
  setup() {
    return {
      menu
    }
  }
}
</script>
<style lang="less">
.nav-list {
  .el-sub-menu__title:hover {
    background-color: #0a1a2a !important;
  }
  .el-menu-item {
    min-width: 180px;
  }
  .el-menu {
    border-right-color: #0c2135 !important;
  }
}
</style>
<style scoped lang="less">
.nav-list {
  .logo {
    width: 179px;
    padding: 15px 0;
    background-color: #0c2135;
    text-align: center;
    .sys-title {
      color: #fff;
    }
    .isOpacity {
      color: transparent;
    }
  }
  width: 100%;
  /*.el-submenu {
    background-color: #001529 !important;
    // 二级菜单 ( 默认背景 )
    .el-menu-item {
      padding-left: 50px !important;
      background-color: #0c2135 !important;
    }
  }*/

  ::v-deep .el-submenu__title {
    background-color: #001529 !important;
  }

  // hover 高亮
  .el-menu-item:hover {
    color: #fff !important; // 菜单
  }

  .el-menu-item.is-active {
    color: #fff !important;
    background-color: #00a1d6 !important;
    width: 100% !important;
  }

  .el-menu-vertical:not(.el-menu--collapse) {
    width: 100%;
    height: calc(100% - 48px);
  }
}
</style>
