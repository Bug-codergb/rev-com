import { reactive } from "vue";
import { FormRules } from "element-plus";

const formShape = {
  row: [
    [
      {
        field: "name",
        name: "奖项名称",
        shape: "input",
        placeholder: "请输入奖项名称",
        span: 12
      },
      {
        field: "area",
        name: "区域",
        shape: "input",
        placeholder: "请输入地区",
        span: 12
      }
    ],
    [
      {
        field: "established",
        name: "创办时间",
        shape: "time",
        placeholder: "请选择创办时间",
        span: 12
      },
      {
        field: "alias",
        name: "别名",
        shape: "input",
        placeholder: "请输入别名",
        span: 12
      }
    ],
    [
      {
        field: "description",
        name: "简介",
        shape: "input",
        placeholder: "请输入简介",
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
};
const rules = reactive<FormRules>({
  name: [
    {
      required: true,
      message: "请输入奖项名称",
      trigger: "blur"
    }
  ],
  description: [
    {
      required: true,
      message: "请输入奖项简介",
      trigger: "blur"
    }
  ],
  area: [
    {
      required: true,
      message: "请输入地区",
      trigger: "blur"
    }
  ],
  alias: [
    {
      required: true,
      message: "请输入别名",
      trigger: "blur"
    }
  ],
  established: [
    {
      required: true,
      message: "请选择发布时间",
      trigger: "change"
    }
  ]
});
export { formShape, rules };
