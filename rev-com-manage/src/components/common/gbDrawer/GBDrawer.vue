<template>
  <div class="gb-drawer">
    <el-drawer
      v-model="drawer"
      direction="rtl"
      :show-close="false"
      :destroy-on-close="true"
      size="35%"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">{{ title }}</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <slot name="add"></slot>
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, computed, onBeforeUnmount } from "vue";
import emitter from "@/utils/evenBus";
export default defineComponent({
  name: "GBDrawer",
  props: {
    title: {
      type: String,
      default: "创建"
    },
    modelValue: {
      type: Boolean,
      required: true
    }
  },
  emits: ["define", "update:modelValue"],
  setup(props, context) {
    const drawer = computed({
      get() {
        return props.modelValue;
      },
      set(newVal: any) {
        context.emit("update:modelValue", newVal);
      }
    });
    const define = () => {
      emitter.emit("drawerDefine");
    };
    onBeforeUnmount(() => {
      emitter.off("drawerDefine");
    });
    return {
      define,
      drawer
    };
  }
});
</script>

<style scoped lang="less"></style>
