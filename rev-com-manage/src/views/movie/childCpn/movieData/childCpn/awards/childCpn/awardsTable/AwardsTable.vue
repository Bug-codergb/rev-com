<template>
  <template v-if="props.awards && props.awards.list && props.awards.list.length">
    <el-table :data="props.awards.list" row-key="id" :height="410">
      <el-table-column prop="id" label="奖项id" show-overflow-tooltip width="160" />
      <el-table-column prop="name" label="奖项名称" show-overflow-tooltip width="160" />
      <el-table-column
        prop="established"
        label="奖项成立时间"
        show-overflow-tooltip
        width="160"
        sortable
      >
        <template #default="scope">
          <span v-format="'yyyy-MM-dd hh:mm'" :key="scope.row.established">{{
            scope.row.established
          }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="alias" label="奖项别名" width="160" show-overflow-tooltip />
      <el-table-column prop="area" label="地区" width="140" show-overflow-tooltip />
      <el-table-column prop="description" label="简介" width="140" show-overflow-tooltip />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="text" size="small">查看</el-button>
          <el-button type="text" size="small" @click="editHandle(scope.row)">编辑</el-button>
          <el-button type="text" size="small" @click="deleteAwardsHandle(scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </template>
</template>

<script lang="ts" setup>
import { defineProps, defineEmits } from "vue";
import { IAwards } from "@/types/awards";
import { ElMessage, ElMessageBox } from "element-plus";
import { deleteAwards } from "@/network/awards";
const props = defineProps({
  awards: {
    type: Array,
    default() {
      return [];
    }
  }
});
const emit = defineEmits(["awards-edit", "awards-delete"]);
const editHandle = (item: IAwards) => {
  emit("awards-edit", item);
};
const deleteAwardsHandle = (item: IAwards) => {
  ElMessageBox.confirm(`确定要删除${item.name}吗?`, "提示", {
    confirmButtonText: "确定",
    cancelButtonText: "取消",
    type: "warning"
  })
    .then(() => {
      deleteAwards(item.id).then(() => {
        emit("awards-delete");
        ElMessage.success("删除成功");
      });
    })
    .catch(() => {});
};
</script>

<style scoped></style>
