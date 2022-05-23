<template>
  <div class="add-movie">
    <el-form
      ref="ruleFormRef"
      :model="movie"
      :rules="rules"
      label-width="80px"
      label-position="top"
      class="demo-ruleForm"
    >
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="名称" prop="name">
            <el-input v-model="movie.name" placeholder="请输入电影名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="语言" prop="language">
            <el-select
              v-model="movie.language"
              placeholder="请输入语言"
              style="width: 100%"
              multiple
              multiple-limit="4"
              clearable
              filterable
            >
              <template v-for="item in languages" :key="item">
                <el-option :value="item" :label="item"></el-option>
              </template>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="上映时间" prop="releaseTime">
            <el-date-picker
              v-model="movie.releaseTime"
              type="date"
              style="width: 100%"
              placeholder="选择上映时间"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="别名" prop="alias">
            <el-input v-model="movie.alias" placeholder="请输入电影别名" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="形式" prop="form">
            <el-select
              v-model="movie.form"
              style="width: 100%"
              filterable
              placeholder="请选择电影形式"
            >
              <el-option
                v-for="item in formList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地区" prop="area">
            <el-select
              v-model="movie.area"
              style="width: 100%"
              filterable
              placeholder="请选择电影地区"
              multiple
              multiple-limit="4"
            >
              <el-option
                v-for="item in areaList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="类型" prop="cate">
            <el-select
              v-model="movie.cate"
              class="m-2"
              filterable
              style="width: 100%"
              placeholder="请选择电影类型"
              multiple
              multiple-limit="4"
            >
              <el-option
                v-for="item in cateList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item prop="actor" label="演员">
            <el-select
              v-model="movie.actor"
              class="m-2"
              filterable
              style="width: 100%"
              multiple
              multiple-limit="8"
              placeholder="请选择电影演员"
            >
              <el-option
                v-for="item in actorList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item prop="director" label="导演">
            <el-select
              v-model="movie.director"
              class="m-2"
              filterable
              style="width: 100%"
              multiple
              multiple-limit="8"
              placeholder="请选择电影导演"
            >
              <el-option
                v-for="item in directorList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item prop="screenwriter" label="编剧">
            <el-select
              v-model="movie.screenwriter"
              class="m-2"
              filterable
              style="width: 100%"
              multiple
              multiple-limit="8"
              placeholder="请选择电影编剧"
            >
              <el-option
                v-for="item in screenwriterList.list"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item prop="desc" label="简介">
            <el-input
              placeholder="请输入简介"
              :maxlength="100"
              type="textarea"
              v-model="movie.desc"
              :autosize="{ minRows: 4, maxRows: 5 }"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="24">
        <el-col>
          <el-form-item label="电影封面">
            <div class="movie-cover" style="width: 100%">
              <img-prev @onCancel="cancel" @onFileChange="fileChange" :prevURL="prevURL" />
            </div>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, ref, toRefs } from "vue"
import { FormInstance, FormRules } from "element-plus"

