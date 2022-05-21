<template>
  <div class="nav-list">
    <div class="logo">
      <span class="sys-title" :class="{ isOpacity: collapse }"> Rev-Com </span>
    </div>
    <el-menu
      :default-active="defaultActive"
      background-color="#0c2135"
      text-color="#b7bdc3"
      active-text-color="#0a60bd"
      :collapse="collapse"
      :unique-opened="true"
    >
      <template v-for="item in menu" :key="item.name">
        <el-sub-menu :index="item.index">
          <template #title>
            <el-icon>
              <component :is="item.icon"></component>
            </el-icon>
            <span>{{ item.name }}</span>
          </template>
          <template v-for="it in item.children" :key="it.name">
            <el-menu-item :index="`${it.index}`" @click="navRouter(it.path)">
              {{ it.name }}
            </el-menu-item>
          </template>
        </el-sub-menu>
      </template>
    </el-menu>
  </div>
</template>

<script lang="ts">
import { useRouter } from "vue-router"
import { defineComponent, ref } from "vue"
import { menu } from "@/constant/menu"
import pathMapMenu from "@/utils/pathMapMenu"
import { Film, Notebook, User, Setting, Mic } from "@element-plus/icons-vue"
export default defineComponent({
  name: "NavList",
  components: {
    Film,
    Notebook,
    User,
    Setting,
    Mic
  },
  props: {
    collapse: {
      type: Boolean,
      default: false
    }
  },
  setup() {
    const router = useRouter()
    const menuItem = pathMapMenu(menu, router.currentRoute.value.path)
    const defaultActive = ref(menuItem ? menuItem.index : "1001")
    const navRouter = (path: string) => {
      router.push({
        path: path
      })
    }
    return {
      menu,
      navRouter,
      defaultActive
    }
  }
})
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
  /deep/.el-menu .el-menu--inline {
    background-color: #001529 !important;
  }
  /deep/ .el-submenu__title {
    background-color: #001529 !important;
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
