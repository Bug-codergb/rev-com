<template>
  <div class="book-cate">
    <el-row :gutter="12">
      <el-col :span="19">
        <template v-for="item in cateList.list" :key="item.id">
          <el-card style="margin: 0 0 20px 0">
            <template #header>
              <div class="cate-header">
                <span>{{ item.name }}</span>
                <div>
                  <el-icon><CloseBold /></el-icon>
                </div>
              </div>
            </template>
            <template v-if="item.bookCateChList.length > 0">
              <ul class="cate-ch-list">
                <li v-for="it in item.bookCateChList" :key="it.id">
                  {{ it.name }}
                </li>
              </ul>
            </template>
            <template v-else> 暂无 </template>
          </el-card>
        </template>
      </el-col>
      <el-col :span="5">
        <el-card>
          <el-collapse accordion>
            <template v-for="(item, index) in cateList.list" :key="item.id">
              <el-collapse-item
                :title="item.name + '(' + item.bookCateChList.length + ')'"
                :name="index"
              >
                <template v-if="item.bookCateChList.length > 1">
                  <div v-for="it in item.bookCateChList" :key="it.id" class="cate-list-collapse">
                    <span>{{ it.name }}</span>
                    <div class="del-cate-ch">
                      <el-icon><Edit /></el-icon>
                      <el-icon @click="delCateChHandle(it)"><Delete /></el-icon>
                    </div>
                  </div>
                </template>
                <template v-else> 暂无 </template>
              </el-collapse-item>
            </template>
          </el-collapse>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, onMounted } from "vue";
import { deleteCateCh, getAllCate } from "@/network/book/bookCate";
import { IBookCate, IBookCateCh } from "@/types/book/bookCate";
import { CloseBold, Delete, Edit } from "@element-plus/icons-vue";
import { ElMessage, ElMessageBox } from "element-plus";

export default defineComponent({
  name: "BookCate",
  components: {
    CloseBold,
    Delete,
    Edit
  },
  setup() {
    const cateList = reactive<{ list: IBookCate[] }>({
      list: []
    });
    onMounted(async () => {
      const data = await getAllCate();
      if (data.status === 200) {
        console.log(data.data);
        cateList.list = data.data;
      }
    });
    const delCateChHandle = async (it: IBookCateCh) => {
      console.log(it);
      ElMessageBox.confirm(`确定要删除 ${it.name}吗?`, "tip", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      }).then(async () => {
        const data = await deleteCateCh(it.id);
        if (data.status === 200) {
          ElMessage({
            type: "success",
            message: "删除成功"
          });
        }
      });
    };
    return {
      cateList,
      delCateChHandle
    };
  }
});
</script>

<style scoped lang="less">
.book-cate {
  .cate-header {
    display: flex;
    justify-content: space-between;
  }
  .cate-ch-list {
    display: flex;
    & > li {
      margin: 0 15px 10px 0;
      color: #00a1d6;
      cursor: pointer;
    }
  }
  .cate-list-collapse {
    display: flex;
    justify-content: space-between;
    padding: 3px 4px;
    align-items: center;
    border-radius: 3px;
    .del-cate-ch {
      display: none;
      i {
        font-size: 16px;
        margin: 0 5px 0 0;
      }
    }
    &:hover {
      background-color: rgba(0, 161, 214, 1);
      cursor: pointer;
      color: #fff;
      .del-cate-ch {
        display: flex;
        align-items: center;
      }
    }
  }
}
</style>
