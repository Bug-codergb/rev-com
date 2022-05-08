<template>
  <div class="login">
    登录
    <button @click="homeRouter">登录</button>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue"
import { useRouter } from "vue-router";
export default defineComponent({
  name: "Login",
  setup() {
    const router = useRouter()
    const homeRouter = () => {
      router.push({
        path: "/Home"
      })
    }
    return {
      homeRouter
    }
  }
})
</script>

<style scoped lang="less"></style>
