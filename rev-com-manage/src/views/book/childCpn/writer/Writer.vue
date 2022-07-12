<template>
  <div class="writer">
    <div class="writer-header">
      <PageItemList
        :keyword-list="keywordList"
        add-name="添加作家"
        @showDrawer="showDrawer"
        @keywordChange="keywordChange"
      />
    </div>
    <div class="actor-list">
      <template v-if="writerList.list && writerList.list.length > 0">
        <el-table :data="writerList.list" :height="490" row-key="id">
          <el-table-column
            :show-overflow-tooltip="true"
            prop="name"
            label="作家名称"
            min-width="130"
          />
          <el-table-column :show-overflow-tooltip="true" prop="gender" label="性别" width="100">
            <template #default="scope">
              {{ scope.row.gender * 1 === 0 ? "男" : "女" }}
            </template>
          </el-table-column>
          <el-table-column
            :show-overflow-tooltip="true"
            prop="foreignName"
            label="外文名"
            width="140"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="alias"
            label="别名"
            min-width="130"
          />
          <el-table-column :show-overflow-tooltip="true" prop="birth" label="生日" width="130">
            <template #default="scope">
              <span v-format="'yyyy-MM-dd'">{{ scope.row.birth }}</span>
            </template>
          </el-table-column>
          <el-table-column
            :show-overflow-tooltip="true"
            prop="birthPlace"
            label="出生地"
            width="130"
          />
          <el-table-column :show-overflow-tooltip="true" prop="area" label="地区" width="100" />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="createTime"
            label="创建时间"
            min-width="120"
            :sortable="true"
          >
            <template #default="scope">
              <span v-format="'yyyy-MM-dd hh:mm'">{{ scope.row.createTime }}</span>
            </template>
          </el-table-column>

          <el-table-column fixed="right" label="操作" width="140">
            <template #default="scope">
              <el-button type="text" size="small" class="table-control-btn">查看</el-button>
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="editWriter(scope.row)"
                >编辑</el-button
              >
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="deleteWriterHandle(scope.row)"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </template>
    </div>
    <template v-if="total > 10">
      <div class="page">
        <el-pagination
          background
          @current-change="pageChange"
          layout="prev, pager, next"
          :total="total"
          :page-size="10"
        />
      </div>
    </template>
    <el-drawer
      v-model="drawer"
      :direction="direction"
      :show-close="false"
      :destroy-on-close="true"
      size="45%"
    >
      <template #title>
        <div class="drawer-title-outer">
          <div class="title">添加作家</div>
          <button class="drawer-define-btn" @click="define">确定</button>
        </div>
      </template>
      <add-writer ref="addWriter" />
    </el-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted, reactive } from "vue";
import PageItemList from "@/components/content/pageItemList/PageItemList.vue";
import AddWriter from "@/views/book/childCpn/writer/childCpn/addWriter/AddWriter.vue";
import { createWriter, getAllWriter } from "@/network/book/writer";
import { ElMessage } from "element-plus/lib/components";
import { IResponseType } from "@/types/responseType";
import { IPageResult } from "@/types/pageResult";
import { IWriter } from "@/types/book/writer";
import { debounce } from "@/utils/debounce";
export default defineComponent({
  name: "Writer",
  components: {
    PageItemList,
    AddWriter
  },
  setup() {
    const keyword = ref("");
    const total = ref(0);
    const writerList = reactive<{ list: IWriter[] | null }>({
      list: null
    });
    const addWriter = ref<InstanceType<typeof AddWriter>>();
    const drawer = ref(false);
    const direction = ref("rtl");
    const keywordList = [{ id: 1, keyword: "请输入人", placeholder: "请输入作家名称" }];
    const getAllWriterRequest = async (page: number, limit: number, keyword: string) => {
      const data = await getAllWriter<IResponseType<IPageResult<IWriter[]>>>(page, limit, keyword);
      if (data.status === 200) {
        total.value = data.data.total;
        writerList.list = data.data.data;
      }
    };
    onMounted(async () => {
      await getAllWriterRequest(1, 10, keyword.value);
    });
    const editWriter = () => {};
    const deleteWriterHandle = () => {};
    const define = () => {
      if (addWriter.value && addWriter.value.ruleFormRef && addWriter.value.writer) {
        addWriter.value.ruleFormRef.validate(async (e: boolean) => {
          if (e) {
            if (addWriter.value) {
              const { alias, area, birth, birthPlace, description, foreignName, gender, name } =
                addWriter.value.writer;
              const data = await createWriter(
                name,
                gender,
                birth,
                birthPlace,
                area,
                foreignName,
                alias,
                description
              );
              if (data.status === 200) {
                ElMessage({
                  type: "success",
                  message: "作家添加成功"
                });
                drawer.value = false;
                getAllWriterRequest(1, 10, keyword.value);
              }
            }
          }
        });
      }
    };
    const showDrawer = () => {
      drawer.value = true;
    };
    const pageChange = async (e: number) => {
      await getAllWriterRequest(e, 10, keyword.value);
    };
    const keywordChange = debounce(
      (keywords: string[]) => {
        keyword.value = keywords[0];
        getAllWriterRequest(1, 10, keyword.value);
      },
      1000,
      false
    );
    return {
      keywordList,
      drawer,
      direction,
      define,
      showDrawer,
      addWriter,
      writerList,
      total,
      editWriter,
      deleteWriterHandle,
      pageChange,
      keywordChange
    };
  }
});
</script>

<style scoped lang="less">
.writer {
  .page {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 15px 0;
  }
}
</style>
