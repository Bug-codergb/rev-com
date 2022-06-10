<template>
  <div></div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue"
import GBDrawer from "@/components/common/gbDrawer/GBDrawer.vue"
export default defineComponent({
  name: "AddGroup",
  components: {
    GBDrawer
  },
  setup() {
    const drawer = ref(false)
    const showDrawer = () => {
      drawer.value = true
    }
    const define = () => {}
    return {
      showDrawer,
      define
    }
  }
})
</script>

<style scoped lang="less"></style>
