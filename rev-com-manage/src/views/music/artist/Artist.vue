<template>
  <div class="artist">
    <template v-if="selectList.list.length">
      <PageItemList
        add-name="添加歌手"
        :keyword-list="keywordList"
        :select-list="selectList.list"
        @keywordChange="keywordChange"
        @selectChange="selectChange"
        @refresh="refresh"
        @showDrawer="showDrawer"
      />
    </template>
    <div class="artist-list">
      <template v-if="artist.list.length !== 0">
        <el-table :data="artist.list" :height="490" row-key="id">
          <el-table-column :show-overflow-tooltip="true" prop="id" label="歌手ID" width="140" />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="avatarUrl"
            label="歌手头像"
            width="80"
          >
            <template #default="scope">
              <el-image :src="scope.row.avatarUrl" style="height: 40px">
                <template #error> </template>
              </el-image>
            </template>
          </el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="name" label="歌手名称" />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="area.name"
            label="歌手分类"
            width="100"
          />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="type.name"
            label="歌手类型"
            width="100"
          />
          <el-table-column :show-overflow-tooltip="true" prop="description" label="简介" />
          <el-table-column
            :show-overflow-tooltip="true"
            prop="createTime"
            label="创建时间"
            width="150"
          >
            <template #default="scope">
              <span v-format="'yyyy-MM-dd hh:mm'">{{ scope.row.createTime }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="text" size="small" class="table-control-btn">查看</el-button>
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="editArtist(scope.row)"
                >编辑</el-button
              >
              <el-button
                type="text"
                size="small"
                class="table-control-btn"
                @click="deleteArtistHandle(scope.row)"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </template>
    </div>
    <template v-if="total > pageCount">
      <div class="page">
        <el-pagination
          background
          @current-change="pageChange"
          layout="prev,pager,next"
          :total="total"
          :page-size="pageCount"
        />
      </div>
    </template>
    <g-b-drawer title="添加歌手" v-model="drawer">
      <template #add>
        <add-artist
          :type="artistCate.type"
          :cate="artistCate.cate"
          :artist-item="artistItem"
          @closeDrawer="drawer = false"
          @refresh="refresh"
        />
      </template>
    </g-b-drawer>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref } from "vue";
import PageItemList from "@/components/content/pageItemList/PageItemList.vue";
import {
  deleteArtist,
  getAllArtist,
  getAllArtistCate,
  getAllArtistType
} from "@/network/music/artist";
import { ICategory } from "@/types/music/artist/category";
import { IArtistType } from "@/types/music/artist/type";
import { ISelect } from "@/views/music/artist/types/types";
import { IResponseType } from "@/types/responseType";
import { debounce } from "@/utils/debounce";
import { IArtist } from "@/types/music/artist/artist";
import { IPageResult } from "@/types/pageResult";
import AddArtist from "@/views/music/artist/childCpn/addArtist/AddArtist.vue";
import GBDrawer from "@/components/common/gbDrawer/GBDrawer.vue";
import { ElMessageBox, ElMessage } from "element-plus";
export default defineComponent({
  name: "Artist",
  components: { GBDrawer, AddArtist, PageItemList },
  setup(props, context) {
    const total = ref(0);
    const keyword = ref("");
    const area = ref("");
    const type = ref("");
    const drawer = ref(false);
    const artist = reactive<{ list: IArtist[] }>({
      list: []
    });
    const artistCate = reactive<{
      cate: { label: string; value: string }[];
      type: { label: string; value: string }[];
    }>({
      cate: [],
      type: []
    });
    const artistItem = reactive<{ item: IArtist | null }>({
      item: null
    });
    const pageCount = 7;
    const keywordList = [{ id: 1, keyword: "", placeholder: "请输入歌手名称" }];
    let selectList = reactive<{ list: ISelect[] }>({
      list: []
    });
    const getAllArtistRequest = async (
      page: number,
      limit: number,
      keyword: string,
      area: string,
      type: string
    ) => {
      const data = await getAllArtist<IResponseType<IPageResult<IArtist[]>>>(
        page,
        limit,
        keyword,
        area,
        type
      );
      if (data.status === 200) {
        total.value = data.data.total;
        artist.list = data.data.data;
      }
    };
    onMounted(async () => {
      const cateRes = await getAllArtistCate<IResponseType<ICategory[]>>();
      if (cateRes.status === 200) {
        artistCate.cate = cateRes.data.map((item) => {
          return {
            label: item.name,
            value: item.id
          };
        });
      }
      const typeRes = await getAllArtistType<IResponseType<IArtistType[]>>();
      if (typeRes.status === 200) {
        artistCate.type = typeRes.data.map((item) => {
          return {
            label: item.name,
            value: item.id
          };
        });
      }
      selectList.list = [
        { id: 1, select: "", placeholder: "请选择歌手分类", list: artistCate.cate },
        {
          id: 2,
          select: "",
          placeholder: "请选择歌手类型",
          list: artistCate.type
        }
      ];
      await getAllArtistRequest(1, pageCount, keyword.value, area.value, type.value);
    });
    const keywordChange = debounce(
      (keywords: string[]) => {
        keyword.value = keywords[0];
        getAllArtistRequest(1, pageCount, keyword.value, area.value, type.value);
      },
      1000,
      false
    );
    const selectChange = (e: string[]) => {
      area.value = e[0];
      type.value = e[1];
      getAllArtistRequest(1, pageCount, keyword.value, area.value, type.value);
    };
    const refresh = () => {
      keyword.value = "";
      area.value = "";
      type.value = "";
      getAllArtistRequest(1, pageCount, keyword.value, area.value, type.value);
    };
    const pageChange = (e: number) => {
      getAllArtistRequest(e, pageCount, keyword.value, area.value, type.value);
    };
    const showDrawer = () => {
      drawer.value = true;
      artistItem.item = null;
    };
    const editArtist = (item: IArtist) => {
      artistItem.item = item;
      drawer.value = true;
    };
    //删除歌手信息
    const deleteArtistHandle = (item: IArtist) => {
      ElMessageBox.confirm("确定要删除么?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(async () => {
          const data = await deleteArtist<IResponseType<any>>(item.id);
          if (data.status === 200) {
            ElMessage.success({
              message: "歌手删除成功",
              duration: 1500
            });
            refresh();
          }
        })
        .catch(() => {});
    };
    return {
      artist,
      total,
      pageCount,
      artistCate,
      keywordList,
      selectList,
      keywordChange,
      selectChange,
      refresh,
      drawer,
      showDrawer,
      pageChange,
      editArtist,
      artistItem,
      deleteArtistHandle
    };
  }
});
</script>

<style scoped lang="less"></style>
