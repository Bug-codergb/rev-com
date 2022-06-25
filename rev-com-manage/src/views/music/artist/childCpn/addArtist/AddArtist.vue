<template>
  <div>
    <add-info
      v-model:modelValue="formData.artist"
      :rules="rules"
      :form-shape="formShape"
      :prev-u-r-l="prevURL"
      ref="addArtistRef"
    />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, toRefs } from "vue"
import AddInfo from "@/components/content/addInfo/AddInfo.vue"
import { FormRules, ElMessage } from "element-plus"
import emitter from "@/utils/evenBus"
import { debounce } from "@/utils/debounce"
import { createArtist, updateArtist, updateAvatar, uploadAvatar } from "@/network/music/artist"
export default defineComponent({
  name: "AddArtist",
  components: { AddInfo },
  props: {
    cate: {
      type: Array,
      required: true
    },
    type: {
      type: Array,
      required: true
    },
    artistItem: {
      type: Object
    }
  },
  emits: ["closeDrawer", "refresh"],
  setup(props, context) {
    const drawer = ref<boolean>(true)
    const addArtistRef = ref<InstanceType<typeof AddInfo>>()
    const prevURL = ref("")
    const isUpdate = ref<boolean>(false)
    const formData = reactive({
      artist: {
        name: "",
        description: "",
        typeId: "",
        cateId: ""
      }
    })
    const formShape = reactive({
      row: [
        [
          {
            field: "name",
            name: "歌手名称",
            shape: "input",
            placeholder: "请输入歌手名称",
            span: 24,
            type: "text"
          }
        ],
        [
          {
            field: "cateId",
            name: "歌手分类",
            shape: "select",
            placeholder: "请选择歌手分类",
            span: 12,
            selectList: props.cate
          },
          {
            field: "typeId",
            name: "歌手类型",
            shape: "select",
            placeholder: "请选择歌手类型",
            span: 12,
            selectList: props.type
          }
        ],
        [
          {
            field: "description",
            name: "歌手简介",
            shape: "input",
            placeholder: "请输入歌手简介",
            span: 24,
            type: "textarea"
          }
        ],
        [
          {
            field: "avatar",
            name: "歌手头像",
            shape: "upload"
          }
        ]
      ]
    })
    const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: "请输入歌手名称",
          trigger: "blur"
        }
      ],
      description: [
        {
          required: true,
          message: "请输入歌手简介",
          trigger: "blur"
        }
      ],
      typeId: [
        {
          required: true,
          message: "请选择歌手类型",
          trigger: "change"
        }
      ],
      cateId: [
        {
          required: true,
          message: "请选择歌手分类",
          trigger: "change"
        }
      ]
    })

    if (
      props.artistItem &&
      props.artistItem.item &&
      Reflect.ownKeys(props.artistItem.item).length !== 0 &&
      props.artistItem.item.id
    ) {
      const artist = toRefs(props.artistItem.item)
      if (artist.avatarUrl.value) {
        prevURL.value = artist.avatarUrl.value
      }
      formData.artist.name = artist.name.value
      formData.artist.description = artist.description.value
      formData.artist.typeId = artist.type.value.id
      formData.artist.cateId = artist.area.value.id
      isUpdate.value = true
    }

    emitter.on(
      "drawerDefine",
      debounce(
        () => {
          if (addArtistRef.value && addArtistRef.value.ruleFormRef) {
            addArtistRef.value.ruleFormRef.validate(async (e: boolean) => {
              if (e) {
                const { name, description, typeId, cateId } = formData.artist
                if (!isUpdate.value) {
                  const data = await createArtist(name, description, typeId, cateId)
                  if (data.status === 200) {
                    context.emit("closeDrawer")
                    ElMessage.success({
                      message: "歌手添加成功",
                      duration: 1500
                    })
                    const { id } = data.data
                    if (addArtistRef.value) {
                      const { avatar } = addArtistRef.value
                      if (avatar.source instanceof FormData) {
                        const data = await uploadAvatar(id, avatar.source)
                      }
                    }
                    context.emit("refresh")
                  }
                } else {
                  //更新歌手信息
                  if (props.artistItem && props.artistItem.item) {
                    const data = await updateArtist(
                      props.artistItem.item.id,
                      name,
                      description,
                      typeId,
                      cateId
                    )
                    if (data.status === 200) {
                      ElMessage.success({
                        message: "歌手更新成功",
                        duration: 1500
                      })
                      context.emit("refresh")
                      context.emit("closeDrawer")
                      if (addArtistRef.value && props.artistItem.item && props.artistItem.item.id) {
                        const { avatar } = addArtistRef.value
                        if (avatar.source instanceof FormData) {
                          const data = await updateAvatar(props.artistItem.item.id, avatar.source)
                        }
                      }
                    }
                  }
                }
              }
            })
          }
        },
        500,
        false
      )
    )
    return {
      formData,
      rules,
      formShape,
      drawer,
      addArtistRef,
      prevURL,
      isUpdate
    }
  }
})
</script>

<style scoped lang="less"></style>
