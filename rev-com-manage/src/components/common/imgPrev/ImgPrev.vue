<template>
  <div class="img-prev-outer" @mouseenter="maskEnter" @mouseleave="maskLeave">
    <template v-if="!isShowPrev"><input type="file" @change="fileChange" /></template>
    <template v-if="isShowPrev"><img :src="imgURL" /></template>
    <template v-if="!isShowPrev"
      ><el-icon><Picture /></el-icon
    ></template>
    <template v-if="isShowPrev && isShowMask">
      <div class="mask" @click="maskClick">
        <el-icon><delete-filled /></el-icon>
      </div>
    </template>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import { ElMessage } from "element-plus/lib/components";
import { Picture, DeleteFilled } from "@element-plus/icons-vue";
export default defineComponent({
  name: "ImgPrev",
  components: {
    Picture,
    DeleteFilled
  },
  emits: ["onFileChange", "onCancel"],
  props: {
    prevURL: {
      type: String,
      default: ""
    }
  },
  setup(props, context) {
    const imgURL = ref("");
    const isShowPrev = ref(false);
    const isShowMask = ref(false);
    if (props.prevURL.trim().length !== 0) {
      let prevURLTmp = ref(props.prevURL);
      imgURL.value = prevURLTmp.value;
      isShowPrev.value = true;
    }
    const fileChange = (e: Event) => {
      const tar = e.target as HTMLInputElement;
      if (tar.files) {
        if (!tar.files[0].type.includes("image")) {
          ElMessage({
            message: "请选择图片",
            type: "warning"
          });
        } else {
          imgURL.value = URL.createObjectURL(tar.files[0]);
          isShowPrev.value = true;
          context.emit("onFileChange", tar.files[0]);
        }
      }
    };
    const maskLeave = () => {
      isShowMask.value = false;
    };
    const maskEnter = () => {
      isShowMask.value = true;
    };
    const maskClick = () => {
      isShowMask.value = false;
      isShowPrev.value = false;
      imgURL.value = "";
      context.emit("onCancel");
    };
    return {
      imgURL,
      fileChange,
      isShowPrev,
      isShowMask,
      maskEnter,
      maskLeave,
      maskClick
    };
  }
});
</script>

<style scoped lang="less">
.img-prev-outer {
  height: 100%;
  width: 100%;
  background-color: rgba(220, 223, 230, 0.3);
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  img {
    height: 100%;
    position: absolute;
  }
  & > input {
    opacity: 0;
    width: 100%;
    height: 100%;
    z-index: 999;
  }
  .el-icon {
    position: absolute;
    font-size: 30px;
    color: #00a1d6;
  }
  .mask {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.4);
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 999999;
    cursor: pointer;
  }
}
</style>
