<template>
  <div class="page-item-list">
    <div class="page-item-list-header">
      <div class="page-item-list-header-left">
        <template v-for="(item, index) in keywordList" :key="item.id">
          <div class="search-outer">
            <el-input
              v-model="bindParam.keyword[index]"
              :placeholder="item.placeholder"
              clearable
              @input="keywordInput"
            />
          </div>
        </template>
        <template v-for="(item, index) in selectList" :key="item.id">
          <div class="change-outer">
            <el-select
              v-model="bindParam.select[index]"
              :placeholder="item.placeholder"
              @change="changeSelect"
            >
              <el-option
                v-for="it in item.list"
                :key="it.id"
                :label="it.label"
                :value="it.value"
              ></el-option>
            </el-select>
          </div>
        </template>
        <div class="add-btn">
          <el-button type="primary" @click="showDrawer">{{ addName }}</el-button>
        </div>
      </div>
      <template v-if="isShowRefresh">
        <div class="page-item-list-header-right">
          <el-icon :class="{ active: isRotate }" @click="changeRotate"><refresh /></el-icon>
        </div>
      </template>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref } from "vue";
import { Refresh } from "@element-plus/icons-vue";
export default defineComponent({
  name: "PageItemList",
  components: { Refresh },
  props: {
    keywordList: {
      type: Array
    },
    selectList: {
      type: Array
    },
    isShowRefresh: {
      type: Boolean,
      default: true
    },
    addName: {
      type: String,
      default: "添加"
    }
  },
  emits: ["keywordChange", "selectChange", "refresh", "showDrawer"],
  setup(props, context) {
    const bindParam = reactive<{ keyword: string[]; select: string[] }>({
      keyword: [],
      select: []
    });
    const isRotate = ref(false);
    const init = () => {
      if (props.keywordList) {
        for (let item of props.keywordList) {
          bindParam.keyword.push("");
        }
      }
      if (props.selectList) {
        for (let item of props.selectList) {
          bindParam.select.push("");
        }
      }
    };
    init();
    const keywordInput = () => {
      context.emit("keywordChange", bindParam.keyword);
    };
    const changeSelect = () => {
      context.emit("selectChange", bindParam.select);
    };
    const changeRotate = () => {
      isRotate.value = true;
      context.emit("refresh");
      bindParam.keyword = [];
      bindParam.select = [];
      init();
      setTimeout(() => {
        isRotate.value = false;
      }, 2000);
    };
    const showDrawer = () => {
      context.emit("showDrawer");
    };
    return {
      keywordInput,
      changeSelect,
      bindParam,
      isRotate,
      changeRotate,
      showDrawer
    };
  }
});
</script>

<style scoped lang="less">
.page-item-list {
  .page-item-list-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid #dcdfe6;
    padding: 0 0 15px 0;
    .page-item-list-header-left {
      display: flex;
      align-items: center;
      .add-btn {
        margin: 0 0 0 10px;
        .el-button {
          padding: 19px 20px;
        }
      }
    }
    .page-item-list-header-right {
      background-color: #00a1d6;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 5px;
      border-radius: 4px;
      cursor: pointer;
      @keyframes test {
        from {
          transform: rotateZ(0deg);
        }
        to {
          transform: rotateZ(-360deg);
        }
      }
      .el-icon {
        font-size: 24px;
        color: #fff;
        &.active {
          animation: test 1s linear 0s 1;
        }
      }
    }
    .search-outer {
      margin: 0 20px 0 0;
      .el-input {
        width: 100%;
      }
    }
    .change-outer {
      margin: 0 20px 0 0;
      .el-select {
        width: 100%;
      }
    }
  }
}
</style>