import { IResponseType } from "@/types/responseType"
import { IForm } from "@/types/form"
import { getAllForm } from "@/network/movie/form"
import { IArea } from "@/types/area"
import { getAllArea } from "@/network/movie/area"
import { ICategory } from "@/types/category"
import { getAllCate } from "@/network/movie/cate"
import { IActor } from "@/types/actor"
import { getAllActor } from "@/network/actor"
import { IPageResult } from "@/types/pageResult"
import { IDirector } from "@/types/director"
import { getAllDirector } from "@/network/director"
import { IScreenwriter } from "@/types/screenwriter"
import { getAllScreenwriter } from "@/network/screenwriter"
import ImgPrev from "@/components/common/imgPrev/ImgPrev.vue"
import languages from "@/constant/language"
export default defineComponent({
  name: "AddMovie",
  components: {
    ImgPrev
  },
  props: {
    movieItem: {
      type: Object
    }
  },
  setup(props, context) {
    const isUpdate = ref(false)
    const ruleFormRef = ref<FormInstance>()
    const movie = reactive({
      name: "",
      alias: "",
      language: [],
      releaseTime: "",
      form: "",
      area: [],
      cate: [],
      actor: [],
      director: [],
      screenwriter: [],
      desc: ""
    })
    const cover = reactive<{ source: FormData | null }>({
      source: null
    })
    const formList = reactive<{ list: IForm[] }>({
      list: []
    })
    const areaList = reactive<{ list: IArea[] }>({
      list: []
    })
    const cateList = reactive<{ list: ICategory[] }>({
      list: []
    })
    const actorList = reactive<{ list: IActor[] }>({
      list: []
    })
    const directorList = reactive<{ list: IDirector[] }>({
      list: []
    })
    const screenwriterList = reactive<{ list: IScreenwriter[] }>({
      list: []
    })
    const desc = ref("")
    const prevURL = ref("")
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入导演名称",
          trigger: "blur"
        }
      ],
      language: [
        {
          required: true,
          message: "请输入语言",
          trigger: "change"
        }
      ],
      alias: [
        {
          required: true,
          message: "请输入别名",
          trigger: "blur"
        }
      ],
      releaseTime: [
        {
          required: true,
          message: "请选择上映时间",
          trigger: "change"
        }
      ],
      form: [
        {
          required: true,
          message: "请选择电影形式",
          trigger: "change"
        }
      ],
      area: [
        {
          required: true,
          message: "请选择电影地区",
          trigger: "change"
        }
      ],
      cate: [
        {
          required: true,
          message: "请选择电影分类",
          trigger: "change"
        }
      ],
      actor: [
        {
          required: true,
          message: "请选择电影演员",
          trigger: "change"
        }
      ],
      director: [
        {
          required: true,
          message: "请选择电影导演",
          trigger: "change"
        }
      ],
      screenwriter: [
        {
          required: true,
          message: "请选择电影编剧",
          trigger: "change"
        }
      ],
      desc: [
        {
          required: true,
          message: "请输入电影简介",
          trigger: "blur"
        }
      ]
    })

    onMounted(async () => {
      getAllForm<IResponseType<IForm[]>>().then((data) => {
        if (data.status === 200) {
          formList.list = data.data
        }
      })
      getAllArea<IResponseType<IArea[]>>().then((data) => {
        if (data.status === 200) {
          areaList.list = data.data
        }
      })
      getAllCate<IResponseType<ICategory[]>>().then((data) => {
        if (data.status === 200) {
          cateList.list = data.data
        }
      })
      getAllActor<IResponseType<IPageResult<IActor[]>>>(1, 50000, "").then((data) => {
        if (data.status === 200) {
          actorList.list = data.data.data
        }
      })
      getAllDirector<IResponseType<IPageResult<IDirector[]>>>(1, 5000, "").then((data) => {
        if (data.status === 200) {
          directorList.list = data.data.data
        }
      })
      getAllScreenwriter<IResponseType<IPageResult<IScreenwriter[]>>>(1, 5000, "").then((data) => {
        if (data.status === 200) {
          screenwriterList.list = data.data.data
        }
      })
    })
    if (props.movieItem && props.movieItem.item && props.movieItem.item.id) {
      let movieTmp = toRefs(props.movieItem.item)
      if (movieTmp.coverUrl.value) {
        prevURL.value = movieTmp.coverUrl.value
      }
      movie.name = movieTmp.name.value
      movie.alias = movieTmp.alias.value
      movie.language = movieTmp.language.value
      movie.releaseTime = movieTmp.releaseTime.value
      movie.form = movieTmp.form.value.id
      movie.area = movieTmp.area.value.map((item: IArea) => item.id)
      movie.cate = movieTmp.categories.value.map((item: ICategory) => item.id)
      movie.actor = movieTmp.actors.value.map((item: IActor) => item.id)
      movie.director = movieTmp.directors.value.map((item: IDirector) => item.id)
      movie.screenwriter = movieTmp.screenwriters.value.map((item: IDirector) => item.id)
      movie.desc = movieTmp.description.value
      isUpdate.value = true
    }
    const cancel = () => {
      cover.source = null
    }
    const fileChange = (file: File) => {
      let formData = new FormData()
      formData.append("cover", file)
      cover.source = formData
    }
    return {
      movie,
      rules,
      ruleFormRef,
      formList,
      areaList,
      cateList,
      actorList,
      directorList,
      screenwriterList,
      desc,
      cancel,
      fileChange,
      cover,
      isUpdate,
      prevURL,
      languages
    }
  }
})
</script>

<style scoped lang="less">
.add-movie {
  .movie-cover {
    height: 120px;
  }
}
</style>
